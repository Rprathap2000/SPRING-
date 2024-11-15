package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empMySQLDAO")
public  class EmployeeMySQLDAOImpl implements IEmployeeDAO {
	private static   final  String  GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO  FROM EMP WHERE JOB IN(?,?,?)";
	private static   final  String  INSERT_EMPLOYEE="INSERT INTO EMP(ENAME,SAL,JOB,DEPTNO) VALUES(?,?,?,?)";
	
	@Autowired
	private   DataSource ds;

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		   List<Employee> list=null;
		   System.out.println("DataSource obj class name ::"+ds.getClass());
		try(//get Pooled connection
				Connection con=ds.getConnection();
				
				//create PreparedStatement obj having the pre-compiled SQL Query 
				PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS);
				){
			        //set values to query params
			        ps.setString(1, desg1);  ps.setString(2, desg2);ps.setString(3, desg3);
			        
			        try(//execute the Query
			        		ResultSet  rs=ps.executeQuery();){
			        	
			        	   //process the  Result Object
			        	list=new  ArrayList();
			        	while(rs.next()) {
			        		//copy  each record  into   Java bean class object
			        		Employee  emp=new Employee();
			        		emp.setEmpno(rs.getInt(1));
			        		emp.setEname(rs.getString(2));
			        		emp.setJob(rs.getString(3));
			        		emp.setSalary(rs.getDouble(4));
			        		emp.setDeptno(rs.getInt(5));
			        		//add each JAva bean class object List Collection
			        		list.add(emp);
			        	}//while
			        	
			        }//fry2
			
		}//try1
		catch(SQLException se) {
			System.out.println("some DB Problems  , wait for sumTime");
			throw se;
		}
		catch(Exception e) {
			System.out.println("some up known  Problems  , wait for sumTime");
			throw e;
		}
		
		return list;
	}

	@Override
	public int insertEmployee(Employee emp)throws Exception {
		 System.out.println("DataSource obj class name ::"+ds.getClass());
		int  result=0;
		try(//get Pooled connection
				Connection con=ds.getConnection();
				//create PreparedStatement obj having the pre-compiled SQL Query 
				PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE);
				){
			   //set  values to Query params
			 ps.setString(1, emp.getEname());
			 ps.setDouble(2, emp.getSalary());
			 ps.setString(3,emp.getJob());
			 ps.setInt(4, emp.getDeptno());
			 
			 //exectue  the  SQL Query
			 result=ps.executeUpdate();
		}
		catch(SQLException  se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}//method

}//class
