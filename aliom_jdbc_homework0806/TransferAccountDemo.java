import java.sql.*;

public class TransferAccountDemo {
    public static void main(String[] args) {
        // 1号用户转给2号用户100元钱
        transferAccount(1,2,100);
    }
    /**
     * 转账函数
     * @param srcUserId 发钱人
     * @param dstUserId 收钱人
     * @param money 钱数
     */
    public static void transferAccount(int srcUserId, int dstUserId, int money) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);

            // 转钱的用户
            String sql1 = "UPDATE account SET balance=balance-? WHERE uid=?";
            ps = conn.prepareStatement(sql1);
            ps.setObject(1, money);
            ps.setObject(2, srcUserId);
            ps.executeUpdate();

            // 收钱的用户
            String sql2 = "UPDATE account SET balance=balance+? WHERE uid=?";
            ps = conn.prepareStatement(sql2);
            ps.setObject(1, money);
            ps.setObject(2, dstUserId);
            ps.executeUpdate();

            // 提交事务
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(ps);
            JdbcUtil.closeResource(conn);
        }
    }
}
