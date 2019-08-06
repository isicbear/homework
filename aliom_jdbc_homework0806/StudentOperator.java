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
    public List<Student> queryStudentByNameLike(String stuName) {
        List<Student> studentList = new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student WHERE sname LIKE ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "%" + stuName + "%");
            rs = ps.executeQuery();
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
            JdbcUtil.closeResource(ps);
            JdbcUtil.closeResource(conn);
        }
        return studentList;
    }

    /**
     * 查询所有学生并根据学生姓名降序排列
     * @return 学生集合
     */
    @Override
    public List<Student> queryStudentOrderByName() {
        List<Student> studentList = new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student ORDER BY sname DESC";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
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
            JdbcUtil.closeResource(stmt);
            JdbcUtil.closeResource(conn);
        }
        return studentList;
    }

    /**
     * 根据姓名模糊查找学生并进行升序排列，并进行分页展示
     * @param stuName 学生姓名
     * @param curPage 当前页数
     * @param pageSize 一页显示几条数据
     * @return 学生集合
     */
    @Override
    public List<Student> queryStudentByNameLikeOrderLimit(String stuName, int curPage, int pageSize) {
        List<Student> studentList = new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student WHERE sname LIKE ? ORDER BY sname LIMIT ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "%" + stuName + "%");
            ps.setObject(2, curPage - 1);
            ps.setObject(3, pageSize);
            rs = ps.executeQuery();
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
            JdbcUtil.closeResource(ps);
            JdbcUtil.closeResource(conn);
        }
        return studentList;
    }
}
