import { useNavigate } from "react-router-dom";

export default function HomePage() {
    const navigate = useNavigate();

    return (
        <div className="min-h-screen bg-gray-100 flex flex-col">
            {/* Header */}
            <header className="flex justify-end p-4 bg-white shadow-md">
                <button
                    onClick={() => navigate("/login")}
                    className="px-4 py-2 text-sm font-semibold text-blue-600 hover:underline"
                >
                    Login
                </button>
                <button
                    onClick={() => navigate("/signup")}
                    className="ml-4 px-4 py-2 text-sm font-semibold text-white bg-blue-600 rounded hover:bg-blue-700"
                >
                    Sign Up
                </button>
            </header>

            {/* Center Logo or Hero */}
            <main className="flex-1 flex items-center justify-center">
                <div className="text-center">
                    {/* You can place a logo or image here later */}
                    <div className="w-48 h-48 bg-gray-300 rounded-full mx-auto mb-6" />
                    <h1 className="text-3xl font-bold text-gray-800">Welcome to TicketTracker</h1>
                    <p className="mt-2 text-gray-600">Track concerts. Stay updated. Never miss a show.</p>
                </div>
            </main>
        </div>
    );
}
