package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICustomerMgmtService;

@Component
public class AssositaionMappingTestRunner implements CommandLineRunner {

    @Autowired
    private ICustomerMgmtService custService;

    @Override
    public void run(String... args) throws Exception {

        try {
            String msg = custService.saveDateUsingParent();
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String msg = custService.saveDataUsingChild();
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custService.loadDataUsingParent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custService.loadDataUsingChild();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custService.deleteDataUsingParent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custService.deleteAllChildsOfAParent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custService.addNewChildToExistingChilds();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custService.deleteDataUsingChild();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custService.showParentsToChildsDataUsingJoins().forEach(row -> {
                System.out.println(Arrays.toString(row));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
