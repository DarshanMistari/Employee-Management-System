package com.darshan.service;

import java.util.ArrayList;

import com.darshan.dao.EmployeeDao;
import com.darshan.entity.Employee;
import com.darshan.exception.EmployeeNotFoundException;
import com.darshan.exception.NoFemaleEmployeeFound;
import com.darshan.exception.NoMaleEmployeeFound;

public class EmployeeService {
	
	EmployeeDao empDao = new EmployeeDao();
	
	public String saveEmployee(Employee employee) {
		
		String msg = empDao.saveEmployee(employee);
		
		return msg;
	}
	
	public String updateEmployee(Employee employee) {
		
		String msg = empDao.updateEmployee(employee);
		
		return msg;
	}
	
	public Employee getEmployeeById(int empId) {
		
		Employee employee = empDao.getEmployeeById(empId);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee Not Found with Id :"+empId);
		}
		return employee;
	}
	
	public ArrayList<Employee> getAllEmployee() {
		
		ArrayList<Employee> employees = empDao.getAllEmployee();
		
		return employees;
	}
	
	public String deleteEmployeeById(int empId) {
		
		String msg = empDao.deleteEmployeeById(empId);
		if(msg == null) {
			throw new EmployeeNotFoundException("Employee Not found with Id :"+empId);
		}
		return msg;
	}
	
	public String deleteAllEmployee() {
		
		String msg = empDao.deleteAllEmployee();
		
		return msg;
	}
	
	
	public ArrayList<Employee> getAllMaleEmployees() {
		ArrayList<Employee> employees = empDao.getAllEmployee();
		
		ArrayList<Employee> maleEmployees = new ArrayList<Employee>();
		
		for(Employee e : employees) {
			if(e.getEmpGender().equals("Male")) {
				maleEmployees.add(e);
			}
		}
		
		if(maleEmployees.isEmpty()) {
			throw new NoMaleEmployeeFound("Male Employee Not Found.");
		}
		return maleEmployees;
	}
	
	
	public ArrayList<Employee> getAllFemaleEmployees() {
		ArrayList<Employee> employees = empDao.getAllEmployee();
		
		ArrayList<Employee> femaleEmployees = new ArrayList<Employee>();
		
		for(Employee e : employees) {
			if(e.getEmpGender().equals("Female")) {
				femaleEmployees.add(e);
			}
		}
		
		if(femaleEmployees.isEmpty()) {
			throw new NoFemaleEmployeeFound("Male Employee Not Found.");
		}
		return femaleEmployees;
	}

	
	
}
