<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:set var="result" value="${result }"/>

    <c:if test="${result eq 0 }">
    <script type="text/javascript">
	alert("비밀번호가 맞지 않습니다.");
	history.go(-1);
	</script>
	</c:if>
	
	<c:if test="${result eq 1 }">
	<script type="text/javascript">
		alert("회원 탈퇴 되셨습니다.");
	</script>
	<meta http-equiv ="Refresh" content = "1; url=cityPlan.do?cmd=cityInfoView">
    </c:if>

</body>
</html>