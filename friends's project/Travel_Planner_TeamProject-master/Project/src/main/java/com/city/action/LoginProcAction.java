package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.MembershipDAO;

public class LoginProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		//DB연결
		MembershipDAO dao = MembershipDAO.getInstance();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		int check = dao.loginCheck(id, pass);
		
		//로그인성공
		if(check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginID", id);
		
		}else if(id !=null && pass != null) {
			request.setAttribute("check", check);
		}
		return new ActionForward("/project/loginProc.jsp", false);
	}

}
