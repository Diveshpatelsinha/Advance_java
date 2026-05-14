package com.myLearning;

import java.sql.*;

public class ExecuteQuery {

    static final String url= "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static void main(String[] args){

        String sql = "UPDATE student SET student_name = 'Dhinka_chika' WHERE student_id = 6";


        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Statement smt = con.createStatement();
                ){
            System.out.println("Connection established..");

            boolean i = smt.execute(sql);


               ResultSet rs = smt.getResultSet();

               while(rs.next()){
                   String name = rs.getString("student_name");
                   String course = rs.getString("course");
                   System.out.println(name+" | "+course);
               }



        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
