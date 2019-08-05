package day18;

import java.sql.*;

public class DemoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc.mysql://localhost:3306/hahahaha","root","123456");
        Statement statement = connection.createStatement();
        String sql = "select * from hero";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt("1");
            String sno = rs.getString("2");
            String sname = rs.getString("3");
            String ssex = rs.getString("4");
            int age = rs.getInt("5");


            System.out.println(id + "," + sno + "," + sname + "," + ssex + "," +age);
        }
        rs.close();
        statement.close();
        connection.close();
    }
}
