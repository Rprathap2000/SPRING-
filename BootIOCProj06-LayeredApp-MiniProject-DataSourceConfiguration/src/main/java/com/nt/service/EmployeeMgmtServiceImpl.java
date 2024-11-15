
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public  class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	//@Qualifier("empMySQLDAO")
	//@Qualifier("empOraDAO")
	@Qualifier("dbDAO")
	private  IEmployeeDAO empDAO;

	@Override
	public List<Employee> fethEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		//convert the  desgs  into UPPPERCASE LATTERS
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		
		//use DAO
		List<Employee> list=empDAO.getEmpsByDesgs(desg1, desg2, desg3);
		//Sort the  object in List Collection
		list.sort((t1,t2)->t1.getEmpno().compareTo(t2.getEmpno()));
		//calculate  gross salary and netsalary
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+ (emp.getSalary()*0.5));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
		});
		
		return list;
	}

	@Override
	public String registerEmployee(Employee emp)throws Exception {
		//use   DAO
		int  result=empDAO.insertEmployee(emp);
		return result==0?"Employee not registred":"Employee is  registered";
	}

}
