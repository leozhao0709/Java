# DDL

## 1. create table

```sql
create table emp(
    id int,
    name varchar(100),
    sex char(6),
    birthday date,
    salary float(10,2) -- 8位整数, 2位小数
);
```

## 2. some useful ddl

-   `SHOW TABLES;` 
-   `DESC table;` 查看表的字段信息
-   `ALTER TABLE employee ADD address varchar(100);` 在上面员工表的基本上增加一个address列
-   `ALTER TABLE employee MODIFY job varchar(30);` 修改job列，使其长度为30。
-   `ALTER TABLE employee DROP address;` 删除address列,一次只能删一列。
-   `RENAME TABLE employee TO user;` 表名改为user。
-   `SHOW CREATE TABLE user;` 查看表格的创建细节
-   `ALTER TABLE user CHARACTER SET gbk;` 修改表的字符集为gbk
-   `ALTER TABLE user CHANGE name username varchar(20);` 列名name修改为username
-   `DROP TABLE user ;` 删除表