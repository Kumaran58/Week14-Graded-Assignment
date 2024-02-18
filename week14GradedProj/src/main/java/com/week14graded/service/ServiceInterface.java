package com.week14graded.service;

import java.util.List;

import com.week14graded.model.EmployeeModel;


public interface ServiceInterface {
	
	public void add(EmployeeModel employee);
	public void update(EmployeeModel employee);
	public void delete(EmployeeModel id);
	public List<EmployeeModel> getAllEmployees();
	public EmployeeModel getEmployeeById(int id);
	

}
