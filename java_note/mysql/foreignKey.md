# Foreign key

## 1. syntax

```sql
create table `t_player`(
	`id` int not null AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(45) not NULL,
	`tid` int not null,
	 CONSTRAINT FK_TeamPlayer FOREIGN KEY (tid) REFERENCES t_team(id)
)
```
