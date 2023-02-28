package com.city.action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.control.ActionForward;
import com.city.model.MembershipDAO;
import com.city.model.MembershipVO;


public class FindPwResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 request.setCharacterEncoding("utf-8");
		 MembershipDAO dao = MembershipDAO.getInstance();
		 	
		 String id = request.getParameter("id");
		 String email = request.getParameter("email");
		 
		 String pwd = dao.findpw(id, email);
		 if(pwd != "") {
		 	request.setAttribute("pwd", pwd);
		 } else {
			 int pw = 1;
			 request.setAttribute("pwd", pw);
		 }
		 
		 return new ActionForward("/project/findPwResult.jsp", false);
	}

}
