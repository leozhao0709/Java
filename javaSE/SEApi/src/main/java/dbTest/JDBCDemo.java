package dbTest;

import java.sql.*;

class JDBCDemo {

    public static void main(String[] args) {


        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement("insert into category(cid, cname) values(?, ?)")) {

            pst.setObject(1, "c008");
            pst.setObject(2, "逛街");

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement("select * from category where cname=?")) {
            pst.setObject(1, "旅游");

            try (ResultSet rs = pst.executeQuery();) {
                while (rs.next()) {
                    System.out.println(rs.getString("id") + "\t" + rs.getString("cid") + "\t" + rs.getString("cname"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
