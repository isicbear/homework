package day19;
import java.util.List;
public class Main {
    private static StudentOperatable so = new StudentOperator();
    public static void main(String[] args) {
        findByUserNameLike();
        findOrderByUserName();
        findByUserNameLikeOrderLimit();
    }

    public static void findByUserNameLike() {
        List<Student> studentList = so.findByUserNameLike("李");
        studentList.forEach(System.out::println);
    }

    public static void findOrderByUserName() {
        List<Student> studentList = so.findOrderByUserName();
        studentList.forEach(System.out::println);
    }
    public static void findByUserNameLikeOrderLimit() {
        List<Student> studentList = so.findByUserNameLikeOrderLimit("李", 2, 2);
        studentList.forEach(System.out::println);
    }
}
