package com.spring.Department_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Department_Service.model.Department;
import com.spring.Department_Service.model.DepartmentList;
import com.spring.Department_Service.service.DepartmentService;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	
	@GetMapping("/listDept")
	public List<Department> getAllDepartment(){
		return departmentService.getAllDepartments();
	}
	@GetMapping("/listDept/{id}")
	public Department getDeptById(@PathVariable int id) {
		return departmentService.getDeptById(id);
	}
	
	@GetMapping("/dept")
	public DepartmentList getDepartments(){
		List<Department> dept = departmentService.getAllDepartments();
		DepartmentList list = new DepartmentList();
		list.setDepartments(dept);
		return list;
		
	}
	
	
	@PostMapping("/addDept")
	public Department addDepartment(@RequestBody Department department) {
		departmentService.insertDepartment(department);
		return department;
	}
	
	@PutMapping("/updateDept/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable int id) {
		departmentService.updateDepartment(id,department);
		return department;
	}
	
	@DeleteMapping("/deleteDept/{id}")
	public String deleteDepartment(@PathVariable int id) {
		departmentService.deleteDepartment(id);
		return "Record Deleted";
		
	}

}
