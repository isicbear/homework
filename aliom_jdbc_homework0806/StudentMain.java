import java.util.List;

public class StudentMain {
    private static StudentOperatable so = new StudentOperator();

    public static void main(String[] args) {

        testQueryStudentByNameLike();// 根据姓名模糊查找学生

        testQueryStudentOrderByName(); // 查询所有学生并根据学生姓名降序排列

        testQueryStudentByNameLikeOrderLimit(); // 根据姓名模糊查找学生并进行升序排列，并分页获取第2页数据的操作（每页显示2条）
    }

    /**
     * 根据姓名模糊查找学生
     */
    public static void testQueryStudentByNameLike() {
        List<Student> studentList = so.queryStudentByNameLike("张");
        studentList.forEach(System.out::println);
    }

    /**
     * 查询所有学生并根据学生姓名降序排列
     */
    public static void testQueryStudentOrderByName() {
        List<Student> studentList = so.queryStudentOrderByName();
        studentList.forEach(System.out::println);
    }

    /**
     * 根据姓名模糊查找学生并进行升序排列，并分页获取第2页数据的操作（每页显示2条）
     */
    public static void testQueryStudentByNameLikeOrderLimit() {
        List<Student> studentList = so.queryStudentByNameLikeOrderLimit("张", 2, 2);
        studentList.forEach(System.out::println);
    }
}
