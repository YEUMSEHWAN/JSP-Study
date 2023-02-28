select *
select * from tab;

create table reco(
	num number(3),
	reccityname varchar2(45) PRIMARY KEY,
	continent varchar2(30)not null,
	mainlongitude varchar2(10) not null,
	mainlatitude varchar2(10) not null,
	pin1logitude varchar2(10) not null,
	pin1latitude varchar2(10) not null,
	pin2logitude varchar2(10) not null,
	pin2latitude varchar2(10) not null,
	pin3logitude varchar2(10) not null,
	pin3latitude varchar2(10) not null,
	pin4logitude varchar2(10) not null,
	pin4latitude varchar2(10) not null,
	pin5logitude varchar2(10) not null,
	pin5latitude varchar2(10) not null
	);
	select * from reco;
	-------------------------------------------------------
	
	drop table reco;
	
	create table reco(
	num number(3),
	reccityname varchar2(45) PRIMARY KEY,
	koreaname varchar2(45)not null,
	continent varchar2(30)not null,
	mainlongitude varchar2(20) not null,
	mainlatitude varchar2(20) not null,
	pin1longitude varchar2(20) not null,
	pin1latitude varchar2(20) not null,
	pin2longitude varchar2(20) not null,
	pin2latitude varchar2(20) not null,
	pin3longitude varchar2(20) not null,
	pin3latitude varchar2(20) not null,
	pin4longitude varchar2(20) not null,
	pin4latitude varchar2(20) not null,
	pin5longitude varchar2(20) not null,
	pin5latitude varchar2(20) not null,
	pin1explainname varchar2(45)not null,
	pin2explainname varchar2(45)not null,
	pin3explainname varchar2(45)not null,
	pin4explainname varchar2(45)not null,
	pin5explainname varchar2(45)not null,
	pin1explain varchar2(500)not null,
	pin2explain varchar2(500)not null,
	pin3explain varchar2(500)not null,
	pin4explain varchar2(500)not null,
	pin5explain varchar2(500)not null
	);
		select * from reco;
		delete from reco where reccityname='america-la';
		
		update reco set koreanname=(select koreaname from reco where koreaname='미');
		
insert into reco values(1,'japan-tokyo','일본-도쿄','ASIA','35.69762851732002','139.76252747648775','35.71511998200324','139.79663127499435','35.71093354091107','139.8107432776195','35.715696177591205','139.77334533159106','35.68545484272861','139.7101804082948','35.65917295449037','139.74526120087742','센소지','도쿄 스카이 트리','우에노 공원','신주쿠 교엔','도쿄타워','도쿄 내 가장 오래된 절. 오래된 노포도, 사람도 많은 듯하나 그 또한 여행의 묘미.','세계에서 가장 높은 전파탑, 도쿄에서 가장 트렌디한 볼거리와 즐길 거리가 모여 있는 명소','공원 숲속 아트 삼매경에 빠지고, 봄 벚꽃, 가을 낙엽으로 사계절이 아름다움을 즐기자.','도심이라고는 상상하기 어려울 정도의 규모를 자랑하며 잔디가 시원하게 펼쳐진 도심 속 오아시스','오랫동안 사람들의 가슴 속에 소박한 빛을 밝혀 준 영원한 도쿄의 심볼');
insert into reco values(2,'china-shanghai','중국-상하이','ASIA','31.23487394513658','121.49080093307111','31.24117811591429','121.49049112959041','31.236703753754696','121.47929080684018','31.240569228980906','121.49936902218539','31.235301373013986','121.50786937561857','31.228226037077174','121.49175063752365','와이탄','난징루','동방명주','상하이 금융센터','예원','‘번드(Bund)’라고 불리는 와이탄은 아편전쟁으로 강제 개항된 역사의 현장','인민광장 역 앞 신세계 백화점부터 와이탄까지 약 2km의 거리','1994년 완공 당시 총 높이가 468m의 TV 송신탑이었던 곳','2008년 완공된 건물로 높이 492m로 3개의 전망대를 가지고 있는 곳','400년 전 명나라 관료 반윤단이 아버지의 안락한 노후를 위해 20여 년에 걸쳐 만든 곳');
insert into reco values(3,'america-la','미국-로스앤젤레스','AMERICA','34.09080417791597','-118.36699373168943','34.13914657847251','-118.353249592423','34.11946411842695','-118.30065103052382','34.07477492031491','-118.23978667710868','34.07217146693637','-118.36031089141603','34.07863976609113','-118.47405252313742','유니버셜 스튜디오','그리피스 천문대','로스앤젤리스 다저스타디움','더 오리지널 파머스 마켓','게티센터','전 세계에서 유일하게 영화 촬영지 스튜디오와 테마파크의 놀이기구를 한 번에 즐길 수 있는 곳','LA 시내의 야경을 가까이서 한눈에 볼 수 있어 야경과 선셋이 아름답기로 유명한 천문대','1962년 4월 10일 오픈하여 LA 다져스의 홈구장으로 사용되고 있는 경기장','지금은 흔하게 열리는 파머스 마켓의 오리지널 격인 곳','미술 작품을 감상하고 가든에서 산책을 즐기는 건물 자체가 하나의 예술품인 종합예술센터');
insert into reco values(4,'england-london','영국-런던','EUROPE','51.513582316279546','-0.10412769408227149','51.508619575736894','-0.0758634982346568','51.50588346944242','-0.07548527495394589','51.51398766175485','-0.09831603502586231','51.50927590697472','-0.12838485960824644','51.49970205731015','-0.12727449986592348','런던타워','타워브릿지','런던 세인트 폴 대성당','런던 내셔널 갤러리','웨스트 민스터 사원','10여 개의 탑과 성벽으로 이뤄진 건축물. 왕의 거처, 요새, 왕족과 귀족들의 처형장 등으로 사용되었다.','개폐가 가능한 도개교로 양쪽에 고딕 양식의 거대한 탑이 자리한다.','런던을 대표하는 성당. 내부 관람 후 계단을 통해 올라가는 전망대도 유명하다.','런던을 대표하는 미술관으로 초기 르네상스부터 19세기 후반에 이르는 방대한 컬렉션을 소장하고 있다.','왕실의 역사적 행사들이 거행된 장소. 영국 왕과 위인들이 묻힌 곳이기도 하다.');
insert into reco values(5,'spain-barcelona','스페인-바르셀로나','EUROPE','41.39826157106125','2.1588830373100856','41.40449867987165','2.1740982730901584','41.415170332257766','2.153080703249116','41.392280520407425','2.1648710111755953','41.38254457281185','2.1715423497961357','41.38157188178499','2.1227339344521527','사그라다 파밀리아 성당','구엘공원','까사바트요','보케리아 시장','캄프누','바르셀로나의 대표적인 로마 가톨릭 성당으로 건축가 안토니 가우디가 설계했다.','가우디의 후원자였던 에우세비 구엘이 설계를 의뢰해 지은 공원','가우디의 걸작으로 꼽히는 건축물. 직물업자였던 바뜨요를 위해 지은 저택이다.','람블라스 거리에 접한 상설 시장, 산 호셉(St. Josep) 시장이라 불리기도 한다.','프로 축구팀 FC 바르셀로나 홈구장으로 세계에서 11번째로 큰 경기장이다.');