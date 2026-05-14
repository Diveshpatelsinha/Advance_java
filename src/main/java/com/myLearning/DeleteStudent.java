package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudent {
    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static void main(String[] args) {
        String sql = "DELETE FROM student WHERE student_id = 3";

        try(
                Connection conn = DriverManager.getConnection(url, user, password);
            Statement smt = conn.createStatement();
            ){

            System.out.println("Deleting student with id 3");

            int result = smt.executeUpdate(sql);

            if(result == 1){
                System.out.println("Deleted student with id 3");
                System.out.println("rows affected: "+ result);
            }else{
                System.out.println("Error deleting student with id 3");
            }

        }catch(SQLException e ){
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
        }

    }
}
