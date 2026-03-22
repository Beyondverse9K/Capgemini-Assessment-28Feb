import React from 'react';

export default function Dashboard({ user, onLogout }) {
    return (
        <div className="dashboard-container">
            <h1>Welcome, {user.name}!</h1>
            <p><strong>Employee ID:</strong> {user.id}</p>
            <p><strong>Username:</strong> {user.username}</p>
            <p><strong>Email:</strong> {user.email}</p>
            <p><strong>Mobile:</strong> {user.mobile}</p>
            
            <button onClick={onLogout} style={{ marginTop: '30px' }}>
                Logout
            </button>
        </div>
    );
}