package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedInsert {

    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static void main(String[] args) {

        String sql = "INSERT INTO student (student_id, student_name, course, marks) VALUES(?, ?, ?, ?)";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = con.prepareStatement(sql)
                ){

            ps.setInt(1,6);
            ps.setString(2,"monu");
            ps.setString(3,"Diploma");
            ps.setString(4,"70");

            int i = ps.executeUpdate();
            System.out.println("Student inserted successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
