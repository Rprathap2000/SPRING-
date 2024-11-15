package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BANK_ACCOUNT")
@Data
@NoArgsConstructor
@RequerArgsConstructor
public class BankAccount {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="acno_seq",initialValue=3000000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Long acno;
	@Column(length=30)
	private String holderName;
	private Double balance;
	@Version
	private Integer modificationCount;
	@CreationTimestamp
	@Column(insertable=true,updatable=false)
	private LocalDateTime openingDate;
	@UpdateTimestamp
	@Column(insertable=false,updatable=true)
	private LocalDateTime lastlyOperatedOn;
	

}
