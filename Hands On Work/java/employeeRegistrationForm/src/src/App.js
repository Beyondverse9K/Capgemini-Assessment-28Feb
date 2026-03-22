import React, { useState } from 'react';
import Auth from './components/auth';
import Dashboard from './components/dashboard';

function App() {
    const [user, setUser] = useState(null);

    return (
        <div className="App">
            <video 
                autoPlay 
                loop 
                muted 
                playsInline 
                className="background-video"
            >
                <source src="/assets/video.mp4" type="video/mp4" />
            </video>
            <div className="content-wrapper">
                {user ? (
                    <Dashboard user={user} onLogout={() => setUser(null)} />
                ) : (
                    <Auth onLogin={(userData) => setUser(userData)} />
                )}
            </div>
        </div>
    );
}

export default App;