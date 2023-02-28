create table member ( 
id varchar2 (35) not null,
pass varchar2 (50) not null,
nick varchar2 (35) not null,
email varchar2 (50)not null,
constraint member_pk primary key(id)
);

select * from member;

select * from user1;

insert into member values(test, 1234, ¸¶½ÂÈ¯, tmdg3801@naver.com);

create table user1 (
userid varchar2(30) not null,
userpassword varchar2(65) not null,
useremail varchar2(50) not null,
useremailhash varchar2(65) not null,
useremailchecked char(1) constraint user1_ck check(useremailchecked in ('0','1')),
constraint user1_pk primary key(userid)
);

