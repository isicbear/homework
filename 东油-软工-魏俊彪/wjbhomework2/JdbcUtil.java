package day19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    private static String url = "jdbc:mysql://localhost:3306/train";
    private static String user = "root";
    private static String password = "123456";
    /**
     * 获取数据库
     * @return 数据库连接
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭
     * @param resource 要关闭的资源
     */
    public static void closeResource(AutoCloseable resource) {
        if (null != resource) {
            try {
                resource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
