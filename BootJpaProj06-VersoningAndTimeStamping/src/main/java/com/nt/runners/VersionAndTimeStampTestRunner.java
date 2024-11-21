package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.services.IBankAccountService;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
public final class VersionAndTimeStampTestRunner implements CommandLineRunner {

    @Autowired
    private IBankAccountService bankService;

    @Override
    public void run(String... args) throws Exception {
        // Open a new account
        BankAccount account = new BankAccount();
        account.setHolderName("Raja");
        account.setBalance(90000.0);

        try {
            String msg = bankService.openAccount(account);
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Withdraw amount
        try {
            String msg = bankService.withdrawAmount(3000000L, 1000.0);
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Show account info and modification count
        try {
            BankAccount acc = bankService.showAccountByAcno(3000000L);
            System.out.println("Account is modified for " + acc.getModificationCount() + " times. "
                    + "Opened on: " + acc.getOpeningDate() + " Last operated on: " + acc.getLastlyOperatedOn());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
