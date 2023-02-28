package com.city.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.CityDAO;

public class DeleteWishList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		String name = request.getParameter("name");

		CityDAO dao = CityDAO.getInstance();
		dao.deleteWishList(id, name);
		request.setAttribute("name", name);
		return new ActionForward("cityPlan.do?cmd=planCityInfo", false);
	}

}
