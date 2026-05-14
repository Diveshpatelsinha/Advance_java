package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudent {
    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String username = "root";
    static final String password = "1234";

    public static void main(String[] args) {
        String sql = "INSERT INTO student (student_id, student_name, course, marks) VALUES ('6', 'Dinkar', 'Btech', '85')";


        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement smt = conn.createStatement();
                ){

            System.out.println("Inserting student into table...");
            int i = smt.executeUpdate(sql);

            if (i > 0) {
                System.out.println("Student successfully inserted into table...");
                System.out.println("Rows affected: " + i);
            }else{
                System.out.println("Failed to insert into table...");
            }

        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
