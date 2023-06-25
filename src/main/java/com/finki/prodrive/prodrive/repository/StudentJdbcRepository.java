package com.finki.prodrive.prodrive.repository;

import com.finki.prodrive.prodrive.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentJdbcRepository {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/nbnp";

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "";

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM student_details";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String studentUsername = rs.getString("student_username");
                String studentName = rs.getString("name");
                String studentSurname = rs.getString("surname");
                String gender = rs.getString("gender");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String phoneNumber = rs.getString("phone_number");
                boolean firstAidCertificate = rs.getBoolean("first_aid_certificate");
                String address = rs.getString("address");
                boolean hasDriversLicence = rs.getBoolean("drivers_licence");

                Student student = new Student();
                student.setUsername(studentUsername);
                student.setName(studentName);
                student.setSurname(studentSurname);
                student.setGender(gender);
                student.setDateOfBirth(dateOfBirth);
                student.setPhoneNumber(phoneNumber);
                student.setFirstAidCertificate(firstAidCertificate);
                student.setAddress(address);
                student.setHasDriversLicence(hasDriversLicence);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // Add other methods as needed, such as getById, insert, update, delete, etc.
}
