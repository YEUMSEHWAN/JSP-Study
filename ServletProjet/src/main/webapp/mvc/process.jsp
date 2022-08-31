<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터로 명령어를 전달</title>
</head>
<body>
처리효과 : 
<c:set var = "message" value = "${requestScope.message }"/>
<c:out value = "${ message}"/>
</body>
</html>