import React, { useState, useEffect } from 'react';

export default function HRDashboard({ user, onLogout }) {
    const [activeTab, setActiveTab] = useState('employees');
    const [employees, setEmployees] = useState([]);
    const [leaves, setLeaves] = useState([]);

    // Fetch data whenever the active tab changes
    useEffect(() => {
        if (activeTab === 'employees') fetchEmployees();
        if (activeTab === 'leaves') fetchLeaves();
    }, [activeTab]);

    // ==========================================
    // API CALLS (With Try/Catch and Correct URLs)
    // ==========================================

    const fetchEmployees = async () => {
        try {
            // Matches: @GetMapping("/SPRINGdisplay/hr")
            const res = await fetch('http://localhost:49152/SPRINGdisplay/hr');
            if (res.ok) {
                setEmployees(await res.json());
            } else {
                console.error("Endpoint not found or blocked by CORS.");
            }
        } catch (error) {
            console.error("Network error fetching employees:", error);
        }
    };

    const fetchLeaves = async () => {
        try {
            // Matches: @GetMapping("/hr/leaves")
            const res = await fetch('http://localhost:49152/hr/leaves');
            if (res.ok) {
                setLeaves(await res.json());
            } else {
                console.error("Endpoint not found or blocked by CORS.");
            }
        } catch (error) {
            console.error("Network error fetching leaves:", error);
        }
    };

    const deleteEmployee = async (id) => {
        if (!window.confirm("Delete this employee?")) return;
        try {
            // Matches: @DeleteMapping("/SPRINGdelete/hr/{id}")
            const res = await fetch(`http://localhost:49152/SPRINGdelete/hr/${id}`, { method: 'DELETE' });
            if (res.ok) {
                fetchEmployees(); // Refresh the table after deletion
            }
        } catch (error) {
            console.error("Error deleting employee", error);
        }
    };

    const updateLeaveStatus = async (leaveId, status) => {
        try {
            // Matches: @PatchMapping("/hr/leave/{leaveId}/status")
            const res = await fetch(`http://localhost:49152/hr/leave/${leaveId}/status?status=${status}`, { method: 'PATCH' });
            if (res.ok) {
                fetchLeaves(); // Refresh the table after approval/rejection
            }
        } catch (error) {
            console.error("Error updating leave", error);
        }
    };

    // ==========================================
    // RENDER UI
    // ==========================================

    return (
        <div className="dashboard-container dashboard-wide">
            <div className="dashboard-header">
                <h1>HR Command Center</h1>
                <div className="user-controls">
                    <span>Welcome, {user.name}</span>
                    <button className="logout-btn" onClick={onLogout}>Logout</button>
                </div>
            </div>

            <div className="tab-controls">
                <button 
                    className={activeTab === 'employees' ? 'active-tab' : ''} 
                    onClick={() => setActiveTab('employees')}
                >
                    Manage Employees
                </button>
                <button 
                    className={activeTab === 'leaves' ? 'active-tab' : ''} 
                    onClick={() => setActiveTab('leaves')}
                >
                    Manage Leaves
                </button>
            </div>

            <div className="glass-panel table-panel">
                
                {/* --- EMPLOYEES TAB --- */}
                {activeTab === 'employees' && (
                    <>
                        <h2>Employee Directory</h2>
                        <table className="glass-table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Role</th>
                                    <th>Email</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {employees.length > 0 ? employees.map(emp => (
                                    <tr key={emp.id}>
                                        <td>{emp.id}</td>
                                        <td>{emp.name}</td>
                                        <td><span className={`status-badge ${emp.role}`}>{emp.role}</span></td>
                                        <td>{emp.email}</td>
                                        <td>
                                            {/* Prevent the HR user from accidentally deleting themselves */}
                                            {emp.id !== user.id && emp.role !== 'HR' && (
                                                <button className="danger-btn" onClick={() => deleteEmployee(emp.id)}>Delete</button>
                                            )}
                                        </td>
                                    </tr>
                                )) : <tr><td colSpan="5" style={{textAlign: "center"}}>No employees found.</td></tr>}
                            </tbody>
                        </table>
                    </>
                )}

                {/* --- LEAVES TAB --- */}
                {activeTab === 'leaves' && (
                    <>
                        <h2>Company Leave Requests</h2>
                        <table className="glass-table">
                            <thead>
                                <tr>
                                    <th>Employee</th>
                                    <th>Dates</th>
                                    <th>Reason</th>
                                    <th>Status</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {leaves.length > 0 ? leaves.map(leave => (
                                    <tr key={leave.id}>
                                        <td>{leave.employeeName} (ID: {leave.employeeId})</td>
                                        <td>{leave.startDate} to {leave.endDate}</td>
                                        <td>{leave.reason}</td>
                                        <td><span className={`status-badge ${leave.status}`}>{leave.status}</span></td>
                                        <td>
                                            {/* Only show Approve/Reject buttons if the leave is still pending */}
                                            {leave.status === 'PENDING' && (
                                                <div className="action-buttons">
                                                    <button className="success-btn" onClick={() => updateLeaveStatus(leave.id, 'APPROVED')}>Approve</button>
                                                    <button className="danger-btn" onClick={() => updateLeaveStatus(leave.id, 'REJECTED')}>Reject</button>
                                                </div>
                                            )}
                                        </td>
                                    </tr>
                                )) : <tr><td colSpan="5" style={{textAlign: "center"}}>No leave requests found.</td></tr>}
                            </tbody>
                        </table>
                    </>
                )}
            </div>
        </div>
    );
}