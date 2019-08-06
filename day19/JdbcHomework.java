package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHomework {
    public static void main(String[] args) {
        findByStudentNameLike("孙%");
        System.out.println("");
        findOrderByField("sage");
        System.out.println("");
        findByFieldLikeOrderLimit("%",2,2);

    }

    /**
     * 按名字进行模糊查询
     * @param userName：名称字段
     */
    public static void findByStudentNameLike(String userName){
        //获取连接
        Connection connection = JdbcUtil.getInstance().getConnection();
        String sql = "select * from student where sname like ?";
        // 放外面方便关闭资源
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //为占位符依次设置值，索引从1开始
            preparedStatement.setString(1, userName);
            //执行查询
            rs = preparedStatement.executeQuery();
            //遍历结果集
            while (rs.next()){
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdept = rs.getString(5);
                System.out.println(sno + " , " + sname + " , " + ssex + " , " + sage + " , " + sdept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
    }

    /**
     * 根据某个字段进行排序（降序）的操作
     * @param fieldName：字段的名称
     */
    public static void findOrderByField(String fieldName){
        //获取连接
        Connection connection = JdbcUtil.getInstance().getConnection();
        String sql = "select * from student order by ? desc";
        // 放外面方便关闭资源
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //为占位符依次设置值，索引从1开始
            preparedStatement.setString(1, fieldName);
            //执行查询
            rs = preparedStatement.executeQuery();

            while (rs.next()){
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdepart = rs.getString(5);
                System.out.println(sno + " , " + sname + " , " + ssex + " , " + sage + " , " + sdepart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
    }

    /**
     * 完成根据姓名字段模糊查找并排序（升序），然后分页获取第二页数据的操作（每页显示2条）
     * @param fieldName
     * @param currPage：当前页数:2
     * @param pageSize：每页显示的条数:2
     */
    public static void findByFieldLikeOrderLimit(String fieldName,int currPage, int pageSize){
        //获取连接
        Connection connection = JdbcUtil.getInstance().getConnection();
        String sql = "select * from student where sname like ? ORDER BY sname ASC limit ?,? ";
        // 放外面方便关闭资源
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //为占位符依次设置值，索引从1开始
            preparedStatement.setString(1, fieldName);
            //用于指定查询记录的起始位置
            preparedStatement.setInt(2,(currPage - 1) * pageSize);
            //用于指定查询数据所返回的记录数
            preparedStatement.setInt(3,pageSize);
            //执行查询
            rs = preparedStatement.executeQuery();
            //遍历结果集
            while (rs.next()){
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt(4);
                String sdepart = rs.getString(5);
                System.out.println(sno + " , " + sname + " , " + ssex + " , " + sage + " , " + sdepart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
    }
}
