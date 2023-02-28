package com.city.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.CityDAO;
import com.city.model.CityVO;

public class CityInfoSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CityDAO dao = CityDAO.getInstance();
		String userSearch = request.getParameter("userSearch");
		List<CityVO> arry = dao.getCitySearch(userSearch);
		boolean check = false;
		
		request.setAttribute("arry", arry);
		request.setAttribute("check", check);
		return new ActionForward("/project/cityInfoSearch.jsp", false);
	}

}
