<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
</head>
<c:set var="flag" value="${flag}"/> 
<body>
	<c:choose>
		<c:when test="${flag}">
			<script type="text/javascript">
			alert("회원 가입을 축하드립니다.");
			location.href="cityPlan.do?cmd=login";
			</script>
		</c:when>
		
		<c:otherwise>
			<script type="text/javascript">
			alert("다시 입력해주세요.");
			location.href="cityPlan.do?cmd=regForm";
			</script>
		</c:otherwise>
	</c:choose>

</body>
</html>