package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@ConfigurationProperties(prefix = "emp.info")
@Data
public class EmployeeDetails {
	private  String  name;
	private   Integer id;
	private   String  addrs;
	private   String email;
	private    Long mobileNo;
	private    String  desg;
	

}
