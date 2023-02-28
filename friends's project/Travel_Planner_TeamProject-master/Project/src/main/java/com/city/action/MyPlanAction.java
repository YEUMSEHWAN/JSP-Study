package com.city.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.CityDAO;
import com.city.model.CityVO;

public class MyPlanAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CityDAO dao = CityDAO.getInstance();
		List<CityVO> arry = dao.getCity();
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		request.setAttribute("lng", lng);
		request.setAttribute("lat", lat);
		request.setAttribute("arry", arry);
		return new ActionForward("/project/myPlan.jsp", false);
	}

}
