//Student class
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
public class Student {
	@SequenceGenerator(name="gen1",sequenceName="SID_SEQ",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@Id
	private Integer sid;
	@NonNull
	@Column(length=30)
	private String sname;
	@NonNull
	@Column(length=30)
	private String saddrs;
	@NonNull
	@Column(length=30)
	private String college;
	
	
	@ManyToMany(targetEntity=Faculty.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="studentsInfo")
	private Set<Faculty> facultyInfo=new HashSet<>();

	//to string method
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddrs=" + saddrs + ", college=" + college + "]";
	}
	
	
}