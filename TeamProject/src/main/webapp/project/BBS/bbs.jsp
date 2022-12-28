<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width = device-width" , initial-scale="1">
<link rel="stylesheet" href="../boardcss/bootstrap.css">
<title>게시판</title>
</head>
<body>
	<%
	String loginID = null;
	if(session.getAttribute("loginID") != null){
		loginID = (String) session.getAttribute("loginID");
	}
%>
	<nav class="navbar navbar-default">
		<div class="navbar-geader">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				area-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">게시판</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="../login/mainPage.jsp">메인</a></li>
				<li class="active"><a href="bbs.jsp">게시판</a></li>
			</ul>
			<%
			if(loginID == null){
		%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					area-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="login.jsp">회원가입</a></li>
					</ul></li>
			</ul>
			<%
			}else{
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
			}
			%>
		</div>
	</nav>
		<div class = "container">
			<div class = "row">
			<table class = "table table-striped" style = "text-align:center; border:1px solid #dddddd">
			<thead>
			<tr>
				<th style = "background-color:#eeeeee; text-align : center;">번호</th>
				<th style = "background-color:#eeeeee; text-align : center;">제목</th>
				<th style = "background-color:#eeeeee; text-align : center;">작성자</th>
				<th style = "background-color:#eeeeee; text-align : center;">작성일</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td>1</td>
			<td>안녕하세요</td>
			<td>작성자</td>
			<td>2022-11-11</td>
			</tr>
			</tbody>
			</table>
			<a href = "write.jsp" class = "btn btn-primary pull-right">글쓰기</a>
			</div>
		</div>
	<script src = "http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src = "js/bootstrap.js"></script>
</body>
</html>