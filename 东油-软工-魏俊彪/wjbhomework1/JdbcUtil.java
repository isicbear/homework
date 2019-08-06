package day19;

import java.sql.*;

public class JdbcUtil {
    private  static  final day19.JdbcUtil JDBC_UTIL = new day19.JdbcUtil();

    private JdbcUtil(){

    }

    public static day19.JdbcUtil getInstance(){
        return JDBC_UTIL;
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitery", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void closeResource(AutoCloseable autoCloseable) {
        if (null != autoCloseable) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
