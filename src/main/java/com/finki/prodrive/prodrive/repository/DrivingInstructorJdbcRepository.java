package com.finki.prodrive.prodrive.repository;

import com.finki.prodrive.prodrive.model.DrivingInstructor;
import com.finki.prodrive.prodrive.model.StudentDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrivingInstructorJdbcRepository {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/nbnp";

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "";

    public List<DrivingInstructor> getAllDrivingInstructors() {
        List<DrivingInstructor> instructors = new ArrayList<>();

        String sql = "SELECT * FROM instructor_details";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String username = rs.getString("di_username");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String gender = rs.getString("gender");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String phoneNumber = rs.getString("phone_number");
                String address = rs.getString("address");
                String email = rs.getString("email");
                Date employmentDate = rs.getDate("employment_date");

                DrivingInstructor instructor = new DrivingInstructor();
                instructor.setUsername(username);
                instructor.setName(name);
                instructor.setSurname(surname);
                instructor.setGender(gender);
                instructor.setDateOfBirth(dateOfBirth);
                instructor.setPhoneNumber(phoneNumber);
                instructor.setAddress(address);
                instructor.setEmail(email);
                instructor.setEmploymentDate(employmentDate);

                instructors.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructors;
    }

    //Returns only the students that were assigned to a particular driving instructor
    public List<StudentDto> getInstructorsAssignedInstructors(String username) {
        List<StudentDto> studentDtos = new ArrayList<>();

        String sql = "SELECT * FROM driving_instructor_students WHERE driving_instructor_username = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    String studentUsername = rs.getString("student_username");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");

                    StudentDto studentDto = new StudentDto();
                    studentDto.setUsername(studentUsername);
                    studentDto.setName(name);
                    studentDto.setSurname(surname);

                    studentDtos.add(studentDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentDtos;
    }
}
