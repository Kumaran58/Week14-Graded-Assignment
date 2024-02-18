package com.week14graded.dao;

import java.util.List;

import com.week14graded.model.EmployeeModel;


public interface DaoInterface {
	
	public void insertEmployee(EmployeeModel employee);
	public void updateEmployee(EmployeeModel employee);
	public void deleteEmployee(EmployeeModel id);
	public List<EmployeeModel> getAllEmployees();
	public EmployeeModel getEmployeeById(int id);
	

}
