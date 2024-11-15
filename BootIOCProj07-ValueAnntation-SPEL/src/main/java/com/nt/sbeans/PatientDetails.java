package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component("pd")
//@Data
@Getter
@ToString
public class PatientDetails {
	@Value("1001")  // hard coding of inputs
	private Integer pid;
	
	//collecting values  from the   application.properties file (user-defined keys)
	@Value("${pat.name}")
	private  String  pname;
	@Value("${pat.addrs}")
	private  String   paddrs;
	@Value("${pat.age}")
	private  Integer  page;
	
	//collecting  values  from the  system properties  (fixed keys)
	@Value("${user.name}")
	private  String  user;
	@Value("${os.name}")
		private  String os;

	@Value("${pat.mail}")
	private  String  mail;
	
	//collecting  values from  the  env.. variables  (fixed keys)
	@Value("${Path}")
	private   String pathData;
	
	@Value("#{dc.xrayPrice + dc._3dEchoPrice + dc.ctscanPrice   }")
	private  Float  billAmt;
	
	@Value("#{dc.ctscanPrice >=10000}")
	private   boolean ctscanOverPriced;

	
	
	
	
	
	
	
	
	

}
