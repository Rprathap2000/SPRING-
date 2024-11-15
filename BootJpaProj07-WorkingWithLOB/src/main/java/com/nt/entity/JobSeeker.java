package com.nt.entity;

import java.io.Serializable;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="JPA_SEEKERS")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class JobSeeker implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jsid;
	
	@NonNull
	@Column(length=30)
	private String jsName;
	@NonNull
	@Column(length=30)
	private String jsAddrs;
	
	@Lob
	@NonNull
	private byte[] photo;
	
	@Lob private Boolean indian;

}
