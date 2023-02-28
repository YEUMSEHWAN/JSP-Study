<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="base.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=DynaPuff:wght@700&family=Gowun+Dodum&display=swap" rel="stylesheet">
<link href="css/wishList.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/MyPlan.js"></script>
</head>
<body>
	<div id="wishList_container">
		<div id="firstWord_id">${id_first }</div>
		<div id="nickname">${nick }</div>
		<div id="profile"><a href="cityPlan.do?cmd=modifyForm">프로필 수정</a></div>
		<div id="myPlan_wishList_wrap">
			<div id="myPlan" onclick="myPlanClick()">내 일정</div>
			<div id="wishList" onclick="wishListClick()">위시리스트</div>
		</div>
	</div>
	<c:if test="${arraySize < 1 }">
		<div id="wishList_makePlan"><a href="cityPlan.do?cmd=myPlanClick">저장된 일정이 없습니다! 만들러 가버려잇</a></div>
	</c:if>
	<c:forEach var="result" items="${result }" varStatus="status">
	<div class="mP"> <!-- 일정이 있으면 나오게 하기 없으면 일정 만들기 뜨게하기 -->
		<h2>${nick }님의 ${status.count}번째 일정</h2>
		<div class="flex_wrap">
			<div class="mP_wrap">
				<div class="mP_wrap_1"><a href="cityPlan.do?cmd=necessity" style="color:#999;" target="_blank">여행 준비물 확인</a>${result.getSave_city_kor() }</div>
				<div class="update_wrap">
					<div><a href="myPlan.do?cmd=planInsert&idCheck=${result.getSave_city_idCheck() }">수정</a></div>
					<div><a href="myPlan.do?cmd=deletePlan&idCheck=${result.getSave_city_idCheck() }">삭제</a></div>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
	<div class="wL">
		<h2>${nick }님의 위시리스트</h2>
		<c:forEach var="cityWishList" items="${cityWishList }">
		<c:set var="cityWishList.getCityList()" value="${cityWishList.getCityList() }" />
			<div class="wL_wrap">
				<div class="wL_wrap_sub">
					<img src="img/${cityWishList.getCityList() }.jpg">
				</div>
				<div class="wL_text" align="center" onclick="infoGo('${cityWishList.getCityList() }')">${cityWishList.getCityList() } 가이드북 보기</div>
			</div>
		</c:forEach>
	</div>
<script type="text/javascript" src="js/wishList.js"></script>
</body>
</html>