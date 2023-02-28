<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loginID" value="${sessionScope.loginID}"/>
<c:if test="${requestScope.check eq 0 }">
	<script type="text/javascript">
		alert('비밀번호가 틀렸습니다.')
		history.go(-1)
	</script>
</c:if>
<c:if test="${requestScope.check eq -1 }">
	<script type="text/javascript">
		alert('ID를 입력하세요.')
		history.go(-1)
	</script>
</c:if>
<meta http-equiv ="Refresh" content = "1; url=cityPlan.do?cmd=cityInfoView">