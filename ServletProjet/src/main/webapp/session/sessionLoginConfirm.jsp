<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="color.jsp"%>
<%

try {
	

	if (session.getAttribute("memid") == null) {
		
	response.sendRedirect("sessionMemberLogIn.jsp");
	}
} catch (Exception e) {

}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 사용한 회원 인증</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcololor="<%=bodyback_c%>">

	<form action="sessionLogOut.jsp" method="post">
		<table width="300" border="1" align="center">

			<tr>
				<td align="center" bgcolor="<%=value_c%>"><b><%=session.getAttribute("memid")%></b>님이 로그인
					하셨습니다.</td>
			</tr>

			<tr>
				<td align="center" bgcolor="<%=value_c%>"><input type="submit"
					value="로그아웃"></td>
			</tr>

		</table>
	</form>
</body>
</html>