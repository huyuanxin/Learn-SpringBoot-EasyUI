# User表
create table user
(
    uid      bigint auto_increment
        primary key,
    username varchar(50) not null,
    password varchar(50) not null
);

