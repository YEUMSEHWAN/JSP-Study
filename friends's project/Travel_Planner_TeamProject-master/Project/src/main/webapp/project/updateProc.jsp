<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check}">
	<script type="text/javascript">
		alert("<저장 완료>");
	</script>		
</c:if>
<c:if test="${!check}">
	<script type="text/javascript">
		alert("<도시를 추가해주세요.>");
		history.go(-1);
	</script>
</c:if>
	<meta http-equiv="Refresh" content="0; url=cityPlan.do?cmd=cityInfoView">



