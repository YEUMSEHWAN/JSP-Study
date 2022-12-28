<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="DrinkList.css" />
    <link rel="stylesheet" href="reset.css" />
    <title>List of alcoholic beverages</title>
  </head>
  <body>
    <header class="h_top">
      <div class="h_wrap">
        <div class="h_img">
          <img src="img\bukchon.jpg" alt="" />
        </div>
        <div class="h_text">
          <p>우리술찾기</p>
        </div>
      </div>
      <nav class="n_n">
        <div class="n_title">
          <p>전체</p>
        </div>
        <div class="n_a">
          <a href="DrinkListCon.do">전체</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="TakCon.do">탁주</a
          >&nbsp;&nbsp;|&nbsp;&nbsp;
          <a href="YakCon.do">약주・청주</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="GaCon.do"
            >과실주</a
          >&nbsp;&nbsp;|&nbsp;&nbsp;
          <a href="JungCon.do">증류주</a>&nbsp;&nbsp;|&nbsp;&nbsp;
          <a href="LiCon.do">리큐르/기타주류</a>
        </div>
      </nav>
      <main>
        <ul>
        <c:forEach var="bean" items="${v }">
          <li>
           <a href="DrinkInfoCon.do?no=${bean.no }"> <div class="m_img"><img src="img/${bean.img }" alt="" /></div></a>
            <div class="m_title">
              <div class="m_name">${bean.name }</div>
              <div class="m_origin">
                <div class="m_one">
                  <div class="m_subject">원산지</div>

                  <div class="m_info or_info">${bean.origin }</div>
                </div>
                <div class="m_one">
                  <div class="m_subject">도수</div>

                  <div class="m_info al_info">${bean.alchol }%</div>
                </div>
                <div class="m_one">
                  <div class="m_subject">추천음식</div>

                  <div class="m_info">${bean.food }</div>
                </div>

                <div class="m_one">
                  <div class="m_subject point">특징</div>
                  <div class="no-line point_info">
                    <span class="el-3line">
                       ${bean.info }
                    </span>
                  </div>
                </div>
              </div>
            </div>
          </li>
          </c:forEach>
        </ul>
      </main>
    </header>
    
    <center>
<p>
		<!-- 페이지 카운터링 소스 작성  -->
		<c:if test="${count>0}">
			<c:set var="pageCount" value="${count /pageSize + (count%pageSize == 0 ? 0 : 1 )}" />
			<c:set var="startPage" value="${1}" />
			
			<c:if test="${currentPage%10 != 0}">
				<!--결과를 정수형으로 리턴 받아야 하기에 fmt  -->
				<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true"/>
				<c:set var="startPage" value="${result*10+1}" />
			</c:if>
			
			<c:if test="${currentPage%10 == 0}">
				<!--결과를 정수형으로 리턴 받아야 하기에 fmt  -->
				<c:set var="startPage" value="${(result-1)*10+1}" />
			</c:if>
			
			<!-- 화면에 보여질 페이지 처리 숫자를 표현 -->
			<c:set var="pageBlock" value="${10}" />
			<c:set var="endPage" value="${startPage+pageBlock-1}" />
			
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			
			<!--이전 링크를 결지 파악 -->
			<c:if test="${startPage > 10}">
				<<a href="DrinkListCon.do?pageNum=${startPage-10}">[이전]</a>
			</c:if>
			
			<!-- 페이징 처리-->
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="DrinkListCon.do?pageNum=${i}" style ="text-decoration:none">[${i}]</a>
			</c:forEach>
			
			<!-- 다음  -->
			<c:if test="${endPage < pageCount}">
				<a href="DrinkListCon.do?pageNum=${startPage+10}">[다음]</a>
			</c:if>
		</c:if>
		</p>  
		
		</center>  
  </body>
</html>