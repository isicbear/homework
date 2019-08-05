package com.train.day14.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：孙鹏
 * @date ：Created in 2019/8/5 0005 15:45
 * @description：
 * @version:
 */
public class HeroOperator implements HeroOperatable {

    @Test
    public void updateTest() {
        Hero hero = new Hero();
        hero.setId(4);
        hero.setSno("17");
        hero.setSname("huahuahua");
        hero.setSex("F");
        hero.setSage(133);
        updateHeroById(hero);
    }

    @Test
    public void deleteTest() {
        deleteHeroById(5);
    }

    @Test
    public void selectTest() {
        List<Hero> heroList = findAllHero();
        heroList.forEach(System.out::println);
    }

    @Test
    public void insertTest() {
        Hero hero = new Hero();
        hero.setSno("17");
        hero.setSname("huahuahua");
        hero.setSex("F");
        hero.setSage(133);
        insertHeroById(hero);
    }

    @Override
    public List<Hero> findAllHero() {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Hero> heroList = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from hero";
            heroList = new ArrayList<>();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Hero hero = new Hero();
                hero.setId(rs.getInt("id"));
                hero.setSno(rs.getString("sno"));
                hero.setSname(rs.getString("sname"));
                hero.setSex(rs.getString("ssex"));
                hero.setSage(rs.getInt("sage"));
                heroList.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeRes(rs);
            JdbcUtil.closeRes(statement);
            JdbcUtil.closeRes(connection);
        }
        return heroList;
    }

    @Override
    public int insertHeroById(Hero hero) {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        int affectedRows = 0;
        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("insert into hero values(null,");
            stringBuffer.append("'");
            stringBuffer.append(hero.getSno());
            stringBuffer.append("','");
            stringBuffer.append(hero.getSname());
            stringBuffer.append("','");
            stringBuffer.append(hero.getSex());
            stringBuffer.append("',");
            stringBuffer.append(hero.getSage());
            stringBuffer.append(")");
            String sql = stringBuffer.toString();
            System.out.println(sql);
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeRes(statement);
            JdbcUtil.closeRes(connection);
        }
        return affectedRows;
    }

    @Override
    public int updateHeroById(Hero hero) {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        int affectedRows = 0;
        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update hero set sno='");//10 where id=6
            stringBuffer.append(hero.getSno());
            stringBuffer.append("',sname='");
            stringBuffer.append(hero.getSname());
            stringBuffer.append("',ssex='");
            stringBuffer.append(hero.getSex());
            stringBuffer.append("',sage=");
            stringBuffer.append(hero.getSage());
            stringBuffer.append(" where id=");
            stringBuffer.append(hero.getId());
            String sql = stringBuffer.toString();
            System.out.println(sql);
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeRes(statement);
            JdbcUtil.closeRes(connection);
        }
        return affectedRows;
    }

    @Override
    public int deleteHeroById(int id) {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        int affectedRows = 0;
        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("delete from hero where id=");
            stringBuffer.append(id);
            String sql = stringBuffer.toString();
            System.out.println(sql);
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeRes(statement);
            JdbcUtil.closeRes(connection);
        }
        return affectedRows;
    }
}
