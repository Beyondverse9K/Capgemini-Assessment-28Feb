import React, { useState, useEffect } from 'react';

export default function EmployeeDashboard({ user, onLogout }) {
    const [leaves, setLeaves] = useState([]);
    const [leaveForm, setLeaveForm] = useState({ startDate: '', endDate: '', reason: '' });

    // Fetch this employee's leave history on load
    useEffect(() => {
        fetchLeaves();
    }, []);

    const fetchLeaves = async () => {
        try {
            const response = await fetch(`http://localhost:49152/employee/${user.id}/leaves`);
            if (response.ok) setLeaves(await response.json());
        } catch (error) {
            console.error("Failed to fetch leaves", error);
        }
    };

    const handleLeaveSubmit = async (e) => {
        e.preventDefault();
        const payload = {
            employeeId: user.id,
            employeeName: user.name,
            startDate: leaveForm.startDate,
            endDate: leaveForm.endDate,
            reason: leaveForm.reason
        };

        try {
            const response = await fetch('http://localhost:49152/employee/leave', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(payload)
            });
            if (response.ok) {
                alert("Leave requested successfully!");
                setLeaveForm({ startDate: '', endDate: '', reason: '' });
                fetchLeaves(); // Refresh the table
            }
        } catch (error) {
            alert("Failed to submit leave request.");
        }
    };

    return (
        <div className="dashboard-container dashboard-wide">
            <div className="dashboard-header">
                <h1>Employee Portal</h1>
                <button className="logout-btn" onClick={onLogout}>Logout</button>
            </div>

            <div className="dashboard-grid">
                {/* Left Column: Profile */}
                <div className="glass-panel">
                    <h2>My Profile</h2>
                    <p><strong>Name:</strong> {user.name}</p>
                    <p><strong>Username:</strong> {user.username}</p>
                    <p><strong>Email:</strong> {user.email}</p>
                    <p><strong>Mobile:</strong> {user.mobile}</p>
                </div>

                {/* Right Column: Request Leave */}
                <div className="glass-panel">
                    <h2>Request Leave</h2>
                    <form onSubmit={handleLeaveSubmit} className="leave-form">
                        <input type="date" value={leaveForm.startDate} onChange={(e) => setLeaveForm({...leaveForm, startDate: e.target.value})} required />
                        <input type="date" value={leaveForm.endDate} onChange={(e) => setLeaveForm({...leaveForm, endDate: e.target.value})} required />
                        <input type="text" placeholder="Reason for leave..." value={leaveForm.reason} onChange={(e) => setLeaveForm({...leaveForm, reason: e.target.value})} required />
                        <button type="submit">Submit Request</button>
                    </form>
                </div>
            </div>

            {/* Bottom Row: Leave History Table */}
            <div className="glass-panel table-panel">
                <h2>My Leave History</h2>
                <table className="glass-table">
                    <thead>
                    <tr>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Reason</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    {leaves.map(leave => (
                        <tr key={leave.id}>
                            <td>{leave.startDate}</td>
                            <td>{leave.endDate}</td>
                            <td>{leave.reason}</td>
                            <td><span className={`status-badge ${leave.status}`}>{leave.status}</span></td>
                        </tr>
                    ))}
                    {leaves.length === 0 && <tr><td colSpan="4">No leave requests found.</td></tr>}
                    </tbody>
                </table>
            </div>
        </div>
    );
}