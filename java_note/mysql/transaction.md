# Transaction

## 1. show transaction settings

-   `show variables like '%commit%';`

## 2. commit and rollback

```sql
create table t_bank(
    account int(10) primary key,
    money int(15)
);

insert into t_bank values 
(1001,1000),
(1002,2000);

start transaction; -- manually open transaction

update t_bank set money=500 where account=1001;
update t_bank set money=2500 where account=1002;

select * from t_bank; -- in same session, you will see the result is changed. but it's actually not if you open another session.
rollback;

commit;
```

## 3. 事务的隔离级别

-   read uncommitted 读未提交

    事务A和事务B，事务A未提交的数据，事务B可以读取，这里读取到的数据叫做“脏数据”，该级别最低，一般只是理论上存在，数据库的默认隔离级别都高于该级别

-   read committed 读已提交

    事务A和事务B，事务A提交的数据，事务B才可读取到，换句话说：对方事务提交之后的数据，当前事务才可读取到，可以避免读取“脏数据”，但是改级别会有“不可重复读”的问题，事务B读取一条数据，当事务A修改这条数据并提交后，事务B再读取这条数据时，数据发生了变化，即事务B每次读取的数据有可能不一致，这种情况叫做“不可重复读”。

-   repeatable read 重复读

    MySQL默认的隔离级别是重复读，该级别可以达到“重复读”的效果，但是会有“幻读”的问题，即事务A读取数据，此时事务B修改了这条数据，但是事务A读取的还是之前的旧数据的内容，这样就出现了幻读。

-   serializable 串行化

    事务A和事务B，事务A在操作数据库表中数据的时候，事务B只能排队等待，这样保证了同一个时间点上只有一个事务操作数据库，该级别可以解决“幻读”的问题。但是这种级别一般很少使用，因为吞吐量太低，用户体验不好。

-   Use `select @@tx_isolation;` to check current isolation.