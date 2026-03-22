package com.capgemini.employeeRegistrationForm.controller;

import com.capgemini.employeeRegistrationForm.model.LeaveRequest;
import com.capgemini.employeeRegistrationForm.model.LeaveStatus;
import com.capgemini.employeeRegistrationForm.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LeaveRequestController {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @PostMapping("/SPRINGleave")
    public LeaveRequest requestLeave(@RequestBody LeaveRequest request) {
        request.setStatus(LeaveStatus.PENDING);
        return leaveRequestRepository.save(request);
    }

    @GetMapping("/SPRINGleave/employee/{empId}")
    public List<LeaveRequest> getEmployeeLeaves(@PathVariable Integer empId) {
        return leaveRequestRepository.findByEmployeeId(empId);
    }

    @GetMapping("/SPRINGleave")
    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestRepository.findAll();
    }

    @PatchMapping("/SPRINGleave/{id}/status")
    public LeaveRequest updateLeaveStatus(@PathVariable Integer id, @RequestParam LeaveStatus status) {
        LeaveRequest leave = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus(status);
        return leaveRequestRepository.save(leave);
    }
}