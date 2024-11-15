package com.nt.service;

import com.nt.entity.PersonInfo;

public interface IPersonInfoMgmtService {
	public String registerPerson(PersonInfo per);
	public Iterable<PersonInfo> showAllPersons();

}
