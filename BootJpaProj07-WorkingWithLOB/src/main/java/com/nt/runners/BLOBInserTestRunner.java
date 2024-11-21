package com.nt.runners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJObSeekerMgntService;

@Component
public class BLOBInserTestRunner implements CommandLineRunner {

    @Autowired
    private IJObSeekerMgntService jsService;

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // Taking user input
        System.out.println("Enter Job Seeker Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Job Seeker Address:");
        String addrs = sc.nextLine();
        
        System.out.println("Is Job Seeker Indian? (true/false):");
        boolean indian = sc.nextBoolean();
        
        // Read file paths
        System.out.println("Enter Job Seeker Photo File Path:");
        String photoPath = sc.next();
        
        System.out.println("Enter Job Seeker Resume File Path:");
        String resumePath = sc.next();

        // Convert photo to byte[]
        byte[] photoData = readFileToByteArray(photoPath);
        
        // Convert resume to byte[]
        byte[] resumeData = readFileToByteArray(resumePath);
        
        // Create JobSeeker entity
        JobSeeker js = new JobSeeker(name, addrs, photoData, resumeData);
        
        // Register job seeker
        try {
            String msg = jsService.registerJobSeeker(js);
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert file to byte array
    private byte[] readFileToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            return fis.readAllBytes();
        }
    }
}
