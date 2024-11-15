package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;

@Component
public final class VersionAndTimeStampTestRunner implements CommandLineRunner {

	private IBankAccountMgmtService bankService;
	@Override
	public void run(String... args) throws Exception {
		BankAccount account=new BankAccount();
		account.setHolderName("raja");
		account.setBalance(90000.0);
		
		try {
			String msg=bankService.openAcciunt(account);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			String msg=bankService.withdrawAmount(1000020,1000.0);
			System.out.println(msg);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			String msg=bankService.withdrawAmount(1000020,1000,0);
			System.out.println(msg);
			BankAccount acc=bankService.showAccountByAcno(10000020);
			System.out.println("account is modified for "+acc.getModificationCount()+"....opened on"+acc.getOpeningDate()+"....lastely operated on"+acc.getLastlyOperatedOn());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
