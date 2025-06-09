import { useState } from "react";
import "./SignupPage.css";

export default function SignupPage() {
    const [form, setForm] = useState({ username: "", email: "", password: "" });
    const [message, setMessage] = useState("");

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const res = await fetch(
                `${import.meta.env.VITE_API_BASE}/auth/signup`,
                {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(form),
                }
            );

            const text = await res.text();
            if (res.ok) {
                setMessage("User registered successfully!");
            } else {
                setMessage("Signup failed: " + text);
            }
        } catch {
            setMessage("Connection error.");
        }
    };

    return (
        <div className="auth-page">
            <h2>Signup</h2>
            <form onSubmit={handleSubmit}>
                <input name="username" placeholder="Username" onChange={handleChange} />
                <input name="email" placeholder="Email" onChange={handleChange} />
                <input type="password" name="password" placeholder="Password" onChange={handleChange} />
                <button type="submit">Sign up</button>
            </form>
            <p className="auth-message">{message}</p>
        </div>
    );
}
