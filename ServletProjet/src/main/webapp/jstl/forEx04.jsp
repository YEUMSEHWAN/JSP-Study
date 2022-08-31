<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import java.util.* %>
    
<%
HashMap<String, Object> mapDate = new HashMap<String, Object>();

Date today =new Date();
mapDate.put("name","홍길동");
mapDate.put("today", java);


%>
    <c:set var = "intArray" value = "<%=new int[]{1,2,3,4} %>"/>
    <c:set var = "map" value = "<%=new int[]{1,2,3,4} %>"/>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h4>1부터 100까지의 홀수의 합계</h4>
<c:set var = "sum" value = "0"/>

<c:forEach var = "i" begin = "1" end = "100" step = "2">
<c:set var = "sum" value = "${sum+i }"/>

</c:forEach>


</body>
</html>