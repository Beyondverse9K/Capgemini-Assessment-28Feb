import React, { useState } from 'react';

export default function Auth({ onLogin }) {
    // Controls the sliding animation class
    const [isActive, setIsActive] = useState(false);
    
    // Error handling state
    const [error, setError] = useState('');

    // Separate states for Login and Signup to keep things clean
    const [loginForm, setLoginForm] = useState({ username: '', password: '' });
    const [signupForm, setSignupForm] = useState({ name: '', username: '', email: '', mobile: '', password: '' });

    const handleLoginChange = (e) => setLoginForm({ ...loginForm, [e.target.name]: e.target.value });
    const handleSignupChange = (e) => setSignupForm({ ...signupForm, [e.target.name]: e.target.value });

    // Handle Registration
    const handleSignupSubmit = async (e) => {
        e.preventDefault();
        setError('');
        try {
            const response = await fetch('http://localhost:49152/SPRINGinsert/solo', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(signupForm)
            });

            if (response.ok) {
                alert("Registration successful! Please sign in.");
                setSignupForm({ name: '', username: '', email: '', mobile: '', password: '' }); // Clear form
                setIsActive(false); // Slide back to login screen
            } else {
                setError("Registration failed. Username may already exist.");
            }
        } catch (err) {
            setError("Server error. Is the backend running?");
        }
    };

    // Handle Login
    const handleLoginSubmit = async (e) => {
        e.preventDefault();
        setError('');
        try {
            const response = await fetch('http://localhost:49152/SPRINGlogin', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(loginForm)
            });

            if (response.ok) {
                const data = await response.json();
                onLogin(data); // Pass user data to App.js to show Dashboard
            } else {
                setError("Invalid username or password");
            }
        } catch (err) {
            setError("Server error. Is the backend running?");
        }
    };

    return (
        // The container class conditionally applies 'active' based on state
        <div className={`container ${isActive ? 'active' : ''}`} id="container">
            
            {/* --- SIGN UP FORM --- */}
            <div className="form-container sign-up">
                <form onSubmit={handleSignupSubmit}>
                    <h1>Create Account</h1>
                    <div className="social-icons">
                        <a href="mailto:capgemini@gmail.com" className="icon"><i className="fa-brands fa-google-plus-g"></i></a>
                        <a href="https://www.facebook.com/CapgeminiIndia/" className="icon"><i className="fa-brands fa-facebook-f"></i></a>
                        <a href="https://github.com/capgemini/" className="icon"><i className="fa-brands fa-github"></i></a>
                        <a href="https://www.linkedin.com/company/capgemini/" className="icon"><i className="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    {error && isActive && <span className="error-message">{error}</span>}
                    
                    <input type="text" name="name" placeholder="Full Name" value={signupForm.name} onChange={handleSignupChange} required />
                    <input type="text" name="username" placeholder="Username" value={signupForm.username} onChange={handleSignupChange} required />
                    <input type="email" name="email" placeholder="Email" value={signupForm.email} onChange={handleSignupChange} required />
                    <input type="text" name="mobile" placeholder="Mobile Number" value={signupForm.mobile} onChange={handleSignupChange} required />
                    <input type="password" name="password" placeholder="Password" value={signupForm.password} onChange={handleSignupChange} required />
                    
                    <button type="submit">Sign Up</button>
                </form>
            </div>

            {/* --- SIGN IN FORM --- */}
            <div className="form-container sign-in">
                <form onSubmit={handleLoginSubmit}>
                    <h1>Sign In</h1>
                    <div className="social-icons">
                         <a href="mailto:capgemini@gmail.com" className="icon"><i className="fa-brands fa-google-plus-g"></i></a>
                        <a href="https://www.facebook.com/CapgeminiIndia/" className="icon"><i className="fa-brands fa-facebook-f"></i></a>
                        <a href="https://github.com/capgemini/" className="icon"><i className="fa-brands fa-github"></i></a>
                        <a href="https://www.linkedin.com/company/capgemini/" className="icon"><i className="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    {error && !isActive && <span className="error-message">{error}</span>}

                    <input type="text" name="username" placeholder="Username" value={loginForm.username} onChange={handleLoginChange} required />
                    <input type="password" name="password" placeholder="Password" value={loginForm.password} onChange={handleLoginChange} required />
                    <button type="submit">Sign In</button>
                </form>
            </div>

            {/* --- TOGGLE PANELS --- */}
            <div className="toggle-container">
                <div className="toggle">
                    <div className="toggle-panel toggle-left">
                        <h1>Welcome Back!</h1>
                        <p>Enter your personal details to access CapGemini Portal</p>
                        <button className="hidden" onClick={() => setIsActive(false)}>Sign In</button>
                    </div>
                    <div className="toggle-panel toggle-right">
                        <h1>Hi There, Hello!</h1>
                        <p>Register with your personal details to access CapGemini Portal</p>
                        <button className="hidden" onClick={() => setIsActive(true)}>Sign Up</button>
                    </div>
                </div>
            </div>
            
        </div>
    );
}