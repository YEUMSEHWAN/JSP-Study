<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.login.UserVO"%>
<%@ page import="com.login.UserDAO"%>
<jsp:useBean id="dao" class="com.login.UserDAO"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<%
String loginID = (String) session.getAttribute("loginID");
UserVO vo = dao.getMember(loginID);
%>


<body>
	<form action="regForm" method="post" action="modifyProc.jsp">
		<table border="1">
			<tr>
				<td colspan="2" align="center">회원 정보 수정</td>
			</tr>

			<tr>
				<td align="right">아이디</td>
				<td><%=vo.getuserID()%></td>
			</tr>

			<tr>
				<td align="right">비밀번호</td>
				<td><input type="password" name="pass"
					value="<%=vo.getuserPassword()%>"></td>
			</tr>
			<tr>
				<td align="right">비밀번호 확인</td>
				<td><input type="password" name="repass"
					value="<%=vo.getuserPassword()%>"></td>
			</tr>
			<tr>
				<td align="right">이메일</td>
				<td><input type = "userEmail" name = "email" value = "<%=vo.getuserEmail()%>"></td>
			</tr>

			<tr>
				<td align="rignt">이름</td>
				<td><input type = "userName" name = "name" value = "<%=vo.getuserName()%>"></td>
			</tr>
			<tr>
				<td align="right">Alchol 선호도</td>
				<td><input type = "userAlchol" name = "alchol" value = "<%=vo.getuserAlchol()%>"><%=vo.getuserAlchol()%></td>

			</tr>
			<tr>
			<td colspan = "2" align = "center">
			<input type = "button" value = "수정" onclick = "updateCheck()">%nbsp;%nbsp;
			<input type = "button" value = "취소" onclick = "javascript:window.location = 'login.jsp'">
			</td>
			</tr>

		</table>


	</form>





</body>
</html>