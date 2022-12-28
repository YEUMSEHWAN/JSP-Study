<%@page import="model.BoardBean"%>
<%@page import="java.util.Vector"%>
<%@page import="model.BoardDAO"%>
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
<link rel="stylesheet" href="BoardList.css"> 

</head>
<body>




<!-- 게시글 보기에 카운터링을 설정하기위한 변수들을 선언 -->
<%
	//화면에 보여질 게시글의 개수를 지정
	int pageSize=10;
	//현제 카운터를 클릭한 번호값을 읽어옴
	String pageNum = request.getParameter("pageNum");
	//만약 처음 boardlist.jsp를 클릭하거나 수정 삭제 등 다른 게시글에서 이 페이지로 넘어오면 pageNum값이 없기에 null처리를 해줌
	if(pageNum==null){
		pageNum="1";
	}
	int count = 0;//전체 글의 갯수를 저장하는 변수
	int number = 0;//페이지 넘버링 변수
	
	//현제 보고자 하는 페이지 숫자를 저장'[s]
	int currentPage = Integer.parseInt(pageNum);


	//전체 게시글의 내용을 jsp쪽으로 가져와야함
	BoardDAO bdao = new BoardDAO();
	//전체 게시글의 갯수를 읽어드린 메소드 호출
	count = bdao.getAllCount();
	
	//현제 페이지에 보여줄 시작 번호를 설정 = 데이터 베이스에서 불러올 시작번호
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage * pageSize; 
	

	//최신글 10개를 기준으로 게시글을 리턴 받아주는 소스
	Vector<BoardBean> vec = bdao.getAllBoard(startRow, endRow);
	//테이블에 표시할 번호를 저장
	number = count - (currentPage -1) *pageSize;

%>


<div>
        <div class="title"><p class="titleP">How can we assist you?</p></div>
        <div class="uploadingButton"><button onclick="location.href='index.jsp?center=BoardWriteForm.jsp'">Ask us a question</button></div>
    </div>
        <center>
            <table width="900">
                <thead>
                    <tr height="38">
                        <th class="no">No.</th>
                        <div><th>Title</th></div>
                        <th>Writer</th>
                        <th>Date</th>
                        <th>Views</th>
                    </tr>
                </thead>
                <tbody>
                <%
	for(int i=0; i<vec.size(); i++){
		BoardBean bean = vec.get(i);//벡터에 저장되어있는 빈클래스를 하나씩 추출
%>
                    <tr height="40">
                        <td class="no Content"><%=number-- %></td>
                        <td class="Content"><a href="index.jsp?center=BoardInfo.jsp?num=<%=bean.getNum() %>">
                        <%
			if(bean.getRe_step() > 1){
				for(int j=0; j<(bean.getRe_step()-1)*3; j++){
		%>&nbsp;
		<% 			
				}
			}
		%>
		<%=bean.getSubject() %>
                        </a></td>
                        <td class="writer Content"><%=bean.getWriter() %></td>
                        <td class="Content"><%=bean.getReg_date() %></td>
                        <td class="Content"><%=bean.getReadcount() %></td>
                    </tr>
                    <%} %>
                </tbody>
            </table>
        </center>        
        <div>
        <p class="announce">*It might take approximately 3 days to respond.</p>
        </div>




<!-- 페이지 카운터링 소스를 작성 -->
<%
	if(count > 0){
		
		int pageCount = count / pageSize +(count%pageSize == 0 ? 0 : 1);//카운터링 숫자를 얼마까지 보여줄건지 결정
		
		//시작 페이지 숫자를 설정
		int startPage =1;
		
		if(currentPage %10 != 0){
			startPage = (int)(currentPage/10)*10+1;
		}else{
			startPage = ((int)(currentPage/10)-1)*10+1;
		}
		
		
		int pageBlock=10;//카운터링 처리숫자
		int endPage = startPage + pageBlock-1;//화면에 보여질 페이지의 마지막 숫자
		
		if(endPage > pageCount) endPage = pageCount;
		
		//이전이라는 링크를 만들건지 파악
		if(startPage > 10){
%>
	<a href="index.jsp?center=BoardList.jsp?pageNum=<%=startPage-10 %>"> [이전] </a>
<%			
		}
		//페이징 처리
		for(int i=startPage; i<=endPage; i++){
%>
			<a href="index.jsp?center=BoardList.jsp?pageNum=<%=i %>"> [<%=i %>] </a>
<% 			
		}
		
		//다음이라는 링크를 만들건지 파알
		if(endPage < pageCount){
%>
			<a href="index.jsp?center=BoardList.jsp?pageNum=<%=startPage+10 %>"> [다음] </a>
<%			
		}
	}
%>
	


</body>
</html>