package com.springboot2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot2.exception.NotFoundException;
import com.springboot2.model.Employee;
import com.springboot2.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> saveAll1(List<Employee> emp) {
		return employeeRepository.saveAll(emp);
	}
	public Employee save1(Employee emp) {
		return employeeRepository.save(emp);
	}
	public List<Employee> showAll1(){
		return employeeRepository.findAll();
	}
	public Employee getById1(int id) {
		return employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Display Operation, Employee Not Found " + id));
	}
	public void deleteAll1() {
		employeeRepository.deleteAll();
	}
	public void deleteById1(int id) {
		employeeRepository.deleteById(id);
	}
	public List<Employee> updateAll1(List<Employee> emp) {
		return employeeRepository.saveAll(emp); //update and insert
	}
	public Employee updateById1(int id, String newName, String newEmail, Long newMobile) {
	    Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Update Operation, Employee Not Found " + id));	    
	    if (existingEmployee != null) {
	    	if (newName != null && !newName.trim().isEmpty()) {
	            existingEmployee.setName(newName);
	        }
	        if (newEmail != null && !newEmail.trim().isEmpty()) {
	            existingEmployee.setEmail(newEmail);
	        }
	        if (newMobile != null && newMobile != 0) { 
	            existingEmployee.setMobile(newMobile);
	        }
	        return employeeRepository.save(existingEmployee);
	    }
	    return null; 
	}
    public Employee updateName1(int id, String newName) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Update Operation, Employee Not Found " + id));
        if (existingEmployee != null) {
            existingEmployee.setName(newName);
            return employeeRepository.save(existingEmployee);
        }
        return null; 
    }
    public Employee updateEmail1(int id, String newEmail) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Update Operation, Employee Not Found " + id));
        if (existingEmployee != null) {
            existingEmployee.setEmail(newEmail);
            return employeeRepository.save(existingEmployee);
        }
        return null; 
    }
    public Employee updateMobile1(int id, long newMobile) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Update Operation, Employee Not Found " + id));
        if (existingEmployee != null) {
            existingEmployee.setMobile(newMobile);
            return employeeRepository.save(existingEmployee);
        }
        return null; 
    }
}
