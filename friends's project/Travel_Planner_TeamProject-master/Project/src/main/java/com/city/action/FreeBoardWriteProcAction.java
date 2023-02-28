package com.city.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.FreeBoardDAO;
import com.city.model.FreeBoardVO;

public class FreeBoardWriteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
	 	
		// 单捞磐 后 贸府
		
		// 按眉 积己 ( jsp 颇老狼 property)
		FreeBoardVO article = new FreeBoardVO();
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));	
		article.setSubject(request.getParameter("subject"));
		article.setRegdate(new Timestamp(System.currentTimeMillis()));
		article.setContent(request.getParameter("content"));
		
		FreeBoardDAO dbPro = FreeBoardDAO.getInstance();
		dbPro.insertArticle(article);
		
		return new ActionForward("/project/freeBoardWriteProc.jsp", false);
	}

}
