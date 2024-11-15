package com.nt.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.nt.BootIocProj15LayeredAppMiniProjectApplication;
import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@Component
public class MiniProjectTestRunner implements CommandLineRunner {
	@Autowired
	private EmployeeOperationsController   controller;
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MiniProjectTestRunner.run()");
		   
		 //read input from enduser
		   Scanner sc=new Scanner(System.in);
		   System.out.println("Enter name::");
		   String name=sc.next();
		   System.out.println("Enter  desg::");
		   String desg=sc.next();
		   System.out.println("Enter  salary::");
		   double salary=sc.nextDouble();
		   System.out.println("Enter deptno  (10,20,30,40,...)");
		   int deptno=sc.nextInt();
		   
	    //create Employee class object
		   Employee  emp1=new Employee();
		   emp1.setEname(name);emp1.setJob(desg);emp1.setDeptno(deptno); emp1.setSalary(salary);
		   
		   try {
			   String resultMsg=controller.processEmployee(emp1);
			   System.out.println(resultMsg);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   System.out.println("=======================================");
		   
		   //read inputs from enduser
		   System.out.println("Enter desg1");
		   String desg1=sc.next();
		   System.out.println("Enter desg2");
		   String desg2=sc.next();
		   System.out.println("Enter desg3");
		   String desg3=sc.next();
		   
		   //invoke  the b.method
		   try {
			   List<Employee> list=controller.processEmployeesByDesgs(desg1,desg2, desg3);
			   list.forEach(emp->{
				   System.out.println(emp);
			   });
		   }//try
		   catch(Exception e) {
			   e.printStackTrace();
			   System.out.println("Internal problem... try again");
		   } 
		   
		   
	}

}
