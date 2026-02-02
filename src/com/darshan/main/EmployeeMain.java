package com.darshan.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.darshan.controller.EmployeeController;
import com.darshan.entity.Employee;
import com.darshan.exception.EmployeeNotFoundException;

public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeController empController = new EmployeeController();
		Employee emp = new Employee();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n\n*** Welcome to Employee Management System. ***");
			System.out.println("1.Add New Employees.");
			System.out.println("2.Update Employee.");
			System.out.println("3.Get Employee By Id");
			System.out.println("4.Get All Employee");
			System.out.println("5.Delete Employee By Id");
			System.out.println("6.Delete All Employee");
			System.out.println("7.Get Male Employee Only.");
			System.out.println("8.Get Female Employee Only.");
			System.out.println("9.Exit in Application.");
			
			System.out.println("\nPlease select the Operation on Employee :");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.println("Enter Employee ID :");
				int empId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Epmployee Name :");
				String empName = sc.nextLine();
				System.out.println("Enter Employee Salary :");
				double empSalary = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Employee Deparment :");
				String empDep = sc.nextLine();
				System.out.println("Enter Employee Gender :");
				String empGender = sc.nextLine();
				System.out.println("Enter Employee City :");
				String empCity = sc.nextLine();
				
				emp = new Employee();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setEmpSalary(empSalary);
				emp.setEmpDep(empDep);
				emp.setEmpGender(empGender);
				emp.setEmpCity(empCity);
				
				String msg = empController.saveEmployee(emp);
				System.out.println(msg);
				
			}
			else if(choice == 2) {
				System.out.println("Enter Employee ID :");
				int empId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Epmployee Name :");
				String empName = sc.nextLine();
				System.out.println("Enter Employee Salary :");
				double empSalary = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Employee Deparment :");
				String empDep = sc.nextLine();
				System.out.println("Enter Employee Gender :");
				String empGender = sc.nextLine();
				System.out.println("Enter Employee City :");
				String empCity = sc.nextLine();
				
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setEmpSalary(empSalary);
				emp.setEmpDep(empDep);
				emp.setEmpGender(empGender);
				emp.setEmpCity(empCity);
				
				String msg = empController.updateEmployee(emp);
				System.out.println(msg);
			}else if(choice == 3) {
				System.out.println("Enter Employee ID :");
				int empId = sc.nextInt();
				try {
					emp = empController.getEmployeeById(empId);
					
					System.out.println("Empolyee ID     :"+ emp.getEmpId());
					System.out.println("Employee Name   :"+ emp.getEmpName());
					System.out.println("Employee Salary :"+ emp.getEmpSalary());
					System.out.println("Employee Department:"+ emp.getEmpDep());
					System.out.println("Employee Gender :"+ emp.getEmpGender());
					System.out.println("Employee City   :"+ emp.getEmpCity());
				}catch(EmployeeNotFoundException e) {
					System.out.println(e.getMessage());				}
			}else if(choice == 4) {
				ArrayList<Employee> employees = empController.getAllEmployee();
				
				for(Employee emps : employees) {
					System.out.println("Empolyee ID     :"+ emps.getEmpId());
					System.out.println("Employee Name   :"+ emps.getEmpName());
					System.out.println("Employee Salary :"+ emps.getEmpSalary());
					System.out.println("Employee Department:"+ emps.getEmpDep());
					System.out.println("Employee Gender :"+ emps.getEmpGender());
					System.out.println("Employee City   :"+ emps.getEmpCity());
					
					System.out.println("=======================================================");
				}
			}else if(choice == 5) {
				System.out.println("Enter Employee ID :");
				int empId = sc.nextInt();
				try {
					String msg = empController.deleteEmployeeById(empId);
					System.out.println(msg);
				}catch(EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
			}else if(choice == 6) {
				String msg = empController.deleteAllEmployee();
				
				System.out.println(msg);
			}else if(choice == 7) {
				try {
					ArrayList<Employee> employees = empController.getAllMaleEmployees();
					
					for(Employee employee : employees) {
						System.out.println("Empolyee ID     :"+ employee.getEmpId());
						System.out.println("Employee Name   :"+ employee.getEmpName());
						System.out.println("Employee Salary :"+ employee.getEmpSalary());
						System.out.println("Employee Department:"+ employee.getEmpDep());
						System.out.println("Employee Gender :"+ employee.getEmpGender());
						System.out.println("Employee City   :"+ employee.getEmpCity());
						
						System.out.println("=======================================================");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}else if(choice == 8) {
				try {
					ArrayList<Employee> employees = empController.getAllFemaleEmployees();
					
					for(Employee employee : employees) {
						System.out.println("Empolyee ID     :"+ employee.getEmpId());
						System.out.println("Employee Name   :"+ employee.getEmpName());
						System.out.println("Employee Salary :"+ employee.getEmpSalary());
						System.out.println("Employee Department:"+ employee.getEmpDep());
						System.out.println("Employee Gender :"+ employee.getEmpGender());
						System.out.println("Employee City   :"+ employee.getEmpCity());
						
						System.out.println("=======================================================");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else if(choice == 9){
				System.out.println("Thank you.");
				break;
			}else {
				System.out.println("Invalide Choice,Please try Agains.");
			}
			
		}
	}
}
