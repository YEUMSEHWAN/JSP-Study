<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/memberstyle.css">
<script type="text/javascript" src = "js/memberscript.js"></script>
</head>
<body>
<div align = "center">
<b> ${nick }</b>

<c:if test="${check eq true }">
는 이미 존재하는 닉네임입니다.<br>
</c:if>

<c:if test="${check ne true }">
는 사용가능한 닉네임입니다.<br>
</c:if>
	<a href ="#" onclick = "javascript:self.close()">닫기</a>

</div>



</body>
</html>