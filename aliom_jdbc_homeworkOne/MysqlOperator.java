import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlOperator {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        ResultSet rs = null;
        Statement statement = null;


        List<Hero> heroList = new ArrayList<>();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/train", "root", "123456");
            statement = connection.createStatement();
            String sql = "select * from hero";

            rs = statement.executeQuery(sql);


            while (rs.next()){
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(5);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);
            }

            // 操作hero表中的数据
            heroList.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            closeResource(rs);
            closeResource(statement);
            closeResource(connection);
        }

    }


    public static void closeResource(AutoCloseable autoCloseable) {
        if (null != autoCloseable) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
