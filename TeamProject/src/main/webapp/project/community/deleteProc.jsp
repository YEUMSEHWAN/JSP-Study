<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.board.BoardDAO"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="com.login.UserVO"%>
<%@ page import="com.login.UserDAO"%>
<jsp:useBean id="dao" class="com.login.UserDAO" />
<jsp:useBean id="vo" class="com.login.UserVO"/>
<% 
String loginID = (String)session.getAttribute("loginID");
vo.setuserID(loginID);
dao.updateMember(vo);
%>

<%
request.setCharacterEncoding("utf-8");
%>

<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
String pass = request.getParameter("pass");
BoardDAO dbPro = BoardDAO.getInstance();

int check = dbPro.deleteArticle(num, pass);

if (check == 1) {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<meta http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%=pageNum%>">
</head>
<body>
	<%
	} else {
	%>
	<script type="text/javascript">
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);//이전페이지로 가는건데 or history.back();
	</script>
	<%
	}
	%>

</body>
</html>