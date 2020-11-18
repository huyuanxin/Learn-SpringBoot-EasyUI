# User表
DROP TABLE IF EXISTS `user`;
create table User
(
    uid      bigint auto_increment primary key,
    username varchar(50) not null,
    password varchar(50) not null
);

# 计数表
DROP TABLE IF EXISTS `tablecounter`;
create table tablecounter
(
    tid     bigint auto_increment primary key,
    name    varchar(255)     not null,
    counter bigint default 0 not null
);

create unique index tablecounter_name_uindex
    on tablecounter (name);

insert into tablecounter(name, counter) VALUE ('user', 0);

# 计算User的触发器，插入
CREATE TRIGGER `counter`
    AFTER INSERT
    ON spring.user
    FOR EACH ROW
BEGIN
    UPDATE tablecounter SET tablecounter.counter=tablecounter.counter + 1 WHERE tablecounter.name = 'user';
END;

# 计算User的触发器,删除
CREATE TRIGGER `deletecounter`
    AFTER DELETE
    ON spring.user
    FOR EACH ROW
BEGIN
    UPDATE tablecounter SET tablecounter.counter=tablecounter.counter - 1 WHERE tablecounter.name = 'user';
END;

# 添加User数据
insert into spring.user(USERNAME, PASSWORD) value ('username', 'password');

insert into spring.user(username, password)
select username, password
from spring.user;

insert into spring.user(username, password)
select username, password
from spring.user;

insert into spring.user(username, password)
select username, password
from spring.user;

insert into spring.user(username, password)
select username, password
from spring.user;

insert into spring.user(username, password)
select username, password
from spring.user;

insert into spring.user(username, password)
select username, password
from spring.user;

insert into spring.user(username, password)
select username, password
from spring.user;

insert into spring.user(username, password)
select username, password
from spring.user;

