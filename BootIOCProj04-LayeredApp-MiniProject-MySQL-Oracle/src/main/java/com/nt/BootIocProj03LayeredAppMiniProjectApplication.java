package com.nt;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj03LayeredAppMiniProjectApplication {

	public static void main(String[] args) {
/*		//get IOC container
	ApplicationContext ctx=SpringApplication.run(BootIocProj03LayeredAppMiniProjectApplication.class, args);
     //get  Controller  class obj ref
	   EmployeeOperationsController  controller=ctx.getBean("empController",EmployeeOperationsController.class);
	   //read inputs from enduser
	   Scanner sc=new Scanner(System.in);
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
	   
	   //close the container
	    ((ConfigurableApplicationContext) ctx).close();  */
	   
	   
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj03LayeredAppMiniProjectApplication.class, args);
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
		   Employee  emp=new Employee();
		   emp.setEname(name);emp.setJob(desg);emp.setDeptno(deptno); emp.setSalary(salary);
		   
		   try {
			   String resultMsg=controller.processEmployee(emp);
			   System.out.println(resultMsg);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
	}//main

}//class
