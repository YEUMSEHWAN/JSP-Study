<%@page import="java.awt.font.ImageGraphicAttribute"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.boardone.BoardDAO"%>
<%@ page import="com.boardone.BoardVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@include file="view/color.jsp"%>


<%
//한 페이지에 보여줄 글 목록 수 지정
int pageSize = 5;

//날짜 형식 지정
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

//페이지 넘버를 파라미터값으로 넘김
String pageNum = request.getParameter("pageNum");
String searchWhat = request.getParameter("searchWhat");
//무엇을 검색할지 파라미터 값을 가져와야함(작성자, 제목, 내용)
String searchText = request.getParameter("searchText");
//검색내용

//파라미터 값을 가져와서 한글로 변환
if (searchText != null) {
	searchText = new String(searchText.getBytes("utf-8"), "utf-8");
}

if (pageNum == null) {
	pageNum = "1"; //Strign이니까 더블쿼터.
}

int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * pageSize + 1;
int endRow = currentPage * pageSize;

int count = 0;
int number = 0;

List<BoardVO> articleList = null;
BoardDAO dbPro = BoardDAO.getInstance();//<===db연결

//검색이 아니면 전체목록을 보여주고 검색일 경우 검색한 내용만 출력

if (searchText == null) {//검색이 아닌경우(null값)

	//전체 글의 수를 의미
	count = dbPro.getArticleCount();

	//전체 글의 수가 하나라도 존재하면 
	if (count > 0) {
		//하나라도 존재하면 리스트를 출력.
		articleList = dbPro.getArticles(startRow, endRow);
	}

} else {//검색일 경우
	count = dbPro.getArticleCount(searchWhat, searchText);

	//전체 글의 수가 하나라도 존재하면 
	if (count > 0) {
		//하나라도 존재하면 리스트를 출력.
		articleList = dbPro.getArticles(searchWhat, searchText, startRow, endRow);
	}

}

number = count - (currentPage - 1) * pageSize;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcolor="${ bodyback_c}">

	<div align="center">
		<b>글 목록(전체 글:${ count})
		</b>

		<table width="700">
			<tr>
				<td align="right" bgcolor="${value_c }"><a
					href="/ServletProject/board/writeForm.bdo">글쓰기</a></td>
			</tr>
		</table>
		<c:if test="${count == 0 }">

		<table width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">게시판에 글이 없습니다.</td>
			</tr>
		</table>
		</c:if>
	<c:if test="${count > 0 }">
		<table width="700" border="1" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" bgcolor="${value_c }">
				<td align="center" width="50">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">날짜</td>
				<td align="center" width="50">조회</td>
				<td align="center" width="100">IP</td>
			</tr>
			<%
			for (int i = 0; i < articleList.size(); i++) {
				BoardVO article = (BoardVO) articleList.get(i);
			%>
			<tr height="30">
				<td align="center" width="50"><%=number--%></td>
				<td width="250">
					<%
					int wid = 0;

					if (article.getDepth() > 0) {
						wid = 5 * (article.getDepth());
					%> <img src="img/level/gif" width="<%=wid%>" height="16"> <img
					src="img/re.gif"> <%
 } else {
 %> <img src="img/level/gif" width="<%=wid%>" height="16"> <%
 }
 %> <a
					href="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>">
						<%=article.getSubject()%></a> <%
 if (article.getReadcount() > 20) {
 %> <img src="img/hot.gif" border="0" height="16"> <%
 }
 %>
				</td>
				<td align="center" width="100"><a
					href="mailto:<%=article.getEmail()%>"> <%=article.getWriter()%></a>
				</td>

				<td align="center" width="150"><%=sdf.format(article.getRegdate())%></td>


				<td align="center" width="50"><%=article.getReadcount()%></td>
				<td align="center" width="100"><%=article.getIp()%></td>
			</tr>

			<%
			} //end for
			%>

		</table>

		<%
		} //end else
		%>
		<%
		//page block

		if (count > 0) {
			int pageBlock = 3;

			int imsi = count % pageSize == 0 ? 0 : 1;

			int pageCount = count / pageSize + imsi;

			//시작 페이지 
			int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;

			//마지막 페이지
			int endPage = startPage + pageBlock - 1;

			//마지막으로 보여줄 페이지
			if (endPage > pageCount)
				endPage = pageCount;

			//페이지 블럭을 이전과 다음 처리 작업.
			if (startPage > pageBlock) {

				//검색일 경우와 아닐경우 페이지 처리를 해야함.
				if (searchText == null) {
		%>
		<a href="list.jsp?pageNum=<%=startPage - pageBlock%>">[이전]</a>

		<%
		} else {
		%>
		<a href="list.jsp?pageNum=<%=startPage - pageBlock%>&searchWhat=<%=searchWhat%>&searchText=<%=searchText%>">[이전]</a>
		<%
		}

		} //end if
		for (int i = startPage; i <= endPage; i++) {
		if (searchText == null) {
		%>
		<a href="list.jsp?pageNum=<%=i%>">[<%=i%>]
		</a>

		<%
		} else {
		%>
		<a href="list.jsp?pageNum=<%=i%>&searchWhat=<%=searchWhat%>&searchText=<%=searchText%>">[<%=i%>]
		</a>


		<%
		}
		} //end for
		if (endPage < pageCount) {
		if (searchText == null) {
		%>
		<a href="list.jsp?pageNum=<%=startPage + pageBlock%>">[다음]</a>
		<%
		} else {
		%>
		<a href="list.jsp?pageNum=<%=startPage + pageBlock%>&searchWhat=<%=searchWhat%>&searchText=<%=searchText%>">[다음]</a>
		<%
		}
		} //end if
		} //end if
		%>

		<!-- 검색 창 -->

		<form action="list.jsp">
			<select name="searchWhat">
				<option value="writer">작성자</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
			</select> <input type="text" name="searchText"> <input type="submit" value="검색">
		</form>
	</div>
</body>
</html>