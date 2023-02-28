package com.city.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.CityDAO;
import com.city.model.CityVO;
import com.city.model.SaveCityVO;

public class PlanInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CityDAO dao = CityDAO.getInstance();
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
    	String idCheck = request.getParameter("idCheck"); // 임의로 지정 => 마이페이지 완성되면 변경
		List<SaveCityVO> arry = dao.getCity(idCheck, id);
		List<CityVO> arry2 = dao.getCity();
		
		request.setAttribute("id", id);
		request.setAttribute("idCheck", idCheck);
		request.setAttribute("arry", arry);
		request.setAttribute("arry2", arry2);
		return new ActionForward("/project/planInsert.jsp", false);
	}

}
