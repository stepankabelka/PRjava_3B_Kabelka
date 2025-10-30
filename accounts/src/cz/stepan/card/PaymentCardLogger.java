package cz.stepan.card;

import com.google.inject.Singleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PaymentCardLogger {

    public List<String> log = new ArrayList<>();

    public void logCard(boolean add, String card, String accountnumber) {
        LocalDate time = LocalDate.now();
        if (add)
        {
            log.add("karta " + card + " byla přidána do účtu " + accountnumber + " v " + time);
        }
        else {
            log.add("karta " + card + " byla odstraněna z účtu " + accountnumber + " v " + time);
        }

    }

    public void logBalance(boolean add, String bankAccNum, double amount) {
        LocalDate time = LocalDate.now();
        if (add)
        {
            log.add("obnos " + amount + " byl přidán do účtu " + bankAccNum + " v " + time);
        }
        else {
            log.add("obnos " + amount + " byl odstraněn z účtu " + bankAccNum + " v " + time);
        }

    }
    public void showLog()
    {
        log.forEach(Log -> System.out.println(Log));
    }
}
