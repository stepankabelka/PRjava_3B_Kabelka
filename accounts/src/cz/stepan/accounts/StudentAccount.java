package cz.stepan.accounts;

import cz.stepan.customers.Customer;

public class StudentAccount extends BankAccount {
    private final String SchoolName;

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, String SchoolName) {
        super(uuid, bankAccountNumber, customer);
        this.SchoolName = SchoolName;
    }

    public String getSchoolName() {return SchoolName;
    }
}
