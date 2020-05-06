package com.reyes.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reyes.tutorial.entity.Department;
import com.reyes.tutorial.mapper.DepartmentMapper;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@GetMapping("/dept/{id}")
	public Department getDept(@PathVariable("id") Integer id){
		return departmentMapper.getDeptById(id);
	}
	
	// 傳入參數會被物件會自動解析
	@GetMapping("/dept")
	public Department insertDept(Department department){
		departmentMapper.insertDepartment(department);
		return department;
	}
}
