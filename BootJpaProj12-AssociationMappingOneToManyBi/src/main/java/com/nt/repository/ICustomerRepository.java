package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Customer;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    // Corrected query syntax
    @Query("select c.cno, c.cname, c.caddrs, ph.regNo, ph.mobileNo, ph.provider, ph.numberType " +
            "from Customer c inner join c.phonesInfo ph")
    public List<Object[]> fetchParentToChildsDataUsingJoins();
}
