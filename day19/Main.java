package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 学生入住
 * student：学生信息表
 * studentCount：学生人数表
 * studentSum：数学人数
 *
 */
public class Main {
    public static void main(String[] args) {
        studentAdd();
    }

    public static void studentAdd(){
        //获取连接
        Connection connection = JdbcUtil.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            //关闭自动提交功能
            connection.setAutoCommit(false);
            //创建SQL语句
            String sql = "insert into student values(null,001,张三,男,19)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            // 学生入住后数量加一
            String sqlUpdate = "update studentCount set studentSum = studentSum + 1 ";
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.executeUpdate();

            //手动提交修改，是SQL执行修改到数据库中
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JdbcUtil.closeResource(preparedStatement);
            JdbcUtil.closeResource(connection);
        }
    }
}
