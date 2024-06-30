import React from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Route, BrowserRouter, Routes, Link as RouterLink } from "react-router-dom";
import Home from "./components/Home";
import SignIn from "./components/SignIn";
import LogIn from "./components/Login";
import SignUp from "./components/SignUp";

const App = () => {
  return (
    <>
    <ToastContainer theme="light" position="top-center" />
    <BrowserRouter>
      <Routes>
          {/* <Route path="/" element={<SignIn toast={toast} />} />
          <Route path="/home" element={<Home  toast={toast} />} /> */}
          <Route path="/" element={<LogIn  toast={toast} />} >
            <Route path="/" element={<SignIn toast={toast} />}/>
            <Route path="/signup" element={<SignUp toast={toast} />}/>
          </Route>
      </Routes>
    </BrowserRouter>
    </>
  );
};

export default App;
