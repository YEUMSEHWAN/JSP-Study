package com.city.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.CityDAO;
import com.city.model.CityVO;
import com.city.model.SaveCityVO;

public class DeletePlanProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idCheck = request.getParameter("idCheck");
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		CityDAO dao = CityDAO.getInstance();
		if(idCheck != null) {
			dao.deletePlan(idCheck);
		}
		// id로 idCheck값 리스트로 받아옴(중복x)
		List<String> arry = dao.getCity(id);
		Set<String> set = new HashSet<String>(arry);
		List<String> list =new ArrayList<String>(set);
		
		List<SaveCityVO> planList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			planList = dao.getCity(list.get(i), id);
		}
		
		request.setAttribute("planList", planList);		
		request.setAttribute("arry", arry);
		return new ActionForward("cityPlan.do?cmd=wishList", false);
	}

}
