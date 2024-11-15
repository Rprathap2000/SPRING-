package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pInfo")
public class PersonInfo {
	//Injecting the values from  the properties file
	@Value("${per.id}")
	private int  pid;
	@Value("${per.name}")
	private String pname;
	@Value("${per.billamt}")
	private  float Amt;
	//Injecting the values directly
	
	@Value("${per.addrs}")
	private  String addrs;
	
	//  Injecting the system property values
	@Value("${os.name}")
	private  String osName;
	@Value("${os.version}")
	private  String osVer;
	
	//Injecting the  env variable values
	@Value("${Path}")
	private  String pathData;

	
   //toString() (alt+shift+s, s)
	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", Amt=" + Amt + ", addrs=" + addrs + ", osName="
				+ osName + ", osVer=" + osVer + ", pathData=" + pathData + "]";
	}
	
	
	
}
