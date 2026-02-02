package com.darshan.entity;

public class Employee {
	
	private int empId;
	
	private String empName;
	
	private double empSalary;
	
	private String empDep;
	
	private String empGender;
	
	private String empCity;
	
	

	public Employee() {
		
	}

	public Employee(int empId, String empName, double empSalary, String empDep, String empGender, String empCity) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDep = empDep;
		this.empGender = empGender;
		this.empCity = empCity;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpDep() {
		return empDep;
	}

	public void setEmpDep(String empDep) {
		this.empDep = empDep;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	
	
}
