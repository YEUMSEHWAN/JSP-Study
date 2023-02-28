package com.city.action;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.FreeBoardDAO;
import com.city.model.FreeBoardVO;

public class FreeBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		
		int num = 0;
		try{
			if(request.getParameter("num")!=null){
				num = Integer.parseInt(request.getParameter("num"));
				}
			}catch(Exception e){}
				// 해당 뷰에서 사용할 속성
				 	request.setAttribute("num",new Integer(num));
				 	
		
		
		
		
		 int pageSize = 10;
		 
		 

		    //페이지 num을 가져온다
		    String pageNum = request.getParameter("pageNum");
		    
		    if(pageNum == null) {
		    	pageNum = "1";
		    }

		    //현재 페이지 
		    int currentPage =Integer.parseInt(pageNum);
		    
		    int startRow = (currentPage-1) * pageSize + 1; 
		    int endRow = currentPage * pageSize;    
		    int count = 0;
		      int number =0;
		      List<FreeBoardVO> articleList = null;
		      FreeBoardDAO dbPro = FreeBoardDAO.getInstance(); // db연결
		      count = dbPro.getArticleCount();
		   
		       if(count > 0){  // 현재 페이지에 해당하는 글목록
		       //하나라도 존재 하면 리스트를 출력해라
		       articleList = dbPro.getArticles(startRow, endRow);
		    }	       
		 else { // 검색 일 경우		 
		      //하나라도 존재 하면 리스트를 출력해라
		      articleList = Collections.emptyList();  
		}	   
		  // 글 목록에 표시할 글 번호
		    number = count - (currentPage - 1) * pageSize;
		
		    // 해당 뷰에서 사용할 속성 저장
		    request.setAttribute("currentPage",currentPage);
		    request.setAttribute("startRow", startRow);
		    request.setAttribute("endRow", endRow);
		    request.setAttribute("count", count);
		    request.setAttribute("pageSize", pageSize);
		    request.setAttribute("number", number);
		    request.setAttribute("articleList", articleList);
		    
		    // 해당 뷰로 반환해줌
		
		return new ActionForward("/project/freeBoardList.jsp", false);
	}

}
