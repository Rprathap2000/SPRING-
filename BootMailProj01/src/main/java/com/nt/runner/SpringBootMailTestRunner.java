package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPurchaseMgmtService;

@Component
public class SpringBootMailTestRunner implements CommandLineRunner {
	@Autowired
	private IPurchaseMgmtService purchaseService;

	@Override
	public void run(String... args) throws Exception {
		try {
			String resultMsg=purchaseService.shopping(new String[] {"shirt","trouser","hat"},new double[] {4000.0,5000.0,3000.0},new String[] {"repakulaprathap869@gamil.com","143chikki143@gmail.com","t.sravanthi2010@gmail.com"});
			System.out.println(resultMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	

	}//method

}//class
