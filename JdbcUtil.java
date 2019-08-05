package com.train.day14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ：孙鹏
 * @date ：Created in 2019/8/5 0005 15:46
 * @description：
 * @version:
 */
public class JdbcUtil {
    private JdbcUtil(){

    }
    private static final JdbcUtil JDBC_UTIL=new JdbcUtil();
    public static JdbcUtil getInstance(){
        return JDBC_UTIL;
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bird", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * 关闭资源
     * @param closeable
     */
    public static void closeRes(AutoCloseable closeable){
        if(closeable!=null){
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
