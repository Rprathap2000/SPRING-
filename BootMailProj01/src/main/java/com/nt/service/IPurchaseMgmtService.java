package com.nt.service;

public interface IPurchaseMgmtService {
	public String shopping(String[] items,Double[] prices,String[] emails);
	public String sendMail(String msg, String[] toEmailids, String fromEmailIds)throws Exception;
	

}
