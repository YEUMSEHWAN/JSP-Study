package com.city.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.CityDAO;
import com.city.model.PlanCityInfoVO;
import com.city.model.WishListVO;

public class PlanCityInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		String name = request.getParameter("name");

		CityDAO dao = CityDAO.getInstance();
		
		boolean check = dao.getWishList(id, name);
		
		List<PlanCityInfoVO> arry = dao.getPlanInfo();
		
		request.setAttribute("name", name);
		request.setAttribute("arry", arry);  
		request.setAttribute("check", check);
		return new ActionForward("/project/planCityInfo.jsp");
	}
 
}
