<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    String memberid = (String)session.getAttribute("MEMBERID");
    String name = (String)session.getAttribute("NAME");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 불러오기</title>
</head>
<body>
세션에 저장되어있는 정보를 불러왔습니다.<br><br>
MEMBER : <%=memberid %><br><br>
NAME : <%=name %><br><br>
</body>
</html>