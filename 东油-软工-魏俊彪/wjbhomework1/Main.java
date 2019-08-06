package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        changeOrder(1,3);
    }
    public static void changeOrder(int sid1 ,int num){
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                connection.setAutoCommit(false);
                String sql = "insert into forder values(null, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,sid1);
                preparedStatement.setInt(2,num);

                preparedStatement.executeUpdate();


                String sql1 = "update good set fnum = fnum-? where fid=?";
                preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setInt(1,num);
                preparedStatement.setInt(2,sid1);

                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JdbcUtil.closeResource(preparedStatement);
                JdbcUtil.closeResource(connection);
            }
        }


}
