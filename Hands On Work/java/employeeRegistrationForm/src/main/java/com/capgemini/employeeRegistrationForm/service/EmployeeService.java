package com.capgemini.employeeRegistrationForm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.employeeRegistrationForm.exception.NotFoundException;
import com.capgemini.employeeRegistrationForm.model.Employee;
import com.capgemini.employeeRegistrationForm.model.LeaveRequest;
import com.capgemini.employeeRegistrationForm.model.LeaveStatus;
import com.capgemini.employeeRegistrationForm.repository.EmployeeRepository;
import com.capgemini.employeeRegistrationForm.repository.LeaveRequestRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Employee login(String username, String rawPassword) {
		Employee employee = employeeRepository.findByUsername(username);

		if (employee == null || !passwordEncoder.matches(rawPassword, employee.getPassword())) {
			throw new NotFoundException("Invalid username or password");
		}

		return employee;
	}
	
	public List<Employee> saveAll1(List<Employee> emp) {
		for(Employee e : emp) {
            e.setPassword(passwordEncoder.encode(e.getPassword()));
        }
		return employeeRepository.saveAll(emp);
	}
	
	public Employee save1(Employee emp) {
		emp.setPassword(passwordEncoder.encode(emp.getPassword()));
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
		return employeeRepository.saveAll(emp); 
	}
	
	public Employee updateById1(int id, String newName, String newUsername, String newEmail, String newMobile) {
	    Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Update Operation, Employee Not Found " + id));	    
	    
	    if (existingEmployee != null) {
	    	if (newName != null && !newName.trim().isEmpty()) {
	            existingEmployee.setName(newName);
	        }
	        if (newUsername != null && !newUsername.trim().isEmpty()) {
	            existingEmployee.setUsername(newUsername);
	        }
	        if (newEmail != null && !newEmail.trim().isEmpty()) {
	            existingEmployee.setEmail(newEmail);
	        }
	        if (newMobile != null && !newMobile.trim().isEmpty()) { 
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
    
    public Employee updateUsername1(int id, String newUsername) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Update Operation, Employee Not Found " + id));
        if (existingEmployee != null) {
            existingEmployee.setUsername(newUsername);
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
    
    public Employee updateMobile1(int id, String newMobile) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new NotFoundException("Failed Update Operation, Employee Not Found " + id));
        if (existingEmployee != null) {
            existingEmployee.setMobile(newMobile);
            return employeeRepository.save(existingEmployee);
        }
        return null; 
    }

	public LeaveRequest submitLeaveRequest(LeaveRequest request) {
		request.setStatus(LeaveStatus.PENDING);
		return leaveRequestRepository.save(request);
	}

	public List<LeaveRequest> getLeavesByEmployeeId(Integer empId) {
		return leaveRequestRepository.findByEmployeeId(empId);
	}

	public List<LeaveRequest> getAllLeaveRequests() {
		return leaveRequestRepository.findAll();
	}

	public LeaveRequest updateLeaveStatus(Integer leaveId, LeaveStatus status) {
		LeaveRequest leave = leaveRequestRepository.findById(leaveId).orElseThrow(() -> new NotFoundException("Leave Request Not Found: " + leaveId));
		leave.setStatus(status);
		return leaveRequestRepository.save(leave);
	}

}