create table p_board(
num number(7) not null,
writer varchar2(15) not null,
subject varchar2(50) not null,
readcount number(5) not null,
regdate timestamp(6) default sysdate not null,
content varchar2(4000)
);
alter table p_board modify(num number(7) primary key);

create table p_freeboard(
num number(7) not null,
writer varchar2(15) not null,
subject varchar2(50) not null,
readcount number(5) not null,
regdate timestamp(6) default sysdate not null,
content varchar2(4000)
);
alter table p_freeboard modify(num number(7) primary key);

create table commentDB(
commentID number(7),
num number(7),
userID varchar2(20),
userName varchar2(30),
commentDate varchar2(50),
commentText varchar2(4000),
commentAvailable number(7),
imageUID varchar2(50) default ''
);
alter table commentDB add primary key (commentID, num);
alter table commentDB add constraint commentID_fk foreign key(num) references p_board(num) on delete cascade;


create table freecommentDB(
commentID number(7),
num number(7),
userID varchar2(20),
userName varchar2(30),
commentDate varchar2(50),
commentText varchar2(4000),
commentAvailable number(7),
imageUID varchar2(50) default ''
);
alter table freecommentDB add primary key (commentID, num);
alter table freecommentDB add constraint commentID_fk_ foreign key(num) references p_freeboard(num) on delete cascade;


create table Evaluation(
num int,
userID VARCHAR2(20),
gechu int,
bichu int
);
alter table evaluation add primary key (num, userID);
alter table evaluation add constraint evluation_fk foreign key (num) references p_board(num) on delete cascade;


create table freeEvaluation(
num int,
userID VARCHAR2(20),
gechu int,
bichu int
);
alter table freeevaluation add primary key (num, userID);
alter table freeevaluation add constraint evluation_fk_ foreign key (num) references p_freeboard(num) on delete cascade;

CREATE SEQUENCE boardone_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 1000 NOCYCLE;