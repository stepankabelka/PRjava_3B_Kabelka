package cz.stepan.card.creation;
import java.security.SecureRandom;

public class PaymentCardNumberGenerator {


        private final SecureRandom rnd = new SecureRandom();

        public String generateCardNumber(int length) {
            if (length < 12) throw new IllegalArgumentException("length must be >= 12");
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length - 1; i++) {
                sb.append(rnd.nextInt(10));
            }
            int check = computeLuhnCheckDigit(sb.toString());
            sb.append(check);
            return sb.toString();
        }

        // Luhn algorithm: compute check digit for the given number (without check digit).
        private int computeLuhnCheckDigit(String numberWithoutCheck) {
            int sum = 0;
            boolean doubleDigit = true; // we start doubling from the rightmost of the provided digits
            for (int i = numberWithoutCheck.length() - 1; i >= 0; i--) {
                int d = numberWithoutCheck.charAt(i) - '0';
                if (doubleDigit) {
                    d *= 2;
                    if (d > 9) d -= 9;
                }
                sum += d;
                doubleDigit = !doubleDigit;
            }
            // determine check digit that makes (sum + check) % 10 == 0
            int mod = sum % 10;
            return (mod == 0) ? 0 : (10 - mod);
        }
    }



