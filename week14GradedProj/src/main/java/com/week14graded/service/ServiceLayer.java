package com.week14graded.service;

import java.util.List;
import com.week14graded.dao.DaoLayer;
import com.week14graded.model.EmployeeModel;

public class ServiceLayer implements ServiceInterface{
	
	DaoLayer d1=new DaoLayer() ;

	@Override
	public void add(EmployeeModel e) {
		d1.insertEmployee(e);	
	}

	@Override
	public void update(EmployeeModel e) {
		d1.updateEmployee(e);
	}

	@Override
	public void delete(EmployeeModel e) {
		d1.deleteEmployee(e);
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		return d1.getAllEmployees();
	}

	@Override
	public EmployeeModel getEmployeeById(int id) {
		return d1.getEmployeeById(id);
	}

}
