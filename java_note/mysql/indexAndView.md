# Index and view

## 1. index syntax

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