package com.capgemini.employeeRegistrationForm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employeeRegistrationForm.exception.NotFoundException;
import com.capgemini.employeeRegistrationForm.model.LeaveRequest;
import com.capgemini.employeeRegistrationForm.model.LeaveStatus;
import com.capgemini.employeeRegistrationForm.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {
	
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;
	
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
