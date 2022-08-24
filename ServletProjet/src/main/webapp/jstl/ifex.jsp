<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:if test="${3>4 }">
이 내용은 화면에 나오지 않습니다.<br>
</c:if>

<c:if test="${param.type eq 'guest' }">
홈페이지 방문을 환영합니다.<br>
빠른 회원 가입을 하십시오.<br>
</c:if>




</body>
</html>