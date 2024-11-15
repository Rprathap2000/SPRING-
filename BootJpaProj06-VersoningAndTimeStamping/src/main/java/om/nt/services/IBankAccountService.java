package om.nt.services;

import com.nt.entity.BankAccount;

public interface IBankAccountService {

	public String openAccount(BankAccount account);
	public String withdrawAmount(long acno,double amt);
	public BankAccount showAccountByAcno(long acno);
	
}
