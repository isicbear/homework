package day19;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentOperator implements StudentOperatable {
    /**
     * 根据姓名模糊查找学生
     * @param stuName 姓名
     * @return 学生集合
     */
    @Override
    public List<Student> findByUserNameLike(String stuName) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student WHERE sname LIKE ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, "%" + stuName + "%");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStuNo(rs.getString("sno"));
                student.setStuName(rs.getString("sname"));
                student.setStuSex(rs.getString("ssex"));
                student.setStuAge(rs.getInt("sage"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(rs);
            JdbcUtil.closeResource(preparedStatement);
            JdbcUtil.closeResource(connection);
        }
        return studentList;
    }

    /**
     * 查询所有学生并根据学生姓名降序排列
     * @return 学生集合
     */
    @Override
    public List<Student> findOrderByUserName() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student ORDER BY sname DESC";
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStuNo(rs.getString("sno"));
                student.setStuName(rs.getString("sname"));
                student.setStuSex(rs.getString("ssex"));
                student.setStuAge(rs.getInt("sage"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(rs);
            JdbcUtil.closeResource(statement);
            JdbcUtil.closeResource(connection);
        }
        return studentList;
    }

    /**
     * 根据姓名模糊查找学生并进行升序排列，并分页
     * @param stuName 学生姓名
     * @param curPage 当前页数
     * @param pageSize 每页显示的数据
     * @return 学生集合
     */
    @Override
    public List<Student> findByUserNameLikeOrderLimit(String stuName, int curPage, int pageSize) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student WHERE sname LIKE ? ORDER BY sname LIMIT ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, "%" + stuName + "%");
            preparedStatement.setObject(2, curPage - 1);
            preparedStatement.setObject(3, pageSize);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStuNo(rs.getString("sno"));
                student.setStuName(rs.getString("sname"));
                student.setStuSex(rs.getString("ssex"));
                student.setStuAge(rs.getInt("sage"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(rs);
            JdbcUtil.closeResource(preparedStatement);
            JdbcUtil.closeResource(connection);
        }
        return studentList;
    }
}
