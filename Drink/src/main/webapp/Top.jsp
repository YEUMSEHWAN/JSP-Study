<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/1fd422b08e.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="Top.css">
    <title>Document</title>
</head>
<body>
<!-- 세션을 이용한 로그인 처리 -->
<%
	String id = (String)session.getAttribute("id");
	//로그인이 되어있지 않다면
	if(id==null){
		id="GUEST";
	}
%>
   <div>
        <div class="top1">
            <div class="logo">
            <a href="index.jsp">
            <img src="img/logo.png" alt="" style="width: 130px;"></a></div>
            <div class="top_right">
            <p class="user_name"><%=id %> &nbsp;</p>
            <div class="loginButton">
            <%if(id.equals("GUEST")){%>
				<a href="index.jsp?center=MemberLogin.jsp">Login</a>
				<%}else{%>
				<a href="MemberLogout.jsp">Logout</a>
				<%} %>
				</div>
  			</div>
        </div>
    </div>
    <div class="nav_bar">
        <div class="each_menu"><a href="index.jsp?center=DrinkListCon.do">주류목록</a></div>
        <!-- <div class="each_menu"><a href="index.jsp?center=CarReserveView.jsp">Confirmation</a></div> -->
        <div class="each_menu"><a href="index.jsp?center=BoardList.jsp">Q&A</a></div>
        <!-- <div class="each_menu"><a href="#">Event</a></div>
        <div class="each_menu"><a href="index.jsp?center=CustomerCenter.jsp">Customer Center</a></div> -->
    </div>
</body>
</html>