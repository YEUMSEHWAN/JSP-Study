<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/index.css">
<link href="https://fonts.googleapis.com/css2?family=DynaPuff:wght@700&family=Gowun+Dodum&display=swap" rel="stylesheet">
<title>DOZO</title>
</head>
<body>
    <div class="container" >
        <div class="header">
            <a href="cityPlan.do?cmd=cityInfoView" id="logo"><img src="images/logo.png"></a>
            <div class="nav">
                <ul> 
                    <li><a href="cityPlan.do?cmd=login">Login</a></li>
                    <li><a href="cityPlan.do?cmd=regForm">Join</a></li>
                </ul>
            </div>
        </div>
        
        <div class="rectangle">
            <div class="minibox">
            	<img src="images/한국.jpg" alt="korea" id="city1" class="photo">
            	<img src="images/일본.jpg" alt="japan" id="city2" class="photo">
            	<img src="images/중국.jpg" alt="china" id="city3" class="photo">
            	<img src="images/대만.jpg" alt="taiwan" id="city4" class="photo">
            	<img src="images/영국.jpg" alt="england" id="city8" class="photo">
            	<img src="images/프랑스.jpg" alt="france"id="city7" class="photo">
            	<img src="images/독일.jpg" alt="germany" id="city6" class="photo">
            	<img src="images/스페인.jpg" alt="spain" id="city5" class="photo">
            	<img src="images/la.jpg" alt="lacity" id="city11" class="photo">
            	<img src="images/뉴욕.jpg" alt="newyork" id="city12" class="photo">
            	<img src="images/캐나다.jpg" alt="canada" id="city10" class="photo">
            	<img src="images/괌.jpg" alt="guam" id="city9" class="photo">
            </div>
            <div class="small1"><div class="small1-1"><a href="cityPlay.do?cmd=cityInfoView" class="font">시작</a></div></div>
            <div class="small2"><div class="small2-1"><a class="font">해인</a></div></div>
            <div class="small3"><div class="small3-1"><a class="font">승환</a></div></div>
            <div class="small4"><div class="small4-1"><a class="font">재연</a></div></div>
            <div class="small5"><div class="small5-1"><a class="font">찬규</a></div></div>
            <div class="small6"><div class="small6-1"><a class="font">아시아</a></div></div>
            <div class="small7" onclick="ViewLayer('city1');"><div class="small7-1"><a class="font">한국</a></div></div>
            <div class="small8" onclick="ViewLayer('city2');"><div class="small8-1"><a class="font">일본</a></div></div>
            <div class="small9" onclick="ViewLayer('city3');"><div class="small9-1"><a class="font">중국</a></div></div>
            <div class="small10" onclick="ViewLayer('city4');"><div class="small10-1"><a class="font">대만</a></div></div>
            <div class="small11"><div class="small11-1"><a class="font">유럽</a></div></div>
            <div class="small12"><div class="small12-1"><a class="font">미대륙</a></div></div>
            <div class="small13" onclick="ViewLayer('city5');"><div class="small13-1"><a class="font">스페인</a></div></div>
            <div class="small14" onclick="ViewLayer('city6');"><div class="small14-1"><a class="font">독일</a></div></div>
            <div class="small15" onclick="ViewLayer('city7');"><div class="small15-1"><a class="font">프랑스</a></div></div>
            <div class="small16" onclick="ViewLayer('city8');"><div class="small16-1"><a class="font">영국</a></div></div>
            <div class="small17" onclick="ViewLayer('city9');"><div class="small17-1"><a class="font">괌</a></div></div>
            <div class="small18" onclick="ViewLayer('city10');"><div class="small18-1"><a class="font">캐나다</a></div></div>
            <div class="small19" onclick="ViewLayer('city11');"><div class="small19-1"><a class="font">LA</a></div></div>
            <div class="small20" onclick="ViewLayer('city12');"><div class="small20-1"><a class="font">뉴욕</a></div></div>
        	</div>
        </div>
    <script type="text/javascript" src="js/index.js"></script>
</body>
</html>