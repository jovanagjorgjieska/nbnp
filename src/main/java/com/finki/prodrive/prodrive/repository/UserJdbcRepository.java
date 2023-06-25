package com.finki.prodrive.prodrive.repository;

import com.finki.prodrive.prodrive.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcRepository {

    /*
    * Samo metodov dodaj go na postoeckata klasa
    * */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM ds_user";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String gender = rs.getString("gender");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String phoneNumber = rs.getString("phone_number");
                String address = rs.getString("address");
                String email = rs.getString("email");

                User user = new User();
                user.setUsername(username);
                user.setName(name);
                user.setSurname(surname);
                user.setGender(gender);
                user.setDateOfBirth(dateOfBirth);
                user.setPhoneNumber(phoneNumber);
                user.setAddress(address);
                user.setEmail(email);

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
