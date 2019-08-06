package day19;

import java.util.List;

public interface StudentOperatable {
    /**
     * 根据姓名模糊查找学生
     * @param stuName 姓名
     * @return 学生集合
     */
    List<Student> findByUserNameLike(String stuName);

    /**
     * 查询所有学生并根据学生姓名降序排列
     * @return 学生集合
     */
    List<Student> findOrderByUserName();

    /**
     * 根据姓名模糊查找学生并进行升序排列，并分页
     * @param stuName 学生姓名
     * @param curPage 当前页数
     * @param pageSize 每页显示的数据
     * @return 学生集合
     */
    List<Student> findByUserNameLikeOrderLimit(String stuName, int curPage, int pageSize);
}
