<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<c:if test="${check == 1 }">
<meta http-equiv="Refresh" content="0;url=/ServletProjet/board/list.bdo">

</c:if>
<c:if test="${check == 0 }">
비밀번호가 틀렸습니다.<br>
<a href="javascript:history.go(-1)">[비밀번호 다시 입력하기]</a>
</c:if>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	

	
</body>
</html>