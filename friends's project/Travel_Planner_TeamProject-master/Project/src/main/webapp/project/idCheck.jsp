<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/memberstyle.css">
<script type="text/javascript" src = "js/memberscript.js"></script>
<title></title>
</head>
<body>

<div align = "center">
	<b>${id}</b>

<c:if test="${check eq true }">
는 이미 존재하는 ID입니다.<br>
</c:if>

<c:if test="${check ne true }">
는 사용가능한 ID입니다.<br>
</c:if>
	<a href = "#" onclick="javascript:self.close()">닫기</a>
</div>




</body>
</html>