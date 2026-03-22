import React, { useState } from 'react';
import Auth from './components/Auth';
import EmployeeDashboard from './components/EmployeeDashboard';
import HRDashboard from './components/HRDashboard';

function App() {
    const [user, setUser] = useState(null);

    return (
        <div className="App">
            <video autoPlay loop muted playsInline className="background-video">
                <source src="/assets/video.mp4" type="video/mp4" />
            </video>
            <div className="dark-overlay"></div>

            <div className="content-wrapper">
                {!user ? (
                    <Auth onLogin={(userData) => setUser(userData)} />
                ) : user.role === 'HR' ? (
                    <HRDashboard user={user} onLogout={() => setUser(null)} />
                ) : (
                    <EmployeeDashboard user={user} onLogout={() => setUser(null)} />
                )}
            </div>
        </div>
    );
}

export default App;