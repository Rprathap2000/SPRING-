package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj11LayeredAppMiniProjectApplication {
	
	
	public static void main(String[] args) {
	   
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj11LayeredAppMiniProjectApplication.class, args);
	     //get  Controller  class obj ref
		   EmployeeOperationsController  controller=ctx.getBean("empController",EmployeeOperationsController.class);
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
		   
		   // Get  Environment  object
		   Environment env=ctx.getEnvironment();
		   System.out.println("Activate  profile ::"+Arrays.toString(env.getActiveProfiles()));
		   
		   //close the container
		    ((ConfigurableApplicationContext) ctx).close(); 
	}//main

}//class
