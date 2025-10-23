package cz.stepan.accounts;

import java.io.Console;
import java.util.Objects;

public class Warningcheck {
    public void Check(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Zadejte platnou hodnotu.");
        } else if (amount >= 10000) {

            System.out.println("Jste si jist/a že to je správná peněžní hodnota?");
            Console cnsl
                    = System.console();
            String str = cnsl.readLine(
                    "Enter string : ");
            if (Objects.equals(str, "ne")) {
                throw new IllegalArgumentException("false value was selected");
            }

        }
    }
}
