package com.hibernate.dao;

import java.util.List;
import java.util.Objects;

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;

public class Main {
	public static void main(String[] args) {

		{
			DaoImpl d = new DaoImpl();

//			Department d1 = new Department("Testing", "Banglore");
//			d.addDept(d1);
//
//			Employee e = new Employee("lucky", "patkutwar", "lucky@gmail.com", 60000.75, d1);
//			d.addEmployee(e);
//			System.out.println(d);
//
//		}
//		Project p = new Project("tic tac toe", "this is project for gamming application");
//		d.addProject(p);

//			List<Employee> list = d.getSalary(25000);
//			for (Employee account : list) {
//
//				System.out.println(account);
//			}
//			List<Employee> list = d.getAscOrderLastName();
//			for (Employee account : list) {
//
//				System.out.println(account);
//			}
//			List<Department> list = d.getDeptPagination();
//			for (Department account : list) {
//
//				System.out.println(account);
//			}
//			long count =d.getCountEmp();
//			System.out.println(count);
//			double maxsalary =d.getMaxsalaryEmp();
//			System.out.println(maxsalary);

//		}
//			double maxsalary =d.getSumSalary();
//			System.out.println(maxsalary);
//		}
//			double maxsalary =d.getAvgSalary();
//			System.out.println(maxsalary);
//		}
//			List<Department> list = d.getDistinctCount();
//			System.out.println(list);
//
//			}
//			List<Employee> list = d.getEmployeeNamesDTO();
//			System.out.println(list);

//		}
//		List<Employee> list = d.get();
//		System.out.println(list);
//	}

//	         List<Object[]> firstAndLastNames = d.getFirstAndLastName();
//	         for (Object[] row : firstAndLastNames) {
//	             String firstName = (String) row[0];
//	             String lastName = (String) row[1];
//	             System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
//	         }

//			List<Object[]> idAndFirstnames = d.getIdAndFirstName();
//	         for (Object[] row : idAndFirstnames) {
//	             int id = (int) row[0];
//	             String firstname = (String) row[1];
//	             System.out.println("Employee ID: " + id + ", First Name: " + firstname);
//	         }
//			  List<Object[]> countEmployeesByDepartment =d.getEmpCountByDep();
//
//		        // Display the result
//		        for (Object[] row : countEmployeesByDepartment) {
//		            String departmentName = Objects.toString(row[0], "Unknown Department");
//		            long employeeCount = (long) row[1];
//		            System.out.println("Department: " + departmentName + ", Employee Count: " + employeeCount);
//		        }
//			List<Employee> employee= d.getEmployeeNamesWithDepartments();
//
//	        // Display the result
//	        for (Employee d1: employee) {
//	            System.out.println(employee);
//	        }
			// List<Object[]> employeeAndDepartmentNames =
			// d.getEmployeeAndDepartmentNames();
//	         
//	         // Print employee names along with their department names
//	         for (Object[] row : employeeAndDepartmentNames) {
//	             String firstName = (String) row[0];
//	             String lastName = (String) row[1];
//	             String departmentName = (String) row[2];
//	             System.out.println("Employee: " + firstName + " " + lastName + ", Department: " + departmentName);
//	         }

			// List<Map<String, Object>> employeesWithDepartments =
			// d.getEmployeesWithDepartments();
//	        
//	        // Print employee details along with their department details
//	        for (Map<String, Object> row : employeesWithDepartments) {
//	            Integer employeeId = (Integer) row.get("employeeId");
//	            String firstName = (String) row.get("firstName");
//	            String lastName = (String) row.get("lastName");
//	            String email = (String) row.get("email");
//	            double salary = (double) row.get("salary");
//	            Integer departmentId = (Integer) row.get("departmentId");
//	            String departmentName = (String) row.get("departmentName");
//	            String location = (String) row.get("location");
//	            
//	            System.out.println("Employee ID: " + employeeId + ", Name: " + firstName + " " + lastName + 
//	                               ", Email: " + email + ", Salary: " + salary +
//	                               ", Department ID: " + departmentId + ", Department Name: " + departmentName +
//	                               ", Location: " + location);
//	        }
//	    }
//	    	List<Object[]> countEmployeesByDepartment =d.getEmpCountByDep();
			//
//	        // Display the result
//	        for (Object[] row : countEmployeesByDepartment) {
//	            String departmentName = Objects.toString(row[0], "Unknown Department");
//	            long employeeCount = (long) row[1];
//	            System.out.println("Department: " + departmentName + ", Employee Count: " + employeeCount);
//	        }

			// List<Map<String, Object>> departmentsWithEmployees =
			// d.getDepartmentsWithEmployees();
//	        
//	        // Print department details along with their employee details
//	        for (Map<String, Object> row : departmentsWithEmployees) {
//	            Integer departmentId = (Integer) row.get("departmentId");
//	            String departmentName = (String) row.get("departmentName");
//	            String departmentLocation = (String) row.get("departmentLocation");
//	            Integer employeeId = (Integer) row.get("employeeId");
//	            String employeeFirstName = (String) row.get("employeeFirstName");
//	            String employeeLastName = (String) row.get("employeeLastName");
//	            String employeeEmail = (String) row.get("employeeEmail");
//	            double employeeSalary = (double) row.get("employeeSalary");
//	            
//	            System.out.println("Department ID: " + departmentId + ", Name: " + departmentName + ", Location: " + departmentLocation);
//	            if (employeeId != null) {
//	                System.out.println("    Employee ID: " + employeeId + ", Name: " + employeeFirstName + " " + employeeLastName + 
//	                                   ", Email: " + employeeEmail + ", Salary: " + employeeSalary);
//	            } else {
//	                System.out.println("    No employees in this department.");
//	            }
//	        }

			// List<Employee> employeesWithDepartments = d.getEmployeesWithDepartments1();
//	        
//	        // Print employee details along with their department details
//	        for (Employee employee : employeesWithDepartments) {
//	            System.out.println("Employee ID: " + employee.getId() + ", Name: " + employee.getFirstName() + " " + employee.getLastName() +
//	                               ", Email: " + employee.getEmail() + ", Salary: " + employee.getSalary() +
//	                               ", Department: " + (employee.getDepartment() != null ? employee.getDepartment().getName() : "No Department"));
//	        }

//	    	 List<Map<String, Object>> employeesWithDepartments = d.getEmployeesWithDepartments();
//	         
//	         // Print employee details along with their department details
//	         for (Map<String, Object> row : employeesWithDepartments) {
//	             Integer employeeId = (Integer) row.get("employeeId");
//	             String firstName = (String) row.get("firstName");
//	             String lastName = (String) row.get("lastName");
//	             String email = (String) row.get("email");
//	             double salary = (double) row.get("salary");
//	             Integer departmentId = (Integer) row.get("departmentId");
//	             String departmentName = (String) row.get("departmentName");
//	             String location = (String) row.get("location");
//	             
//	             System.out.println("Employee ID: " + employeeId + ", Name: " + firstName + " " + lastName + 
//	                                ", Email: " + email + ", Salary: " + salary +
//	                                ", Department ID: " + departmentId + ", Department Name: " + departmentName +
//	                                ", Location: " + location);
//	         }

//	List<Employee> employeesInPune = d.getEmployeesInPune();
//	        
//	        // Print employee details along with their department details
//	        for (Employee employee : employeesInPune) {
//	            System.out.println("Employee ID: " + employee.getId() + ", Name: " + employee.getFirstname() + " " + employee.getLastname() +
//	                               ", Email: " + employee.getEmail() + ", Salary: " + employee.getSalary() +
//	                               ", Department: " + (employee.getDepartment() != null ? employee.getDepartment().getName() : "No Department"));
//	        }
			d.insertDepartmentWithEmployeesOneToMany(); 
//			d.deleteEmployeeFromDepartmentOneToMany(06);
		}
	}
}



