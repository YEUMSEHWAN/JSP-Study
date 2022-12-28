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
<link rel="stylesheet" href="MemberLogin.css">
<title> </title>
</head>
<body>
	<form action="MemberLoginProc.jsp" method="post">
	<main>
        <div class="loginTitle">Sign in</div>
        <div class="loginTable">
                <div class="eachRow id_pd">
                    <div class="id">ID</div>
                    <div><input type="text" name="id" placeholder="username"> </div>
                </div>
                <div class="eachRow id_pd">
                    <div class="pd">Password</div>
                    <div><input type="password" name="pass" placeholder="password"> </div>
                </div>
            <div class="login_signup">
                <div class="login"><input type="submit" value="Login"/></div>
                <div class="signup">Not a member?<button class="signupButton">
                <a href="index.jsp?center=MemberJoin.jsp">
                Sign up</a></button></div>
            </div>
        </div>
    </main>
	</form>
</body>
</html>