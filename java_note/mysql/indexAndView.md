# Index and view

## 1. index

```sql
-- create
create index 索引名 on 表名(列名);
create index dept_dname_index on dept(dname);

-- show
show index from 表名;
show index from dept;

-- delete
drop index 索引名 on 表名;
drop index dept_dname_index on dept;
```

## 2. view syntax

```sql
-- create
create view 视图名称 as 查询语句;
create view e_info as select empno,ename,sal from emp;

-- use view
select * from e_info;

-- alter view
alter view 视图名称 as 查询语句
alter view e_info as select ename,job from emp;

-- delete view
drop view if exists 视图名称;
drop view if exists e_info;
```