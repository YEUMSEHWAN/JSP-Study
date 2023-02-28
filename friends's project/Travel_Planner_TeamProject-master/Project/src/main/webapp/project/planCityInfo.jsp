<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메로옹</title>
<link rel="stylesheet" type="text/css" href="css/planCityInfo.css" />
<link href="https://fonts.googleapis.com/css2?family=DynaPuff:wght@700&display=swap" rel="stylesheet"> <!-- 폰트 -->
<script type="text/javascript">
	nameCheck = function() {
	const urlParams = new URL(location.href).searchParams;
	const cities = document.getElementsByClassName('container');
	const nameStr = urlParams.get('name');
	var number = ${arry.size()};
	<c:forEach var="arry" items="${arry}">
		var ${arry.getCitynameimg()} = "${arry.getCitynameimg()}";
		for(var i = 0; i < number; i++) {
			cities[i].style.display = "none";
		}
	</c:forEach>
		document.getElementById(nameStr).style.display = "block";
	}
</script>
</head>
<c:forEach var="arry" items="${arry}">
<body onload="nameCheck()">
	<div class="container" id="${arry.getCitynameimg()}">
		<div id="title">
			${arry.getCityinfoname()} - 가이드북
		</div>
		<div id="imgWrap">
			<img src="img/${arry.getCitynameimg()}.jpg">
		</div>
		<div id="mainWrap">
			<div id="forFlex">
				<h2>${arry.getCityinfoname()}</h2>
				<div id="cityInfoS"><b>${arry.getCityinfoS()}</b></div>
				<c:if test="${check eq true }">
					<div class="wishList_t"><a href="cityPlan.do?cmd=deleteWishList&name=${name }">☆</a></div>
				</c:if>
				<c:if test="${check eq false }">
					<div class="wishList_f"><a href="cityPlan.do?cmd=insertWishList&name=${name }">☆</a></div>
				</c:if>
			</div>
			<div id="infoWrap">
				<div id="peakMonth">
					<div id="peakMonth_title">성수기</div>
					<div id="peakMonth_value">${arry.getCitypeakseason()}</div>
				</div>
				<div id="days2">
					<div id="days2_title">1박 2일</div>
					<div class="days2_value">${arry.getCitytwodays1()}</div>
					<div class="days2_value">${arry.getCitytwodays2()}</div>
				</div>
				<div id="days3">
					<div id="days3_title">2박 3일</div>
					<div class="days3_value">${arry.getCitythreedays1()}</div>
					<div class="days3_value">${arry.getCitythreedays2()}</div>
					<div class="days3_value">${arry.getCitythreedays3()}</div>
				</div>
			</div>
			<div id="routeWrap">
				<div id="routeWrap_title"><span style="color: red;">Top 3</span> 추천 루트</div>
				<div class="routeWrap_value">${arry.getCityroute1()}</div>
				<div class="routeWrap_value">${arry.getCityroute2()}</div>
				<div class="routeWrap_value">${arry.getCityroute3()}</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/planCityInfo.js"></script>
	<script type="text/javascript" src="js/MyPlan.js"></script>
</c:forEach>
</body>
</html>