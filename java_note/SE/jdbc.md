# JDBC

## 1. connect

```java
public static void main(String[] args) throws SQLException, ClassNotFoundException {

    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/jdbcLearn?useSSL=false&serverTimezone=America/Los_Angeles";
    String username = System.getenv("DB_USER");
    String password = System.getenv("DB_PASS");
    Connection connection = DriverManager.getConnection(url, username, password);

    Statement statement = connection.createStatement();
    int rows = statement.executeUpdate("insert into category(cid, cname) values('c006', '室内')");
    System.out.println(rows);

    statement.close();
    connection.close();
}
```
