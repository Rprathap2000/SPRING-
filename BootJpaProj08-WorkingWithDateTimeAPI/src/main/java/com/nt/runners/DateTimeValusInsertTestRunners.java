package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPersonInfoMgmtService;

@Component
public class DateTimeValusInsertTestRunners implements CommandLineRunner {
	@Autowired
	private IPersonInfoMgmtService personService;
	@Override
	public void run(String... args) throws Exception {
		/*try {
			PersonInfo info=new PersonInfo("raja","hyd",LocalDate.of(1999, 10, 20),LocalTime.of(20, 30),LocalDateTime.of(2012, 10,21,10,15,30));
		String msg=personService.registerPerson(info);
		System.err.println(msg);
		}//try
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		try
		{
			personService.showAllPersons().forEach(System.out::println);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
