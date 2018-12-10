# DML

## 1. insert, update and delete

```sql
create table emp(
    id int,
    name varchar(100),
    sex char(6),
    birthday date,
    salary float(10,2)
);

INSERT INTO emp (id,name,sex,birthday,salary) VALUES (1,'andy','male','1995-05-15',10000);

INSERT INTO emp (id,name,sex,birthday,salary) VALUES (4,'james','male','1985-08-10',50000),
(5,'marry','female','1987-06-15',30000),
(6,'carter','male','1995-05-15',10000); -- 批量添加

UPDATE emp SET salary=8000 where name='james';

DELETE from emp where name='lucy';

DELETE from emp; --删除表中数据
TRUNCATE TABLE emp; --彻底删除表中数据
```

## 2. select

```sql
select empno,ename,sal * 12 as yearsal from emp;

select empno,ename,sal from emp where sal >= 1600 and sal <= 3000；
select empno,ename,sal from emp where sal between 1600 and 3000;  -- btween is same with >= and <=

select empno,ename,comm from emp where comm is not null; -- is null / is not null

select ename,sal from emp where sal not in (1600,3000); -- in

select ename from emp where ename like '%O%'; -- like
select ename from emp where ename like '_A%'; -- _只占一个占位符, %可以不占或占一个或占多个占位符

select ename,job,sal from emp where job = 'MANAGER' order by sal; -- order by
select job,max(sal) as maxsal from emp where job <> 'MANAGER' group by job; -- groip by
select job,avg(sal) from emp group by job having avg(sal) > 2000; -- having
```

Note:

-   Above is some easy select statement.
-   when you are using `group by filed`, then you can **only** select `filed` and aggregate function part, like `select job,avg(sal) from emp group by job having avg(sal) > 2000;` you can **only** select job, avg(sal)/sum(sal).
-   `when` should be used before `group by` and `having` should be used after `group by`.
-   Here's a template for complex select:
    ```sql
    select 
        xxxx
    from
        xxxx
    where 
        xxxx
    group by
        xxxx
    having
        xxxx
    order by
        xxxx
    limit
        xxxx
    ```

## 3. join

```sql
select d.dname,e.ename from emp e,dept d where e.deptno = d.deptno; -- SQL92. this is same with the following but not recommend

select d.dname,e.ename from emp e join dept d on e.deptno = d.deptno; -- SQL99 (recommend) this is a inner join

select a.ename empname ,b.ename leadername from emp a join emp b on a.mgr = b.empno; -- 自连接
```

Note:

-   for `inner join`, we don't need to write `inner` keyword.


