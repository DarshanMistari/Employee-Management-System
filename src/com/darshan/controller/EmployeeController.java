package com.darshan.controller;

import java.util.ArrayList;

import com.darshan.entity.Employee;
import com.darshan.service.EmployeeService;

public class EmployeeController {
	
	EmployeeService empService = new EmployeeService();
	
	public String saveEmployee(Employee employee) {
		
		String msg = empService.saveEmployee(employee);
		
		return msg;
	}
	
	public String updateEmployee(Employee employee) {
		
		String msg = empService.updateEmployee(employee);
		
		return msg;
	}
	
	public Employee getEmployeeById(int empId) {
		
		Employee employee = empService.getEmployeeById(empId);
		
		return employee;
	}
	
	public ArrayList<Employee> getAllEmployee() {
		
		ArrayList<Employee> employees = empService.getAllEmployee();
		
		return employees;
	}
	
	public String deleteEmployeeById(int empId) {
		
		String msg = empService.deleteEmployeeById(empId);
		
		return msg;
	}
	
	public String deleteAllEmployee() {
		
		String msg = empService.deleteAllEmployee();
		
		return msg;
	}
	
	public ArrayList<Employee> getAllMaleEmployees() {
		ArrayList<Employee> maleEmployees = empService.getAllMaleEmployees();
		return maleEmployees;
	}
	
	public ArrayList<Employee> getAllFemaleEmployees() {
		ArrayList<Employee> femaleEmployees = empService.getAllFemaleEmployees();
		return femaleEmployees;
	}
	
	
}
