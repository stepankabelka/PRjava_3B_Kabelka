package cz.stepan.generators;

public class AccnumGen {

        public String generateAccountNumber() {
            StringBuilder accountNumber = new StringBuilder();
            for (int i = 0; i<6; i++) {
                accountNumber.append((int)(Math.random() * 10));
            }

            return accountNumber.toString();
        }
    }

