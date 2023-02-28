package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.MembershipDAO;
import com.city.model.MembershipVO;

public class RegProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		MembershipDAO dao = MembershipDAO.getInstance();
		
		MembershipVO vo = new MembershipVO(
				request.getParameter("id"),
				request.getParameter("pass"),
				request.getParameter("nick"),
				request.getParameter("email")
				);
		
		boolean flag = dao.memberInsert(vo);
		request.setAttribute("flag", flag);
		System.out.println(flag);
		
		return new ActionForward("/project/regProc.jsp", false);
	}

}
