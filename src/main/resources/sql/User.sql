# User表
drop database if exists `User`;
create table User
(
    uid      bigint auto_increment
        primary key,
    username varchar(50) not null,
    password varchar(50) not null
);

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
