package com.finki.prodrive.prodrive.repository;

import com.finki.prodrive.prodrive.model.StudentDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherJdbcRepository {

    /*
    Ovaj metod samo dodaj go vo ovaja klasa, poso vidov veke deka ja imas kreirano klasava
    i deka imas dodaeno metodi
     */

    public List<StudentDto> getTeachersAssignedStudents(String username) {
        List<StudentDto> studentDtos = new ArrayList<>();

        String sql = "SELECT * FROM teacher_students WHERE teacher_username = ?";

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
