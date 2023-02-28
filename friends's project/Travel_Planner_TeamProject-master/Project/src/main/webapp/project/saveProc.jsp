<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${cityEn1 eq null}">
	<script type="text/javascript">
		alert("<도시를 추가해주세요.>");
		history.go(-1);
	</script>
</c:if>
<!-- 위에 안걸리고 저장 되었으면 저장완료 선언 후 페이지 이동 -->
<meta http-equiv="Refresh" content="0; url=cityPlan.do?cmd=cityInfoView">
<c:if test="${cityEn1 ne null}">
	<script type="text/javascript">
		alert("<저장 완료>");
	</script>
</c:if>
