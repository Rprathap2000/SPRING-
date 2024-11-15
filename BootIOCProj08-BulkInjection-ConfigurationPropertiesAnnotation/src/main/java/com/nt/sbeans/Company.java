package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp")
//@Data
//@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "org.nit")
public class Company {
	@Value("${org.nit.id}")
	private  Integer  cid;
	@Value("${comp.name}")
	private   String   name;
	private   String  addrs;
	private   Integer  size;
	private    String mail;
	private   String[] colors;
	private   List<String> branches;
	private   Set<Long>  phones;
	private  Map<String,Long> idDetails;
	private   Supplier    supplier;
	
	
}
