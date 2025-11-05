package cz.stepan.accounts;

import com.google.inject.Inject;
import cz.stepan.generators.AccnumGen;
import cz.stepan.customers.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountFactory {

        @Inject
        public AccnumGen accnumGen;




        public BaseBankAccount createBaseBankAccount(String uuid, Customer customer, double balance) {
            String accountNumber = accnumGen.generateAccountNumber();

            return new BaseBankAccount(uuid, accountNumber, customer, balance);
        }

        public StudentAccount createStudentAccount(String uuid, Customer customer, String studentOf) {
            String accountNumber = accnumGen.generateAccountNumber();

            return new StudentAccount(uuid, accountNumber, customer, studentOf);
        }

        public BankAccount createBankAccount(String uuid, Customer customer) {
            String accountNumber = accnumGen.generateAccountNumber();

            return new BankAccount(uuid, accountNumber, customer);
        }

        public SaveAccount createSaveAccount(String uuid,Customer customer, float interestRate) {
            String accountNumber = accnumGen.generateAccountNumber();
            return new SaveAccount(uuid, accountNumber, customer, interestRate, LocalDateTime.now());
        }

}
