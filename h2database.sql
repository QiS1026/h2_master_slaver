# 创建表
create table person (
id int primary key,
name varchar(255)
);

# 插入数据
insert into person values(1, '张三');

# 查询数据
select * from person where id=1 order by id;

# 更新数据
update person set name='李四' where id=1;

# 删除数据
delete from person where id=1;

# 删除表
drop table if exists person;