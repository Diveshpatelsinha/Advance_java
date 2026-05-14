package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcFirst {
public static void main(String[] args) {

    String url = "jdbc:mysql://localhost:3306/jdbc1";
    String username = "root";
    String password = "1234";
    Connection conn = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");



         conn = DriverManager.getConnection(url, username, password);

         System.out.println("Connected to database successfully");






    } catch (ClassNotFoundException e) {
        System.out.println(" Driver not found: " + e.getMessage());
    } catch (SQLException e) {
        System.out.println(" Driver not found: " + e.getMessage());
    }finally{

        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
}
