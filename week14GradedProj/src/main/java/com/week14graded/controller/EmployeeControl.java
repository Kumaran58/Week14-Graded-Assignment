package com.week14graded.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.week14graded.model.EmployeeModel;
import com.week14graded.service.ServiceLayer;

@Controller
public class EmployeeControl {
	
	ServiceLayer s1=new ServiceLayer() ;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/employee-list")
	public String EmpPage() {
		return "addEmp";
	}

	@PostMapping("/insert-emp")
	public String addemp(@RequestParam String employeeName, @RequestParam String employeeAddress, @RequestParam int employeePhone,
			@RequestParam int employeeSalary,Model d1) {
		
			EmployeeModel e=new EmployeeModel(employeeName, employeeAddress, employeePhone, employeeSalary);
			s1.add(e);
			
			List<EmployeeModel> emp = s1.getAllEmployees();
			d1.addAttribute("emp", emp);
			
		return "showallemp";
	}
	
	
	
	@RequestMapping("/show-list")
	public String showemp(Model data) {
		
			List<EmployeeModel> e2 = s1.getAllEmployees();
			data.addAttribute("emp", e2);
			
		return "showallemp";
	}
	
	@RequestMapping("/update-emp")
	public String updateCarForm(@RequestParam int id, Model d1) {
		
			EmployeeModel e3= s1.getEmployeeById(id);
			d1.addAttribute("emp1",e3);

		return "update-emp";
	}
	@PostMapping("/update-save-emp")
	public String updateCar(@RequestParam int id,@RequestParam String employeeName, @RequestParam String employeeAddress, @RequestParam int employeePhone,
			@RequestParam int employeeSalary,Model d1) {

			EmployeeModel e4 = new EmployeeModel(id, employeeName, employeeAddress, employeePhone, employeeSalary);
			s1.update(e4);			
			
			List<EmployeeModel> emp1 = s1.getAllEmployees();
			d1.addAttribute("emp", emp1);
			
		return "showallemp";
	}
	
	@RequestMapping("/delete-emp")
	public String deleteCar(@RequestParam int id,Model d1) {
		
			EmployeeModel deleteEmp=new EmployeeModel(id, null, null, 0, 0);
			s1.delete(deleteEmp);
			
			List<EmployeeModel> emp1 = s1.getAllEmployees();
			d1.addAttribute("emp", emp1);
		
		return "showallemp";
	}



}
