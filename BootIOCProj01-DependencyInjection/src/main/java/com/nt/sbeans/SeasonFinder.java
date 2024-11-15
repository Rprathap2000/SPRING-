package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	@Autowired  //field injection
	private   LocalDate ldate;
	
	public SeasonFinder() {
		System.out.println("SeasonFinder:: 0-arg constructor");
	}
	
	//b.method
	public   String  findSeason() {
		System.out.println("SeasonFinder.findSeason()");
		//get  current month value
		int month=ldate.getMonthValue();
		//generate the season name
		if(month>=3 && month<=6)
			return "Summer Season";
		else if(month>=7 &&  month<=10)
			return "Rainy Season";
		else
			return "Winter Season";
	}

}
