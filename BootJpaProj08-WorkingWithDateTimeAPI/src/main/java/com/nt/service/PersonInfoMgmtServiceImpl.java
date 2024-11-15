package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PersonInfo;
import com.nt.repository.IPersonInfoRepository;

@Service
public class PersonInfoMgmtServiceImpl implements IPersonInfoMgmtService {
	@Autowired
	private IPersonInfoRepository personRepo;
	@Override
	public String registerPerson(PersonInfo per) {
		int idVal=personRepo.save(per).getPid();
		return "Person is saved with the id value::"+idVal;
	}
	@Override
	public Iterable<PersonInfo> showAllPersons() {
		
		return personRepo.findAll();
	}

}
