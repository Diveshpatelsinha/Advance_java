package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdateStudent {

    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static void main(String[] args){
        String sql = "INSERT INTO student (student_id, student_name, course, marks) VALUES (3, 'Himanshu', 'LLB', 82)";


        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Statement smt = con.createStatement();
                ){

            System.out.println("connection established");

            boolean rs = smt.execute(sql);

            if(!rs){
                System.out.println("query updated successfully");
            }else{
                System.out.println("query update failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
