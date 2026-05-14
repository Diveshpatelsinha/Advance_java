package com.myLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedSelect {
    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static void main(String[] args) {
        String sql = "select * from student where course = ?";
        String course = "MCA";

       try(
               Connection conn = DriverManager.getConnection(url, user, password);
               PreparedStatement ps = conn.prepareStatement(sql)
               ){

           ps.setString(1, course);

           ResultSet rs = ps.executeQuery();

           System.out.println("Searching for : "+course);
           System.out.println();

           if(rs.next()){
               System.out.println("Student found");
               System.out.println("Name: "+rs.getString("student_name"));
               System.out.println("Course: "+rs.getString("course"));


           }
           else{
               System.out.println("No student found with course name: " + course);
           }

       }catch(Exception e){
           System.out.println(e.getMessage());
           e.printStackTrace();
        }
    }
}
