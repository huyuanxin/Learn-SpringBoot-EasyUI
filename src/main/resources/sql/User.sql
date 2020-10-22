# User表
create table user
(
    uid      int auto_increment
        primary key,
    username varchar(50) not null,
    password varchar(50) not null
);

