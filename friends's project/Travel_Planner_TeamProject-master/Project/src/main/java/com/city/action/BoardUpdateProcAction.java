package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.BoardDAO;
import com.city.model.BoardVO;

public class BoardUpdateProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		
		
		BoardVO article = new BoardVO();
		
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		
//		if(article.setWriter().equals(id)) {}S
		
		BoardDAO dbPro = BoardDAO.getInstance();
		int check = dbPro.updateArticle(article);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		
		return new ActionForward("/project/boardUpdateProc.jsp" , false);
	}

}
