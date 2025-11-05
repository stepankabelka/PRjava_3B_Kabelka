package cz.stepan;

import com.google.inject.AbstractModule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class BankInjector extends AbstractModule {
    protected void configure() {
        bind(ScheduledExecutorService.class).toInstance(Executors.newSingleThreadScheduledExecutor());
    }
}
