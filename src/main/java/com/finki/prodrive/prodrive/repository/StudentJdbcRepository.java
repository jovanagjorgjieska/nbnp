package com.finki.prodrive.prodrive.repository;

import com.finki.prodrive.prodrive.model.Student;
import com.finki.prodrive.prodrive.model.StudentExamResults;

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

    public List<StudentExamResults> getResultsByUsername(String username) {
        List<StudentExamResults> results = new ArrayList<>();

        String sql = "SELECT * FROM student_exam_results WHERE student_username = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    String studentUsername = rs.getString("student_username");
                    int examId = rs.getInt("exam_id");
                    int attemptNumber = rs.getInt("attempt_number");
                    int points =  rs.getInt("points");
                    String type = rs.getString("type");
                    Date examDate = rs.getDate("exam_date");

                    StudentExamResults examResults = new StudentExamResults();
                    examResults.setStudentUsername(studentUsername);
                    examResults.setExamId(examId);
                    examResults.setAttemptNumber(attemptNumber);
                    examResults.setPoints(points);
                    examResults.setType(type);
                    examResults.setExamDate(examDate);

                    results.add(examResults);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }


    // Add other methods as needed, such as getById, insert, update, delete, etc.
}
