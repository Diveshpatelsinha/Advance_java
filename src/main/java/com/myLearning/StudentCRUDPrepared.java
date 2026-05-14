package com.myLearning;
import java.sql.*;
public class StudentCRUDPrepared {

    static final String url = "jdbc:mysql://localhost:3306/student";
    static final String user = "root";
    static final String password = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    // Create.......

    static void insert(int id, String name, String course, int marks ){
        String sql = "INSERT INTO student(student_id, student_name,course,marks) VALUES(?,?,?,?)";

        try(
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setInt(4, marks);

            System.out.println("Insert rows: "+ps.executeUpdate());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Read all........

    static void readAll(){
        String sql = "SELECT * FROM student";

        try(
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            System.out.println("Read all rows: "+rs);
            while(rs.next()){
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String course = rs.getString("course");
                int marks = rs.getInt("marks");
                System.out.println(id+" | "+name+" | "+course+" | "+marks);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Update...........

    static void update(int id, String course){
        String sql = "UPDATE student SET course = ? WHERE student_id = ?";

        try (
                Connection        con = getConnection();
                PreparedStatement ps  = con.prepareStatement(sql)
        ) {
            ps.setString(1, course);
            ps.setInt   (2, id);
            System.out.println("UPDATE -> rows: " + ps.executeUpdate());

        } catch (SQLException e) { e.printStackTrace(); }

    }

    //Delete......

    static void delete(int id) {

        String sql = "DELETE FROM student WHERE student_id = ?";

        try (
                Connection        con = getConnection();
                PreparedStatement ps  = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            System.out.println("DELETE -> rows: " + ps.executeUpdate());

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void main(String args[]){
        System.out.println(" Student CRUD with PreparedStatement");

        readAll();

        System.out.println("Inserting Vaibhav...");
        insert(7, "vaibhav", "BCA", 75);

        readAll();

        System.out.println("Updating Vaibhav...");

        update(7, "MBA");
        readAll();

        System.out.println("Deleting Vaibhav...");
        delete(7);

        readAll();

        System.out.println("Done!!");


    }

}
