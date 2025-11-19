package cz.stepan.accounts.transferEntries;

import com.google.inject.Inject;
import jakarta.inject.Singleton;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Singleton
public class AccTransferEntryCronService {
    @Inject
    private AccTransferEntryFacade accTransferEntryFacade;

    @Inject
    private ScheduledExecutorService scheduler;

    public void start(){
        scheduler.scheduleAtFixedRate(
                accTransferEntryFacade::writeAllEntries,
                0,
                5,
                TimeUnit.MINUTES
        );
    }
}
