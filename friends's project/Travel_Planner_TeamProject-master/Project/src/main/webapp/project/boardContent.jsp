<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file = "base.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  	
  	
  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>게시판</title>
<link rel="stylesheet" type="text/css" href="css/content.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/board.js"></script>
</head>

<body>
<c:set var="loginID" value="${sessionScope.loginID}"/>
<c:set var="vo" value="${dao.getMember(loginID) }"/> 
<div id="note_page_panel" style="min-height:600px;">
 
	<div class="modal-dialog comment-pop">
		<div class="modal-content spot-comment-pop">
			<div class="modal-header">
				<div class="tit-bar">
					
					<div class="author-infor">
						<div class="name-time">
						<span class="user-name">${article.writer }</span>

					</div>
					<span class="data">
						<span class="time">${article.regdate}</span>
					</span>
					
					</div><%-- end div author-infor --%>
					
					
				</div><%-- end div tit-bar --%>
			</div> <%--end div modal-header --%>
			
			<div class="modal-body">
				<div id="note_detail_panel">
					<div class="spot-contents">
						<div id="note_panel">
							
							<div class="conts-tit-bar">
							<span class="boardname">공지</span>
								<div class="p">
								<div class="left">
									<h1>${article.subject }</h1>
								</div>
								<div class="right">
								<!-- 리스트 버튼 -->
								<button class="listBtn" onclick="document.location.href='cityPlan.do?cmd=boardList&pageNum=${pageNum }'"><img src="images/list.png" width="24px" height="24px"></button>
								
								<!-- 업데이트 버튼 -->
								<c:if test="${loginID == article.writer }">
								<button class="openBtn" id="updateBtn"><img src="images/edit.png" width="24px" height="24px"></button>
								</c:if>
								<!-- 업데이트 모달 -->


									<div class="umodal hidden">
  										<div class="bg"></div>
  											<div class="umBox">
	     										<div class='umodal_dialog'>
       		 										<div class='umodal_contents'>
         	   											<form action="cityPlan.do?cmd=boardUpdateProc" method="post" name="updateForm">
         	   												
         	   												<input type="hidden" name="num" value="${num }">
         	 	 												<div class='umodal_header'>
            	 	 												<p align="center">포스트 작성</p>
           	 	 												</div><hr>
          
          		  												<div class="umodal-writer">
           															<%-- <input type="text" size="12" maxlength="12" name="writer" placeholder="작성자" value="${article.writer }"> --%>
           															<input type="hidden" value="${article.writer }">
           		  												</div>
           
           		  												<div class="umodal-title">
           			
           															<input type="text" size="50" maxlength="50" name="subject" placeholder="제목" value="${article.subject }">
           		  												</div>
         
         	 	 												<div class='umodal_body' align='center'>
																	<div class="modal_content">
																		<textarea class="umodal_content" name="content" placeholder="내용">${article.content }</textarea>
																	</div>
         		  												</div>
         	
         		  												<div class='umodal_footer' id='modalBtn'>
	         		  												<div class='footer_wrap'>
	         															<input class="update-save" type="submit" value="저장">
	         		  												</div>

         	 	 												</div>
         	 	 												
         	 												</form>
     	 												</div><!-- end div modal-contents -->
  	 												</div><!-- end div modal-dialog -->
  												</div><!-- end div mBox -->
  												
											</div><!-- end div modal hidden -->	
											
										
										
										<!-- 삭제 버튼 -->
										<c:if test="${loginID == article.writer }">
										<button id="deleteBtn">
										<img src="images/delete.png" width="24px" height="24px" onclick="document.location.href='cityPlan.do?cmd=boardDeleteProc&num=${article.num }&pageNum=${pageNum }'">
										</button>
										</c:if>
										

 
										
										
										</div><!-- end div right -->
								
								
								</div>
								
							</div><%-- end div conts-tit-bar --%>
							
							<div class="conts-txt-area">
								<p>${article.content }</p>
							</div><%--end div conts-txt-area --%>
							
							<div class="author-info">
								<div class="tit-bar"></div>
							
							<div class="conts-label">
								<div class="spot-like-count">
									<a>좋아요
									<input type="button" onclick="location.href='cityPlan.do?cmd=evaluation&gechu=1&bichu=0&num=${num}'" value="${gechu}">
									</a>
								</div><%-- end div spot-like-count --%>
								
								<div class="spot-commont-count">
									<a class="show-comments-of-note">댓글</a>
								</div>
							</div><%-- end div conts-label --%>
							</div><%-- end div author-info --%>
						</div><%-- end div note_panel --%>
						
						<div id="note-comment-area">
							<div class="plan-comment">
								<div class="spot-comment-content">
									<div class="comment-write">
										<form method="post" enctype="multipart/form-data" action="cityPlan.do?cmd=comment&num=${num }" name="commentInputForm" onsubmit="return checkText()">
										
										
										<textarea  name="commentText" class="form-control new-comment-textarea"
										placeholder="댓글을 남겨주세요"></textarea>
										
										<div class="comment-edit-btns">
											<!-- <button class="btn btn-primary save-new-comment">
											저장</button> -->
											<input class="btn btn-primary save-new-comment" type="submit" value="저장">
										</div>
										
										
										</form>
										
									</div><%-- end div comment-write --%>
								</div><%-- end div spot-comment-content --%>
							<div class="spot-comment-list">
								<ul class="comment-list">
									<c:forEach var="list" items="${list}">
									<li class="commentRoot">
									<div class="comment-contents">
										<div class="name-date">
											<span></span>
											<a class="userName">
												${list.userID }
											</a>
											<span class="comment-date">${list.commentDate }
											</span>
										</div>
										<div class="edit-delete">
											<c:if test="${list.userID eq loginID }">
														<form name = "p_search">
															<a type="button" onclick="nwindow(${num },${list.commentID })">수정</a>
														</form>	
														<a onclick="return confirm('정말로 삭제하시겠습니까?')" href = "cityPlan.do?cmd=commentDelete&num=${num }&commentID=${list.commentID }">삭제</a>
												</c:if>
										</div>
										
										<div class="comment-txt">
											<p class="comment-content-for-find">${list.commentText }</p>
										</div>
									</div>
									</li>
									</c:forEach>
								</ul>
							</div>
							
							</div><%-- end div plan-comment --%>
						</div><%-- end div note-comment-area --%>
					</div><%-- end div spot-contents --%>
				
				</div><%-- end div note_detail_panel --%>
			</div><%-- end div modal-body --%>
			
		</div><%-- end div modal-content spot-comment-pop --%>
		
		
	</div> <%-- end div modal dialog comment pop --%>
</div> <%-- end div note page panel --%>
<script>
  const open = () => {
    document.querySelector(".umodal").classList.remove("hidden");
  }

  const close = () => {
    document.querySelector(".umodal").classList.add("hidden");
  }
  
  document.querySelector(".openBtn").addEventListener("click", open);
  document.querySelector(".closeBtn").addEventListener("click", close);
  document.querySelector(".bg").addEventListener("click", close);
</script> 
</body>
</html>

