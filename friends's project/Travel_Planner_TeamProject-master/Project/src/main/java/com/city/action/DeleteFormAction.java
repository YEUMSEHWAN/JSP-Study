package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.MembershipDAO;
import com.city.model.MembershipVO;

public class DeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginID");
		request.setAttribute("id", loginID);
		return new ActionForward("/project/deleteForm.jsp",false);
	}

}
