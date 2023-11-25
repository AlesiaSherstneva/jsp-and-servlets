package com.luv2code.web;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import javax.sql.DataSource;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
    private StudentDbUtil studentDbUtil;

    @Resource(mappedName = "java:/studentProject")
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void init() {
        super.init();
        studentDbUtil = new StudentDbUtil(dataSource);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String theCommand = request.getParameter("command");
        if (theCommand == null) {
            theCommand = "LIST";
        }

        switch (theCommand) {
            case "LIST":
                listStudents(request, response);
                break;
            case "ADD":
                addStudents(request, response);
                break;
            default:
                listStudents(request, response);
        }
    }

    private void addStudents(HttpServletRequest request, HttpServletResponse response) {
        Student theStudent = new Student(
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("email")
        );
        studentDbUtil.addStudent(theStudent);

        listStudents(request, response);
    }

    @SneakyThrows
    private void listStudents(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("student_list", studentDbUtil.getStudents());
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}