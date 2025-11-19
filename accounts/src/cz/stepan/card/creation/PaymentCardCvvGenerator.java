package cz.stepan.card.creation;
import java.security.SecureRandom;
import java.util.Locale;


public class PaymentCardCvvGenerator {

    private final SecureRandom rnd = new SecureRandom();

    public String generateCvv(){
        int max = (int) Math.pow(10,4);
        int v = rnd.nextInt(max);
        return String.format(Locale.US, "%0" + 4 + "d", v);
    }
    }


