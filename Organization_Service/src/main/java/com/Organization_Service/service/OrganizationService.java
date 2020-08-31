package com.Organization_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Organization_Service.model.Department;
import com.Organization_Service.model.DepartmentList;
import com.Organization_Service.model.Employee;
import com.Organization_Service.model.EmployeeList;


@Service
public class OrganizationService {
	@Autowired
	private RestTemplate restTemplate;
	
	
	public DepartmentList getAllDepartments(){
		return  restTemplate.getForObject("http://department-service/dept", DepartmentList.class);
	}
	
	
	public EmployeeList getAllEmployees(){
		return  restTemplate.getForObject("http://employee-service/emp", EmployeeList.class);
	}
	
	public Department getDepartmentById(int id) {
		 return  restTemplate.getForObject("http://department-service/listDept/"+id, Department.class);
	}
	
	public Employee getEmployeeById(int id) {
		return  restTemplate.getForObject("http://employee-service/listEmp/"+id, Employee.class);
	}
	
	public Department insertDepartment(Department department) {
		return restTemplate.postForObject("http://department-service/addDept", department, Department.class);
	}
	
	public Employee insertEmployee(Employee employee) {
		return restTemplate.postForObject("http://employee-service/addEmp", employee, Employee.class);
	}
	
	public void updateDepartment(int id ,Department department) {
		   restTemplate.put("http://department-service/updateDept/"+id, department);
		 
	}
	
	public void updateEmployee(int id ,Employee employee) {
		 restTemplate.put("http://employee-service/updateEmp/"+id, employee);
	}
	
	public void deleteDepartment(int id) {
		restTemplate.delete("http://department-service/deleteDept/"+id);
	}
	
	public void deleteEmployee(int id) {
		restTemplate.delete("http://employee-service/deleteEmp/"+id);
	}
	
	public EmployeeList getAllEmployeesByDeptId(int deptId){
		return   restTemplate.getForObject("http://employee-service/empList/"+deptId, EmployeeList.class);
	}
	

}
