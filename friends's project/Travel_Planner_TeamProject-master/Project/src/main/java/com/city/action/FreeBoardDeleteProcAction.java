package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.FreeBoardDAO;

public class FreeBoardDeleteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
request.setCharacterEncoding("utf-8");
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
//		String pass = request.getParameter("pass");

		FreeBoardDAO dbPro = FreeBoardDAO.getInstance();
		int check = dbPro.deleteArticle(num);
		
		request.setAttribute("pageNum", pageNum);
//		request.setAttribute("check", check);
		
		return new ActionForward("/project/freeBoardDeleteProc.jsp", false);
	}

}
