import React from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Route, BrowserRouter, Routes } from "react-router-dom";
import Home from "./components/Home";
import SignIn from "./components/SignIn";

const App = () => {
  return (
    <>
    <ToastContainer theme="light" position="top-center" />
    <BrowserRouter>
      <Routes>
          <Route path="/" element={<SignIn toast={toast} />} />
          <Route path="/home" element={<Home  toast={toast} />} />
      </Routes>
    </BrowserRouter>
    </>
  );
};

export default App;
