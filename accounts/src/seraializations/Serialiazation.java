package seraializations;

public interface Serialiazation {

    public String serialize(Object bankAccount);

    public Object deserialize(String bankAccount);
}
