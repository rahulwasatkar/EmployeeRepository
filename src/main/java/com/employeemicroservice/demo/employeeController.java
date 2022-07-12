package com.employeemicroservice.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class employeeController {
	
	@Autowired
	EmployeeRepository employeerepository;

	@GetMapping("/getmsg/{name}")
	public String sayhellow(@PathVariable String name) 
	{
		String template= "hellow team .. its ";
		return template + name;
	}
	
	@PostMapping("/saveEmp")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeerepository.save(employee);
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
	 Optional<Employee> oldemployee = employeerepository.findById(employee.getEmployeeId());
	 if(oldemployee.isPresent()) {
		 return new ResponseEntity<Employee>(employeerepository.save(employee),HttpStatus.CREATED);
	 }
	 
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getbyid/{id}")
	public Optional<Employee> getEmployeebyid(@PathVariable int id) {
		
		return employeerepository.findById(id);
	}
	
	@GetMapping("/getallemp")
	public List<Employee> getAllEmployee(){
		return employeerepository.findAll();
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String deleteEmployeebyid(@PathVariable int id) {
		if(employeerepository.findById(id).isPresent()) {
			employeerepository.deleteById(id);
			return "Employee Delete successfully";
		}
		else {
			return "Employee not found";
		}
	}
	

}
