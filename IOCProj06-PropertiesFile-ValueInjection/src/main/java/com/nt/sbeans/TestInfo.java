package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("tInfo")
public class TestInfo {
	@Autowired
	private  Environment  env;
	
	public  void  displayData() {
		System.out.println(env.getProperty("os.name")+"...."+env.getProperty("per.id"));
	}

}
