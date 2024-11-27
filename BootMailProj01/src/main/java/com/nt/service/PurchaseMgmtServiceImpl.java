package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import lombok.Value;

@Service
public class PurchaseMgmtServiceImpl implements IPurchaseMgmtService {
@Autowired
private JavaMailSender sender;
@Value("${spring.mail.user.username}")
private String fromEmailid;

	@Override
	public String shopping(String[] items, Double[] prices, String[] toEmailIds) {
		//calculate the bill amount
		double totalAmt=0.0;
		for(double p:prices) {
			totalAmt=totalAmt+p;
		}
		String msg1=Arrays.toString(items)+" are purchased having prices "+Arrays.toString(prices)+" with the bill amount"+totalAmt;
		//trigger the email message
		
		String msg2=sendMail(msg1,toEmailIds,fromEmailid);
		
		return msg1+"...."+msg2;
		
	}

	@Override
	public String sendMail(String msg, String[] toEmailids, String fromEmailid)throws Exception {
		//create and send MultipulPartMIME message
		MimeMessage message=sender.createMimeMessage();//Represents email message
		MimeMessageHelper helper=new MimeMessageHelper(message,true);//Represents email message allowing the attachments
		//setting the header values
		helper.setSentDate(new Date());
		helper.setFrom(fromEmailid);
		helper.setTo(toEmailids);
		helper.setSubject("open it to know it");
		//set multipart body
		helper.setText(msg);//text part
		helper.addAttachment("rohith.jpeg",new ClassPathResource("rohith.jpeg"));//image part
		sender.send(message);
		
		return "email message is sent";
	}

}
