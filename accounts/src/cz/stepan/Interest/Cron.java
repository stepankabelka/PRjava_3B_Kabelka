package cz.stepan.Interest;

import com.google.inject.Inject;
import jakarta.inject.Singleton;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Singleton
public class Cron {

    @Inject
    private InterestRunnerFacade interestRunnerFacade;

    @Inject
    private ScheduledExecutorService scheduler;

    public void start(){
        scheduler.scheduleAtFixedRate(
                interestRunnerFacade::processAllInterests,
                0,
                5,
                TimeUnit.SECONDS
        );
    }

}
