package com.luv2code.web;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class StudentDbUtil {
    private final DataSource dataSource;

    public List<Student> getStudents() throws Exception {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String sql = "SELECT * FROM student ORDER BY last_name";
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                students.add(new Student(id, firstName, lastName, email));
            }
            return students;
        } finally {
            close(connection, statement, resultSet);
        }
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @SneakyThrows
    public void addStudent(Student theStudent) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();
            String sql = "INSERT INTO student (first_name, last_name, email) values (?, ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, theStudent.getFirstName());
            statement.setString(2, theStudent.getLastName());
            statement.setString(3, theStudent.getEmail());

            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }

    @SneakyThrows
    public Student getStudent(String theStudentId) {
        Student theStudent;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            int studentId = Integer.parseInt(theStudentId);

            connection = dataSource.getConnection();
            String sql = "SELECT * FROM student WHERE id = ?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, studentId);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                theStudent = new Student(studentId, firstName, lastName, email);
            } else {
                throw new Exception(String.format("Could not find a student with id %d", studentId));
            }

            return theStudent;
        } finally {
            close(connection, statement, resultSet);
        }

    }

    @SneakyThrows
    public void updateStudent(Student theStudent) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();
            String sql = "UPDATE student " +
                    "SET first_name = ?, last_name = ?, email = ? WHERE id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, theStudent.getFirstName());
            statement.setString(2, theStudent.getLastName());
            statement.setString(3, theStudent.getEmail());
            statement.setInt(4, theStudent.getId());
            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }
}