package com.luv2code.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MvcDemoServlet", value = "/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] students = {"Susan", "Anil", "Mohamed", "Trupti"};
        request.setAttribute("student-list", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view-students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}