package com.capgemini.employeeRegistrationForm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employeeRegistrationForm.model.Employee;
import com.capgemini.employeeRegistrationForm.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
public class EmployeeController {	
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/SPRINGinsert")
	public List<Employee> saveAll2(@RequestBody List<Employee> emp) {
		return employeeService.saveAll1(emp);
	}

	@PostMapping("/SPRINGinsert/solo")
	public Employee save2(@RequestBody Employee emp) {
		return employeeService.save1(emp);
	}

	@PostMapping("/SPRINGlogin")
    public Employee login(@RequestBody Employee credentials) {
        return employeeService.login(credentials.getUsername(), credentials.getPassword());
    }

	@GetMapping("/SPRINGdisplay")
	public List<Employee> showAll2(){
		return employeeService.showAll1();
	}

	@GetMapping("/SPRINGdisplay/{id}")
	public Employee getById2(@PathVariable int id) {
		return employeeService.getById1(id);
	}

	@DeleteMapping("/SPRINGdelete")
	public void deleteAll2() {
		employeeService.deleteAll1();
	}

	@DeleteMapping("/SPRINGdelete/{id}")
	public void deleteById2(@PathVariable int id) {
		employeeService.deleteById1(id);
	}

	@PutMapping("/SPRINGupdate")
	public List<Employee> updateAll2(@RequestBody List<Employee> emp){
		return employeeService.updateAll1(emp);
	}

	@PutMapping("/SPRINGupdate/{id}")
	public Employee updateById2(@PathVariable int id, @RequestBody Employee updatedEmployee) {
		return employeeService.updateById1(id, updatedEmployee.getName(), updatedEmployee.getUsername(), updatedEmployee.getEmail(), updatedEmployee.getMobile());
	}

	@PatchMapping("/SPRINGupdate/{id}/name")
    public Employee updateName2(@PathVariable int id, @RequestParam String name) {
        return employeeService.updateName1(id, name);
    }

    @PatchMapping("/SPRINGupdate/{id}/username")
    public Employee updateUsername2(@PathVariable int id, @RequestParam String username) {
        return employeeService.updateUsername1(id, username);
    }

    @PatchMapping("/SPRINGupdate/{id}/email")
    public Employee updateEmail2(@PathVariable int id, @RequestParam String email) {
        return employeeService.updateEmail1(id, email);
    }

    @PatchMapping("/SPRINGupdate/{id}/mobile")
    public Employee updateMobile2(@PathVariable int id, @RequestParam String mobile) { // Changed to String
        return employeeService.updateMobile1(id, mobile);
    }
}