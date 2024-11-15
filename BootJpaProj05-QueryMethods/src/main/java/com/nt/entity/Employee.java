package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="EMP")
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno;
	
	public Employee()
	{
		System.out.println("Employee.Employee():::o-param constructor");
	}

}
