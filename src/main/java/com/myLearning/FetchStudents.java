package com.myLearning;

import java.sql.*;

public class FetchStudents {

    static final String url = "jdbc:mysql://localhost:3306/jdbc1";
    static final String username = "root";
    static final String password = "1234";

    public static void main(String[] args) {
        String sql = "UPDATE student SET student_name = 'Dhinka_chika' WHERE student_id = 6";


        try(
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ) {

           System.out.println("connection established");
           System.out.println("fetching students");

           //loop through each row in resultset

            while(rs.next()){
                int id = rs.getInt("UserId");
                String name = rs.getString("UserName");
                int age = rs.getInt("Age");
                String email = rs.getString("Email");

                System.out.printf("| %-2d | %-10s | %-3d | %-25nexts |\n",
                        id, name, age, email);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
           e.printStackTrace();
        }

    }
}
