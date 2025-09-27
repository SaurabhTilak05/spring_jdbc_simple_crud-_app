package org.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.repo.EmpRepo;

import org.techhub.model.Employee;

@Service("empService")
public class EmpServiseImp implements EmpServise {

	@Autowired
	EmpRepo empRepo;
	@Override
	public boolean isSave(Employee employee) {
		return empRepo.isSave(employee);
	}
	
	public List<Employee> getAllEmployees() {
		
		return empRepo.getAllEmployees();
	}

	@Override
	public boolean isDelete(String email) {
		// TODO Auto-generated method stub
		return empRepo.isDelete(email);
	}

	@Override
	public boolean isUpdate(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.isUpdate(employee);
	}

	

}
