# JDBC

## 1. connect

```java
public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/jdbcLearn?useSSL=false&serverTimezone=America/Los_Angeles";
    String username = System.getenv("DB_USER");
    String password = System.getenv("DB_PASS");
    Connection connection = DriverManager.getConnection(url, username, password);

    PreparedStatement pst = connection.prepareStatement("insert into category(cid, cname) values(?, ?)");
    pst.setObject(1, "c008");
    pst.setObject(2, "逛街");

    pst.execute();

    pst = connection.prepareStatement("select * from category where cname=?");
    pst.setObject(1, "旅游");

    ResultSet rs = pst.executeQuery();

    while (rs.next()) {
        System.out.println(rs.getString("id") + "\t" + rs.getString("cid") + "\t" + rs.getString("cname"));
    }

    rs.close();
    pst.close();
    connection.close();
}
```
