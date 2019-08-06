import java.util.List;

public interface StudentOperatable {
    /**
     * 根据姓名模糊查找学生
     * @param stuName 姓名
     * @return 学生
     */
    List<Student> queryStudentByNameLike(String stuName);

    /**
     * 查询所有学生并根据学生姓名降序排列
     * @return 学生
     */
    List<Student> queryStudentOrderByName();

    /**
     * 根据姓名模糊查找学生并进行升序排列，并进行分页展示
     * @param stuName 学生姓名
     * @param curPage 当前页数
     * @param pageSize 一页显示几条数据
     * @return 学生
     */
    List<Student> queryStudentByNameLikeOrderLimit(String stuName, int curPage, int pageSize);
}
