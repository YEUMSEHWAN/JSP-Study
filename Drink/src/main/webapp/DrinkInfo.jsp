<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="DrinkInfo.css" />
    <link rel="stylesheet" href="reset.css" />
<title> </title>
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
    </header>
    <main>
      <div class="m_name">${bean.name }</div>
      <div class="li">
        <div class="m_img"><img src="img/${bean.img }" alt="" /></div>
        <div class="m_info">
          <ul>
            <li>추천음식 | ${bean.food }</li>
            <li>도수 | ${bean.alchol }%</li>
            <li>원산지 | ${bean.origin }</li>
          </ul>
        </div>
      </div>
      <div class="m_tro">제품소개</div>
      <div class="m_intro">
        ${bean.info }
      </div>
    </main>
  </body>
</html>