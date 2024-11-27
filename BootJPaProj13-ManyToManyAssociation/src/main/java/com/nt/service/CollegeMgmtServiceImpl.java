package com.nt.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.repository.IFacultyRepository;
import com.nt.repository.IStudentRepository;

public class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	@Autowired
	private IFacultyRepository facultyRepo;
	@Autowired
	private IStudentRepository studentRepo;
	
	@Override
	public void saveDataUsingParent() {
		//prepare parent objs
		Faculty faculty1=new Faculty("rohith","bnglr");
		Faculty faculty2=new Faculty("rohith","bnglr");
		//prepare child objs
		Student stud1=new Student("Prathp","bngle","CBIT");
		Student stud2=new Student("Prathp","bngle","CBIT");
		Student stud3=new Student("N","T","CBIT");
		//assign students to faculties
		faculty1.getStudentInfo().add(stud1);
		faculty1.getStudentInfo().add(stud2);
		faculty1.getStudentInfo().add(stud3);
		faculty2.getStudentInfo().add(stud1);
		faculty2.getStudentInfo().add(stud2);
		faculty2.getStudentInfo().add(stud3);
		
		//assign faculty to students
		stud1.getFacultyInfo().add(faculty1);
		stud1.getFacultyInfo().add(faculty2);
		stud2.getFacultyInfo().add(faculty1);
		stud2.getFacultyInfo().add(faculty2);
		stud3.getFacultyInfo().add(faculty1);
		stud3.getFacultyInfo().add(faculty2);
		
		//save data using parent
		try {
			facultyRepo.save(faculty1);
			facultyRepo.save(faculty2);
			System.out.println("Faculties and associated students are saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//method

	@Override
	public void loadDataUsingParent() {
		Iterable<Faculty>itFaculties=facultyRepo.findAll();
		itFaculties.forEach(faculty->{
			System.out.println("Parent::"+faculty);
			Set<Student>childs=faculty.getStudentInfo();
			childs.forEach(stud->{
				System.out.println("childs::"+stud);
			});
		});
		
	}

	@Override
	public void deleteDataUsingParent() {
		//Load PArent
		Optional <Faculty>opt=facultyRepo.findById(1);
		if(opt.isPresent()) {
			Faculty faculty=opt.get();
			Set<Student>child=opt.get().getStudentInfo();
			faculty.setStudentInfo(null);
			child.forEach(ch->{
				ch.setFacultyInfo(null);
			});
			facultyRepo.save(faculty);
			System.out.println("Faculty is removed from certain student");
			/*
			 * facultyRepo.delete(opt.get());
			 * System.out.println("Faculty and student relation ship is removed");
			 */
		}
		else
		{
			System.out.println("Faculty not found");
		}
		
	}

}//class
