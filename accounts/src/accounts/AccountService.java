package accounts;

public class AccountService {

    public static void Check(double amount)
    {
        Warningcheck.Check(amount);
    }
    public static double addBalance(double amount, double balance){
        Warningcheck.Check(amount);
        balance += amount;
        return (balance);
    }
    public static double subBalance(double amount, double balance) {
        if(balance - amount < 0){
            System.out.println("not enough money for transaction");
        }else {
            balance -= amount;
        }
        return (balance);
    }
}
