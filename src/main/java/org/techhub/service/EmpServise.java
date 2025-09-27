package org.techhub.service;

import java.util.List;

import org.techhub.model.*;

public interface EmpServise {
	
	public boolean isSave(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean isDelete(String email);
	public boolean isUpdate(Employee employee);
}
