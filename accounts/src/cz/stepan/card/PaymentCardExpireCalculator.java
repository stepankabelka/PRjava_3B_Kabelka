package cz.stepan.card;
import java.util.concurrent.ThreadLocalRandom;
import java.time.Year;


public class PaymentCardExpireCalculator
{
    public String MonthExpire;

    public String calculateMonthExpire(){
                int m = ThreadLocalRandom.current().nextInt(1, 13);
                return String.format("%02d", m);
            }

    public String YearExpire;

    public String calculateYearExpire(){
        int base = Year.now().getValue();
        int y = base + ThreadLocalRandom.current().nextInt(1, 7); // 1..6 years forward
        return Integer.toString(y);
    }
}
