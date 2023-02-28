package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.FreeBoardDAO;
import com.city.model.FreeBoardVO;

public class FreeBoardUpdateProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		
		
		FreeBoardVO article = new FreeBoardVO();
		
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		
//		if(article.setWriter().equals(id)) {}S
		
		FreeBoardDAO dbPro = FreeBoardDAO.getInstance();
		int check = dbPro.updateArticle(article);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		
		return new ActionForward("/project/freeBoardUpdateProc.jsp" , false);
	}

}
