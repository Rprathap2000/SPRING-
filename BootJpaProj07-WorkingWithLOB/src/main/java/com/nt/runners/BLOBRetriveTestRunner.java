package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJObSeekerMgntService;

@Component
public class BLOBRetriveTestRunner implements CommandLineRunner {

	@Autowired
	private IJObSeekerMgntService jsService;
	
	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Js id::");
		int id=sc.nextInt();
		try
		{
			Optional<JobSeeker> opt=jsService.showJobSeekerInfoById(id);
			if(opt.isPresent()) {
				JobSeeker js=opt.get();
				int jsid=js.getJsid();
				String name=js.getJsName();
				String addrs=js.getJsAddrs();
				byte[] photoContent=js.getPhoto();
				char[] resumeContent=js.getResume();
				boolean indian =js.getIndian();
				System.out.println(id+" "+name+" "+addrs+" "+indian);
				try(FileOutputStream fos=new FileOutputStream("photo_retrived.jfif");
				FileWriter fw=new FileWriter("resume_retrived.txt");
				){
					//writer bytr[] dest file
					fos.write(photoContent);
					fos.flush();
					//write char[] dest file
					fw.write(resumeContent);
					fw.flush();
					System.out.println("LOB files are the retrived from the database software");
				}//try
			}//if
			else
			{
			System.out.println("JobSeeker not found");
				
			}
		}//try
					catch(SQLException e)
					{
						e.printStackTrace();
					}
		}
				
}

