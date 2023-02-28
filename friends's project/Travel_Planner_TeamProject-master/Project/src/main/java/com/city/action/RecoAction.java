package com.city.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.RecDAO;
import com.city.model.RecVO;

public class RecoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		RecDAO dao = RecDAO.getInstance();
		List<RecVO> array = dao.getMap();
		request.setAttribute("array", array);
		//RecDAO 
		return new ActionForward("/project/try1.jsp",false);
	}

}
