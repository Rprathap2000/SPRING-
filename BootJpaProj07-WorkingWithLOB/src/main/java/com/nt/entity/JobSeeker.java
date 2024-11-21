package com.nt.entity;

import java.io.Serializable;
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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="JPA_SEEKERS")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class JobSeeker implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jsid;
    
    @NonNull
    @Column(length = 30)
    private String jsName;
    
    @NonNull
    @Column(length = 30)
    private String jsAddrs;
    
    @Lob
    @NonNull
    private byte[] photo;  // LOB for photo as byte[]
    
    @Lob
    @NonNull
    private byte[] resume; // LOB for resume as byte[]

    private Boolean indian;  // Non-LOB field

	public String getJsid() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getResume() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getPhoto() {
		// TODO Auto-generated method stub
		return null;
	}
}
