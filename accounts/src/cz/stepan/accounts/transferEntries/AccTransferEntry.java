package cz.stepan.accounts.transferEntries;


import java.time.LocalDateTime;

public class AccTransferEntry {
    private final LocalDateTime localDateTime;
    private final Actions actions;
    private final double amount;
    private boolean wasExported;

    public AccTransferEntry(Actions action, double amount){
        this.localDateTime = LocalDateTime.now();
        this.actions =  action;
        this.amount = amount;
        this.wasExported = false;
    }

    public LocalDateTime getDateTime() {
        return localDateTime;
    }

    public Actions getActionType() {
        return actions;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isWasExported() {
        return wasExported;
    }

    public void setWasExported(boolean wasExported) {
        this.wasExported = wasExported;
    }
}
