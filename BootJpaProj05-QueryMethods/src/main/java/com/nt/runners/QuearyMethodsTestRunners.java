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
	public void run(String... args) throws Exception {
	    empRepo.showAllEmployees().forEach(System.out::println);

	    empRepo.showEmpBySalaryRange(30000.0, 40000.0).forEach(System.out::println);

	    empRepo.fetchEmpBySalaryRange(3000.0, 4000.0).forEach(System.out::println);

	    empRepo.loadEmpBySalaryRange(3000.0, 4000.0).forEach(System.out::println);

	    empRepo.showEmpsByDesgs("Hero", "Software", "Tester");

	    empRepo.showEmpsByDesgs("CLERK", "MANAGER", "SALESMAN").forEach(System.out::println);
	    
	    System.out.println("====================");
	    
	    empRepo.showEmpsDataByDesg("CLERK", "MANAGER", "SALESMAN").forEach(row -> {
	        // row is an Object[] where each index corresponds to a specific column in the query
	        for (Object val : row ) {
	            System.out.print(val + "  "); // Print each value in the row
	        }
	        System.out.println(); // Newline after each row
	    });

	    
	    System.out.println("====================");
	    
	    empRepo.showEmpNameByNameChars("r%").forEach(System.out::println);
	    
	    System.out.println("Single record ::" + empRepo.fetchDataByName("raja"));
	    
	    System.out.println("------------");
	    System.out.println("Single record multiple values::" + empRepo.fetchDataByName("ALLEN"));
	    
	    System.out.println("--------------");
	    Object[] row = (Object[]) empRepo.fetchDataByName("ALLEN");
	    System.out.println("Single record multiple values::" + Arrays.toString(row));
	    
	    System.out.println("--------------");
	    System.out.println("Single record value ::" + empRepo.fetchEmpSalaryByName("RAJA"));
	    
	    System.out.println("--------------");
	    System.out.println("Single record value ::" + empRepo.fetchEmpyName("ALLEN"));
	    
	    System.out.println("Unique emp names count::" + empRepo.showEmpCount());  // Corrected method
	    
	    Object[] aggregateData = (Object[]) empRepo.showAggregateData(); // Corrected method
	    System.out.println("Aggregate data::" + Arrays.toString(aggregateData));
	    
	    // Non-select operations
	    int count = empRepo.hikeSalaryByDesg("CLERK", 5.0);
	    System.out.println("No. of records affected: " + count);

	    int count1 = empRepo.removeEmpsBySalaryRange(100000.0, 150000.0);
	    System.out.println("No. of records affected: " + count1);

	    LocalDateTime ldt = empRepo.showSystemDate();
	    System.out.println("Date and time: " + ldt);
	}


}
