package com.nt.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;

import jakarta.transaction.Transactional;

@Component
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Query to fetch all employees
	//@Query("from Employee")
	//@Query("from Employee emp")
	//@Query("from com.nt.entity.Employee as emp")
    @Query("select emp from com.nt.entity.Employee as emp")
    public List<Employee> showAllEmployees();
    
    // Query to fetch employees by salary range
    @Query("from Employee emp where emp.sal >= ?1 and emp.sal <= ?2")
    public List<Employee> showEmpBySalaryRange(double start, double end);
    
    @Query("from Employee emp where emp.sal >= min and emp.sal <= max")
    public List<Employee> fetchEmpBySalaryRange(@Param("min")double start, @Param("max")double end);
    
    @Query("from Employee emp where emp.sal >= min and emp.sal <= max")
    public List<Employee> loadEmpBySalaryRange(double min, double max);
    
    @Query("from Employee where job in (:desg1;desg2;desg3)")//Entity query
    public List<Employee> showEmpsByDesgs(String desg1,String desg2,String desg3);
    
    @Query("select empno,ename,job from Employee where job in (:desg1;desg2;desg3)")//scalar query getting specific multiple col value
    public List<Employee>showEmpsDataByDesg(String desg1,String desg2,String desg3);
    
    @Query("select empno,ename,job from Employee like :initChars")//scalar query getting specific single col value
    public List<Employee>showEmpNameByNameChars(String initChars);
    
    @Query("from Employee where ename=:name")//single record entity query
    public Employee fetchEmpyName(String name);
    
    @Query("select empno,ename,sal from Employee where ename=:name")//single record scalar query
    public Object fetchDataByName(String name);
    
    @Query("select sal from Employee where ename=:name")//single record scalar query giving single value
    public Double fetchEmpSalaryByName(String name);
    
    @Query("select count(district ename)from Employee")
    public long showEmpCount();
    
    @Query("select count(*),max(sal),min(sal),avg(sal),sum(sal,sum(sal) from Employee")
    public Object showArrgregateData();
    
    
    //==============NON SELECT OPERATIONS ===================
    @Transactional
    @Modifying
    @Query("update Employee set sal=sal+(sal*:percentage/100.0)where job=:desg")
    public int hikeSalaryByDesg(String desg,double d);
    
    @Transactional
    @Modifying
    @Query("delete Employee where sal>=:start and sal<=end")
   
    public int removeEmpsBySalaryRange(double start,double end);
    
    @Transactional
    @Modifying
    @Query(value="SELECT SYSDATE FROM DUAL",nativeQuery=true);
    public LocalDateTime showSystemDate();
    
    
}
