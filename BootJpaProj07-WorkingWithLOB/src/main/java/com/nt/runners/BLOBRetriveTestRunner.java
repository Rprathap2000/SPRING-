package com.nt.runners;

import java.io.FileOutputStream;
import java.io.IOException;
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
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Job Seeker ID:");
        int id = sc.nextInt();
        
        try {
            Optional<JobSeeker> opt = jsService.showJobSeekerInfoById(id);
            if (opt.isPresent()) {
                JobSeeker js = opt.get();
                byte[] photoContent = js.getPhoto();
                byte[] resumeContent = js.getResume();

                // Write the retrieved photo to file
                try (FileOutputStream fos = new FileOutputStream("photo_retrived.jpg")) {
                    fos.write(photoContent);
                }

                // Write the retrieved resume to file
                try (FileOutputStream fos = new FileOutputStream("resume_retrived.txt")) {
                    fos.write(resumeContent);
                }

                System.out.println("LOB files retrieved from the database.");
            } else {
                System.out.println("Job Seeker not found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
