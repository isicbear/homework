package day18;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroOperator implements HeroOperatable{
    @Override
    public List<Hero> findAllHero() {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Hero> heroList = new ArrayList<>();
        try {
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
                hero.setAge(sage);
                heroList.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public int updateHeroById(Hero hero) {
        return 0;
    }

    @Override
    public int insertHero(Hero hero) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("insert into hero values(null,");
            stringBuffer.append("'");
            stringBuffer.append(hero.getSno());
            stringBuffer.append("','");
            stringBuffer.append(hero.getSname());
            stringBuffer.append("','");
            stringBuffer.append(hero.getSsex());
            stringBuffer.append("',");
            stringBuffer.append(hero.getAge());
            stringBuffer.append(")");

            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return affectedRows;



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }

    @Override
    public int deleteHeroById(int id) {

        return 0;
    }
}
