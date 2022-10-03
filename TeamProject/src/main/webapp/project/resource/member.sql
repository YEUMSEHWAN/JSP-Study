use BBS;
select * from user;
select * from member;
create table member(
userID varchar(10) not null,
userPassword varchar(20) not null,
userEmail varchar(30),
userName varchar(10) not null,
userJumin varchar(10),
userAlchol varchar(10),
userGender varchar(4),
regist_day varchar(50),
primary key(userID)
) default CHARSET=utf8;

insert into member(userAlchol) values('varchar');
drop table member;
