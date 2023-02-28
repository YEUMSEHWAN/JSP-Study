package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.MembershipDAO;

public class DeleteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MembershipDAO dao = MembershipDAO.getInstance();

		
		String loginID = (String)session.getAttribute("loginID");
    	String pass = request.getParameter("pass");
    	
    	int result = dao.deleteMember(loginID, pass);
    	
    	if(result !=0) {
    		session.invalidate();
    	}
    	
    	request.setAttribute("result", result);
    	
    	
    	//2022-09-28 ¼öÁ¤ÇÔ
		return new ActionForward("/project/deleteProc.jsp", false);
	}

}
