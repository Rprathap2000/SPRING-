package com.nt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Service("bankservice")
public class BankAccountMgmtServiceimpl implements IBankAccountService {

    @Autowired
    private IBankAccountRepository accountRepo;

    @Override
    public String openAccount(BankAccount account) {
        long idVal = accountRepo.save(account).getAcno();
        return "Bank Account is opened with the account number: " + idVal;
    }

    @Override
    public String withdrawAmount(long acno, double amt) {
        // Load the Account object
        BankAccount account = accountRepo.findById(acno).orElseThrow(() ->
                new IllegalArgumentException("Account not found"));
        
        // Check if balance is sufficient
        if (account.getBalance() >= amt) {
            account.setBalance(account.getBalance() - amt);
            accountRepo.save(account);
            return "Amount withdrawn successfully. New balance: " + account.getBalance();
        } else {
            return "Insufficient balance!";
        }
    }

    @Override
    public BankAccount showAccountByAcno(long acno) {
        return accountRepo.findById(acno).orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}
