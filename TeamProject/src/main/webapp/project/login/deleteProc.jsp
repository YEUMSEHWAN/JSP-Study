<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.login.*"%>
<jsp:useBean id="dao" class="com.login.UserDAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<%
String userID = (String)session.getAttribute("loginID");
String userPassword = request.getParameter("userPassword");

int check = dao.deleteMember(userID, userPassword);
if(check ==1){
	session.invalidate();

%>
<meta http-equiv = "Refresh" content = "3;url=login.jsp">
<body>
<div align = "center">
<font size = "5" face = "궁서체">
회원님의 정보가 전부 삭제되었습니다.<br><br>
3초후에 login Page로 이동합니다.
</font>
</div>
<% }else{ %>
<script type="text/javascript">
alert("비밀번호가 일치하지 않습니다.");
history.go(-1);
</script>
<%} %>
</body>
</html>