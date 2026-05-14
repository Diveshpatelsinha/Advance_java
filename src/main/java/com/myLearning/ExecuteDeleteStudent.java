package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteDeleteStudent {

    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static void main(String[] args){
        String sql = "DELETE FROM student WHERE student_id = 3";
      try(
              Connection conn = DriverManager.getConnection(url, user, password);
              Statement smt = conn.createStatement();
              ){
          boolean rs = smt.execute(sql);

          if(!rs){
              System.out.println("Successful Deletion");
          }else{
              System.out.println("Failed Deletion");
          }

      }catch(SQLException e){
        System.out.println("SQLException: "+e.getMessage());
        e.printStackTrace();
        }

    }
}
