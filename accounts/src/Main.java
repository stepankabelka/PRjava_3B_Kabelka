import accounts.AccountService;
import accounts.BaseBankAccount;
import com.thoughtworks.xstream.XStream;
import persons.customers.Customer;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("c-1230", "Tomas", "Pesek");
        BaseBankAccount account = new BaseBankAccount("c-123","12345",customer,0);

        //account.balance = AccountService.addBalance(1000000,account.getBalance());
        //account.balance = AccountService.subBalance(300, account.getBalance());

        System.out.println(account.getBalance());
        XStream xstream = new XStream();
        String xml = xstream.toXML(customer);
        System.out.println(xml);
    }

    //int length = String.valueOf(number).length();
    public int RanAccNum(int accNum)
    {
        int ranAccnum =0;
        Random r =  new Random();
        for(int i = 0; i < String.valueOf(accNum).length(); i++)
        {
            ranAccnum = r.nextInt() % 9999999 + 20;
        }
        //int randomNum = rand.nextInt(max - min + 1) + min;
        return(ranAccnum);
    }
}
