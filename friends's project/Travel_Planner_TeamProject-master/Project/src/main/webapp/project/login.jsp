<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
<link href="css/memberstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
</head>
<body class ="login-body">
<form action="cityPlan.do?cmd=loginProc" method = "post">
<div class = "center">
	<div class ="container">
	   <div class = "text"><h2>LOG IN</h2></div>
	   <div class = "small-text"><a href="cityPlan.do?cmd=cityInfoView" id="login_home">여행 스케쥴링 플래너 - 도죠</a></div>
	<div class = "form-container">
	   		<div class = "data">
	   	 		<label>ID</label>
	   	 		<input class="data-input" type = "text" name = "id">
	   	 	</div>
	   	 	
	   	 	<div class = "data">
	   	 		<label>PASSWORD</label>
	   	 		<input class="data-input" type = "password" name = "pass">
	   	 	</div>
	   	 	
	   	 	<!--비밀번호 찾기  -->
	   	 	<div class = "forget-pass">
	   	 	<a class="fg-pass" href ="#findpassWord">비밀번호를 잊으셨나요?</a>
	   	 	</div>
	   	 	
	   	 	<!--로그인 버튼  -->
	   	 	<div class = "btn"> 
	   	 	 	<div class = "log-button"></div>
	   	 	 	<input type ="submit" id="btnLogin" value = "login">
	   	 	</div>
	   	 	
	   	 	<!--회원가입 링크  -->
	   	 	<div class = "signup-link">회원이 아니신가요?
	   	 	 <a class= "link" href="cityPlan.do?cmd=regForm">회원가입하기</a>
	   	 	</div>
	   	 	
	  </div>
	</div>
	</div>
</form>
<div class="modal" id="findpassWord" style="max-width:40%; height:50%; padding: 0;">
<form action="cityPlan.do?cmd=findPwResult" method="post">
 	<div class ="center" >
 		<div class="container">
  			<div class = "text">비밀번호 찾기</div>
  			<div class ="small-text">여행 스케쥴링 플래너 - 도죠</div>
  			
  			<section class = "form-search">
  				<div class="find-id">	
  					<label class="label-text">아이디</label>
  					<input type="text" name="id" class="btn-name" placeholder ="아이디">
  				</div>
  				<div class="find-email">
  					<label class="label-text">이메일</label>
  					<input type="email" name="email" class="btn-email" placeholder="이메일">
  				</div>  			
  			</section>
  			<div class="btnSearch">
  				<button type="submit">비밀번호 찾기</button>
  			</div>
		</div>
 	</div>
</form>
</div>
<script type="text/javascript">	
    $('a[href="#findpassWord"]').click(function(event) {
     	event.preventDefault();	
 
     	$(this).modal({
        fadeDuration: 250 /* 모달 뜨는 속도 */
     	});
  	});
</script>	
<script type="text/javascript" src="js/memberscript.js"></script>
</body>
</html>