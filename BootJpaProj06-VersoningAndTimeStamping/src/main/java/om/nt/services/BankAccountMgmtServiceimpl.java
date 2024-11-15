package om.nt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;

@Service("bankservice")
public class BankAccountMgmtServiceimpl implements IBankAccountService {

	@Autowired
	private IBankAccountRepository accountRepo;
	
	@Override
	public String openAccount(BankAccount account) {
	 long idVal=accountRepo.save(account).getAcno();
		return "Bank Account is opened with the account number:"+idVal;
	}
	
	@Override
	public String withdrawAmount(long acno,double amt)
	{
		//Load the Object
		BankAccount account=accountRepo.findById(acno).orElseThrow(()-
				>new IllegalArgumentException("account not found"));
		if(account!=null) {
			//with amount
			account.setBalance(account.getBalance()-amt);
			accountRepo.save(account);
			return "Account Money is withdraw";
		}
		return "Account not found";
	}
	
@Override
public BankAccountByAcno(long acno)
{
	return accountRepo.findById(acno).orElseThrow((->new IllegalArgumentException("invalid ac info"));
}

}
