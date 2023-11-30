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
            case "LOAD":
                loadStudent(request, response);
                break;
            case "UPDATE":
                updateStudent(request, response);
                break;
            default:
                listStudents(request, response);
        }
    }

    @SneakyThrows
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        Student theStudent = new Student(
                Integer.parseInt(request.getParameter("studentId")),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("email")
        );
        studentDbUtil.updateStudent(theStudent);

        listStudents(request, response);
    }

    @SneakyThrows
    private void loadStudent(HttpServletRequest request, HttpServletResponse response) {
        String theStudentId = request.getParameter("studentId");
        Student theStudent = studentDbUtil.getStudent(theStudentId);
        request.setAttribute("the_student", theStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update-student-form.jsp");
        dispatcher.forward(request, response);
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