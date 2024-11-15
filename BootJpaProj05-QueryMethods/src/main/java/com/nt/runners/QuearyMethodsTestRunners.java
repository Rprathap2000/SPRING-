package com.nt.runners;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IEmployeeRepository;
@Component
public class QuearyMethodsTestRunners implements CommandLineRunner{
	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public void run(String...args)throws Exception
	{
		empRepo.showAllEmployees().forEach(System.out::println);
		
		empRepo.showEmpBySalaryRange(30000.0, 40000.0).forEach(System.out::println);
		
		empRepo.fetchEmpBySalaryRange(3000.0, 4000.0).forEach(System.out::println);
		
		empRepo.loadEmpBySalaryRange(3000.0, 4000.0).forEach(System.out::println);
		
		empRepo.showEmpsByDesgs("Hero", "Software", "Tester");
		
		empRepo.showEmpsByDesgs("CLERK", "MANAGER", "SALESMAN").forEach(System.out::println);
		System.out.println("====================");
		empRepo.showEmpsDataByDesg("CLERK", "MANAGER", "SALESMAN").forEach(row->
		{
			for(Object val:row) {
				System.out.println(val+"  ");
			}
			System.out.println();
		});
		System.out.println("====================");
		empRepo.showEmpNameByNameChars("r%").forEach(System.out::println);
		
		System.out.println("Single record ::"+empRepo.fetchDataByName("raja"));
		System.out.println("------------");
		System.out.println("Single record multiple values::"+empRepo.fetchDataByName("ALLEN"));
		System.out.println("--------------");
		Object data=(Object[])data;
		System.out.println("Single record multiple values::"+Arrays.toString(row));
		System.out.println("Single record value ::"+empRepo.fetchEmpBySalaryRange(300000, 400000));
		System.out.println("--------------");
		System.out.println("Single record value :"+empRepo.fetchEmpyName("ALLEAN"));
		
		System.out.println("unique emp names count::"+empRepo.showEmpsUniquwCount());
		Object row[]=(Object[])empRepo.showArrgregateData();
		System.out.println("aggregrate data::"+Arrays.toString(row));
		
		
		
		//======================
		int count=empRepo.hikeSalaryByDesg("CLERK", 5.0);
		System.out.println("no.of records that are effected"+count);
		
		int count1=empRepo.removeEmpsBySalaryRange(100000.0, 1500000.0);
		System.out.println("no.of records that are effected"+count1);
		
		LocalDateTime ldt=empRepo.showSystemDate();	
		System.out.println("Date and time ::"+ldt);
	}

}
