package com.learn.mapstruct.springmapstruct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.mapstruct.springmapstruct.dto.EmployeeDto;
import com.learn.mapstruct.springmapstruct.entity.Employee;
import com.learn.mapstruct.springmapstruct.mapper.EmployeeMapper;
import com.learn.mapstruct.springmapstruct.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	EmployeeMapper empMapper;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmpl(@RequestBody EmployeeDto employeeDto){
		
		return new ResponseEntity(employeeRepo.save(empMapper.DtoToEntity(employeeDto)), HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> findAllEmployees(){
		
		return new ResponseEntity(empMapper.entitysToDtos(employeeRepo.findAll()), HttpStatus.OK);
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<List<Employee>> findOneEmployee(@PathVariable(value="empid") int id){
		
		return new ResponseEntity(empMapper.entityToDto(employeeRepo.findById(id).get()), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public ResponseEntity<Void> deleteOneEmployee(@PathVariable(value="empid") int id){
		EmployeeDto employee = empMapper.entityToDto(employeeRepo.findById(id).get());
		employeeRepo.deleteById(employee.getId());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
