package com.nt.service;

import java.util.List;

public interface ICustomerMgmtService {
	public String saveDateUsingParent();
	public String saveDataUsingChild();
	public void loadDataUsingParent();
	public void loadDataUsingChild();
	public void deleteDataUsingParent();
	public void deleteAllChildsOfAParent();
	public void deleteDataUsingChild();
	public void deleteAllInBatch();
	public void addNewChildToExistingChilds();
	public List<Object[]>showParentsToChildsDataUsingJoins();
	

}
