package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("vd")
public class VoterDetails {
	@Value("${voter.ano}")
	private  long  id;
	@Value("${voter.name}")
	private  String  name;
	@Value("${voter.age}")
	private   float age;
	private   Date  dov;
	
	public VoterDetails() {
		System.out.println("VoterDetails::0-arg constructor");
	}
	
	//custom init  method  /init life cycle method
	@PostConstruct
	public void myInit() {
		System.out.println("VoterDetails.myInit()");
		//initialize left over propperties
		dov=new Date();
		//check  whether correct values are injected to spring bean properties or not
		if(name==null || age<18 || age>120 ||  id<=0L)
			throw  new IllegalArgumentException("Invalid inputs");
	}
	
	//b.method
	public  String   checkVotingElgbility() {
		System.out.println("VoterDetails.checkVotingElgbility()");
		if(age<18)
			return "Mr/Miss/Mrs."+ name+"  u r  not elgible for Voting  --> verified on::"+dov;
		else
			return "Mr/Miss/Mrs."+ name+"  u r  elgible for Voting  --> verified on::"+dov;
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("VoterDetails.destroy()");
		//nullifying the spring bean properties
		dov=null;
		id=0L;
		age=0;
	}

}
