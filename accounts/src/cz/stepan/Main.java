package cz.stepan;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.stepan.accounts.*;
import cz.stepan.card.PaymentCardLogger;
import cz.stepan.card.PaymentCardService;
import cz.stepan.customers.Customer;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BankInjector());
        App app = injector.getInstance(App.class);
        app.run();
    }

}
