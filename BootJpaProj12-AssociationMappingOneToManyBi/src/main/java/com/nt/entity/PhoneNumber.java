package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_OTM_PHONES")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer regNO;  // Changed the type from Integrator to Integer for ID

    @NonNull
    private long mobileNo;

    @Column(length = 30)
    private String provider;

    @NonNull
    @Column(length = 30)
    private String numberType;

    // Building Many-to-One Association
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CNO")  // Corrected the referencedColumnName for proper join
    private Customer customer;  // Renamed to 'customer' for clarity

    // toString() method
    @Override
    public String toString() {
        return "PhoneNumber[regNO=" + regNO + ", mobileNo=" + mobileNo + ", provider=" + provider + ", numberType=" + numberType + "]";
    }
}
