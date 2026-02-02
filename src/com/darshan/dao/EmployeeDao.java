package com.darshan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.darshan.entity.Employee;
import com.darshan.util.EmployeeUtil;

public class EmployeeDao {
	
	Connection con = EmployeeUtil.createConnection();
	
	public String saveEmployee(Employee employee) {
		
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			pstmt.setInt(1, employee.getEmpId());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setDouble(3, employee.getEmpSalary());
			pstmt.setString(4, employee.getEmpDep());
			pstmt.setString(5, employee.getEmpGender());
			pstmt.setString(6, employee.getEmpCity());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Employee Register Sucessfully..";
	}
	
	
	public String updateEmployee(Employee employee) {
		
		try {
			PreparedStatement pstmt = con.prepareStatement("update employee set empName=?,empSalary=?,empDep=?,empGender=?,empCity=? where empId=?");
			pstmt.setString(1, employee.getEmpName());
			pstmt.setDouble(2, employee.getEmpSalary());
			pstmt.setString(3, employee.getEmpDep());
			pstmt.setString(4, employee.getEmpGender());
			pstmt.setString(5, employee.getEmpCity());
			pstmt.setInt(6,employee.getEmpId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Employee Update Sucessfully..";
	}
	
	
	public Employee getEmployeeById(int empId) {
		
		Employee employee = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from employee where empId =?");
			
			pstmt.setInt(1, empId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empId1 = rs.getInt("empId");
				String empName = rs.getString("empName");
				double empSalary = rs.getDouble("empSalary");
				String empDep = rs.getString("empDep");
				String empGender = rs.getString("empGender");
				String empCity = rs.getString("empCity");
				
				employee = new Employee(empId1,empName,empSalary,empDep,empGender,empCity);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employee;
	}
	
	
	public ArrayList<Employee> getAllEmployee() {
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from employee");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("empId");
				String empName = rs.getString("empName");
				double empSalary = rs.getDouble("empSalary");
				String empDep = rs.getString("empDep");
				String empGender = rs.getString("empGender");
				String empCity = rs.getString("empCity");
				
				Employee employee = new Employee(empId,empName,empSalary,empDep,empGender,empCity);
				
				employees.add(employee);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
	public String deleteEmployeeById(int empId) {
		
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from employee where empId=?");
			pstmt.setInt(1, empId);
	
			int value = pstmt.executeUpdate();
			
			if(value > 0) {
				return "Employee Delete By ID";
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String deleteAllEmployee() {
		
		try {
			PreparedStatement pstmt = con.prepareStatement("truncate table employee");
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Delete all Employee Sucessflly";
		
	}
	

}
