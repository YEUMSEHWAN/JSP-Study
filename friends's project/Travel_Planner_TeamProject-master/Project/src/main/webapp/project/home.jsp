<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loginID" value="${sessionScope.loginID}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/home.css">
<link rel ="shortcut icon" href="#">
<link href="https://fonts.googleapis.com/css2?family=DynaPuff:wght@700&family=Gowun+Dodum&display=swap" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script> <!--jquery사용 -->
<script type="text/javascript" src="js/CityInfo.js"></script>
<script src="https://kit.fontawesome.com/e14a2b80fa.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container" >
    <div class="header">
   	<script>
    	const header = document.querySelectorAll('.header');
    	function scrollFunc() {
        	if(pageYOffset >= 90) {
            	header[0].classList.add('on');
        	}else {
            	header[0].classList.remove('on');
        	}
    	}
    	window.addEventListener('scroll',scrollFunc);
    </script>
        <div class="logo">
        	<a href="cityPlan.do?cmd=cityInfoView"><img src="images/logo.png"></a>
        </div>
        <div class="menu_wrap">
            <ul class="dep1">
                <li>
                    <span><a href="cityPlan.do?cmd=try1">추천플래너</a></span>
                </li>
                <li>
                    <span>게시판</span>
                    <ul class="dep2">
                        <li><a href="cityPlan.do?cmd=boardList">공지사항</a></li>
                        <li><a href="cityPlan.do?cmd=freeBoardList">자유게시판</a></li>
                        <li><a href="">동행게시판</a></li>
                        <li><a href="">루트소개</a></li>
                        <li><a href="">루트질문</a></li>
                        <li><a href="">나눔게시판</a></li>
                        <li>&nbsp;</li>
                    </ul>
                </li>
                <li>
                    <span>내일정</span>
                    <ul class="dep2">
                    <c:if test="${loginID eq null}">
                    	<li><a href="cityPlan.do?cmd=login">일정만들기</a></li>
                   	</c:if>
                    <c:if test="${loginID ne null}">
                    	<li><a href="cityPlan.do?cmd=myPlanClick" target="_blank">일정만들기</a></li>
                   	</c:if>
                    	<li><a href="cityPlan.do?cmd=necessity">준비물챙기기</a></li>
                    	<li>&nbsp;</li>
                    </ul>
                </li>
            </ul>
        </div>
        <c:if test="${loginID eq null}">
        	<div class="nav">
            	<div class="login_Btn"><a href="cityPlan.do?cmd=login">로그인</a></div>
        	</div>
        </c:if>
        <c:if test="${loginID ne null}">
        	<div class="nav">
            	<div class="login_Btn"><a href="cityPlan.do?cmd=wishList">마이페이지</a></div>
            	<div class="login_Btn"><a href="cityPlan.do?cmd=logout">로그아웃</a></div>
        	</div>
        </c:if>
    </div>
       
    <div class="mediafilm">
        <video src="images/cityVideo.mp4" width="100%" height="500px" autoplay loop></video>
    </div>
        
    <div class="button_container">
        <button class="startBtn" onclick="fnMove()"><span>시작하기!</span></button>
    </div>
</div>
</body>
</html>