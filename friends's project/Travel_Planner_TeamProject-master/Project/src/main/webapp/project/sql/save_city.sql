create table saveCity(
save_city_id varchar2(30) not null,
save_city_idCheck varchar2(1000) not null,
save_city_eng varchar2(30),
save_city_kor varchar2(30),
save_schedule varchar2(30)
);
delete from saveCity;

select * from saveCity;


create table wishList (
id varchar2 (50) not null,
cityList varchar2 (60) not null
);

select * from wishList;
drop table wishList;