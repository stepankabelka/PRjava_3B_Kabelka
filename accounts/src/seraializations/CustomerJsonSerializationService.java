package seraializations;

import com.google.gson.Gson;
import persons.customers.Customer;

public class CustomerJsonSerializationService implements Serialization{

    CustomerSerializationFactory csf = new CustomerSerializationFactory();
    Gson gson = new Gson();

    @Override
    public String serialization(Object customer){
        if (!(customer instanceof Customer)) {
            throw new IllegalArgumentException("Not a Customer object");
        }

        CustomerSerialization ser = csf.createCustomerSerialization(((Customer) customer).getUuid(),  ((Customer) customer).getFirstName(), ((Customer) customer).getLastName());

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"uuid\":\"").append(ser.uuid).append("\",");
        sb.append("\"firstName\":\"").append(ser.firstName).append("\",");
        sb.append("\"lastName\":\"").append(ser.lastName).append("\"");
        sb.append("}");

        return gson.toJson(ser);
    }

    @Override
    public Customer deserialization(String serialization){

        return gson.fromJson(serialization, Customer.class);
    }
}
