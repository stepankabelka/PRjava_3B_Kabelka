package cz.stepan.accounts.transferEntries;

import com.google.gson.Gson;
import cz.stepan.accounts.AccountStorageService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class AccTransferEntryFacade {

    @Inject
    private AccountStorageService accountStorageService;

    @Inject
    private Gson gson;

    @Singleton
    public void writeAllEntries(){
        accountStorageService.getAllBankAccounts().forEach(account -> {

            List<AccTransferEntry> toExport = account.getAccTransferEntries().stream()
                    .filter(entry -> !entry.isWasExported())
                    .toList();

            try(FileWriter fileWriter = new FileWriter(account.getUuid() + "_" + LocalDate.now() + ".json")){
                gson.toJson(toExport, fileWriter);
                toExport.forEach(entry -> entry.setWasExported(true));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}