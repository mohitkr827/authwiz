package com.authtools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc_dao {

    public List<user> getAllUsers() {
        List<user> userList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = jdbc_connect.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM userdata");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                String location = rs.getString("location");
                String regdate = rs.getString("regdate");
                user us = new user(id, name, email, phone, password, location, regdate);
                userList.add(us);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc_connect.close(conn, stmt, rs);
        }

        return userList;
    }

}
