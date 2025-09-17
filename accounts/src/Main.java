import accounts.BaseBankAccount;
import persons.customers.Customer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("c-1230", "Tomas", "Pesek");
        BaseBankAccount account = new BaseBankAccount("c-123","12345",customer,0);

        account.addBalance(500);
        account.subBalance(300);

        System.out.println(account.getBalance());
    }
}