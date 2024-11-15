package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dc")
@Data
public class DiagnosticCatalog {
	
	@Value("${catalog.xray}")
   private   Float  xrayPrice; 
	
	@Value("${catalog.2decho}")
	private   Float  _2dEchoPrice; 

	@Value("${catalog.3decho}")
	private   Float  _3dEchoPrice; 
	
	@Value("${catalog.ecg}")
	   private   Float  ecgPrice; 
	
	@Value("${catalog.ctscan}")
	   private   Float  ctscanPrice;
	
	@Value("${catalog.mri}")
	   private   Float  mriPrice;


	
	//alt+shift+s,s
	@Override
	public String toString() {
		return "DiagnosticCatalog [xrayPrice=" + xrayPrice + ", _2dEchoPrice=" + _2dEchoPrice + ", _3dEchoPrice="
				+ _3dEchoPrice + ", ecgPrice=" + ecgPrice + ", ctscanPrice=" + ctscanPrice + ", mriPrice=" + mriPrice
				+ "]";
	}
	
	
		
}
