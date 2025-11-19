package cz.stepan.accounts.transferEntries;

import jakarta.inject.Singleton;

@Singleton
public class AccTransferEntryFactory {
    public AccTransferEntry createAccTransferEntry(Actions actions, double amount) {
        return new AccTransferEntry(actions, amount);
    }

}
