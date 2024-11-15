package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("empController")
public class EmployeeOperationsController {
	@Autowired
	private  IEmployeeMgmtService   empService;
	
	
	public   List<Employee>  processEmployeesByDesgs(String desg1,String desg2,String desg3)throws Exception{
		//use  Service
		List<Employee> list=empService.fethEmployeesByDesgs(desg1, desg2, desg3);
		return list;
	}
	
	
	public    String           processEmployee(Employee emp) throws Exception{
           //use service
		String resultMsg=empService.registerEmployee(emp);
		return resultMsg;
	}

}
