package com.luv2code.servlets.util;

import com.luv2code.servlets.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mary", "Public", "mary@luv2code.com"));
        students.add(new Student("John", "Doe", "john@luv2code.com"));
        students.add(new Student("Ajay", "Rao", "ajay@luv2code.com"));
        return students;
    }
}