package accounts;

import persons.customers.Customer;

public class StudentAccount extends BaseBankAccount {
    private String SchoolName;

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, String SchoolName) {
        super(uuid, bankAccountNumber, customer, 0);
        this.SchoolName = SchoolName;
    }

    public String getSchoolName() {
        return SchoolName;
    }
}
