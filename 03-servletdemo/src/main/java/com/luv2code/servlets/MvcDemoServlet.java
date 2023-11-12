package com.luv2code.servlets;

import com.luv2code.servlets.pojo.Student;
import com.luv2code.servlets.util.StudentDataUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MvcDemoServlet", value = "/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = StudentDataUtil.getStudents();
        request.setAttribute("student_list", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view-students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}