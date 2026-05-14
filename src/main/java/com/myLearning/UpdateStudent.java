package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static void main(String[] args) {

        String sql = "UPDATE student SET student_name = 'Deepak' WHERE student_id = 5";

        try (
               Connection conn = DriverManager.getConnection(url, user, password);
                Statement smt = conn.createStatement();
                ){

            System.out.println("updating student......");
            int rs = smt.executeUpdate(sql);

            if(rs != 1){
                System.out.println("error no student found");
            }else{
                System.out.println("student updated successfully");
            }

        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }


    }
}
