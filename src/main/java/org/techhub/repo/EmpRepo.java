package org.techhub.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.techhub.model.Employee;
@Repository
public interface EmpRepo {
	
	public boolean isSave(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean isDelete(String  email);
	public boolean isUpdate(Employee employee);
}
