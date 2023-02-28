package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.MembershipDAO;
import com.city.model.MembershipVO;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MembershipDAO dao = MembershipDAO.getInstance();
		
		HttpSession session = request.getSession();
		
		//회원수정은 로그인이 된 상태해야됨
		String loginID = (String)session.getAttribute("loginID");
    	MembershipVO vo = dao.getMember(loginID);
		
    	request.setAttribute("id", vo.getId());
    	request.setAttribute("pass", vo.getPass());
    	request.setAttribute("nick", vo.getNick());
    	request.setAttribute("email", vo.getEmail());
    	
    	
		return new ActionForward("/project/modifyForm.jsp", false);
	}

}
