<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/memberstyle.css">
<link rel="stylesheet" type="text/css" href="css/findPwResult.css">
<script type="text/javascript" src = "js/memberscript.js"></script>
<title>여행 스케쥴링 플래너 - 도죠</title>
</head>
<body>
	<c:set var="pwd" value="${pwd }"/>
	<c:if test="${pwd ne 1}">
	    <div class = "container">
			<div class = "found-success">
				<h4>회원님의 비밀번호는 ${pwd}입니다.</h4>  
				<a href="cityPlan.do?cmd=login">로그인하러 가기</a>
	    	</div>
        </div>
	</c:if>

	<c:if test="${pwd eq 1}">
        <div class = "container">
      		<div class = "found-fail">
	    		<h4>등록된 정보가 없습니다.😥</h4>  
	    	</div>
 			<div class="signup-link">회원이 아니신가요?
 				<div>
	   				<a class="link" href="cityPlan.do?cmd=regForm">회원가입하기</a>	    
 		    		<input type="button" id="btnback" value="다시 찾기" onClick="history.back()"/>
 				</div>
	   		</div>
       	</div>
	</c:if>
</body>
</html>