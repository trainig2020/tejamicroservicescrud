package com.Organization_Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Organization_Service.model.Department;
import com.Organization_Service.model.DepartmentList;
import com.Organization_Service.model.Employee;
import com.Organization_Service.model.EmployeeList;
import com.Organization_Service.service.OrganizationService;

@RestController
@RequestMapping("/organize")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("listDept")
	public DepartmentList getAllDepartments(){
		return organizationService.getAllDepartments();
	}
	
	@GetMapping("listEmp")
	public EmployeeList getAllEmployees(){
		return organizationService.getAllEmployees();
	}
	
	@GetMapping("listDept/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return organizationService.getDepartmentById(id);
	}
	
	@GetMapping("listEmp/{empid}")
	public Employee getEmployeeById(@PathVariable int empid) {
		return organizationService.getEmployeeById(empid);
	}
	
	
	
	@PostMapping("/addDept")
	public Department addDepartment(@RequestBody Department department) {
		return organizationService.insertDepartment(department);
	}
	
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee) {
		return organizationService.insertEmployee(employee);
	}
	
	@PutMapping("/updateDept/{id}")
	public String updateDepartment(@RequestBody Department department, @PathVariable int id) {
		 organizationService.updateDepartment(id, department);
		 return "Record Updated";
	}
	
	@PutMapping("/updateEmp/{empid}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int empid) {
		 organizationService.updateEmployee(empid, employee);
		 return "Record Updated";
	}
	
	@DeleteMapping("/deleteDept/{id}")
	public String deleteDepartment(@PathVariable int id) {
		organizationService.deleteDepartment(id);
		return "Record deleted";
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		organizationService.deleteEmployee(id);
		return "Record deleted";
	}
	
	@GetMapping("/emp/{deptId}")
	public EmployeeList getEmployeeByDeptId(@PathVariable int deptId) {
		return organizationService.getAllEmployeesByDeptId(deptId);
	}

}
