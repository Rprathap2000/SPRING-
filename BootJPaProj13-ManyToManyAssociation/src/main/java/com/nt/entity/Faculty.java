//Faculty class
package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_MTOM_FACULTY")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Faculty {
	@SequenceGenerator(name="gen1",sequenceName="FID_SEQ,initialValue=1,allocationSize=1")
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@Id
	private Integer fid;
	@NonNull
	@Column(length=30)
	private String fname;
	@NonNull
	@Column(length=30)
	private String faddrs;
	
	
	@ManyToMany(targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="JPA_MTOM_FACULTY_STUDENTS",//Third table
	joinColumns=@JoinColumn(name="faculty_id",referencedColumnName="fid")//owing side FK column
	,inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="sid"))//NOn owing side FK Column
	private Set<Student> studentInfo=new HashSet<>();
	
	//toString() alt+shift+s,s

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", faddrs=" + faddrs + "]";
	}
	
	
	

}
