package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.nt.service.ILoginMgmtService;

import net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.System;

@Component
public class CallingPL_SQLProcedureTest implements CommandLineRunner {
    
    @Autowired
    private ILoginMgmtService loginService;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Invoke the method to perform login
            String result = loginService.doLogin("raja", "rani");
            System.out.println(result); // Print the result (valid/invalid credentials)
        } catch (Exception e) {
            e.printStackTrace(); // Proper exception handling
        }
    }
    
}
