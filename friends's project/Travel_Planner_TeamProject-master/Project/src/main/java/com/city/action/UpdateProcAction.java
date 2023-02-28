package com.city.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.CityDAO;
import com.city.model.SaveCityVO;

public class UpdateProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		// String idCheck = request.getParameter("idCheck"); // 얘도 바꿔야함
		String idCheck = request.getParameter("idCheck"); // 얘도 바꿔야함
		CityDAO dao = CityDAO.getInstance();
		List<SaveCityVO> arry = dao.getCity(idCheck, id); // 기존에 저장된 나라들 가져오기
		dao.deletePlan(idCheck);
		boolean check = false; // 저장됐던 나라, 새롭게 저장되는 나라의 값들이 없으면 false로 도시를 추가하라고 alert뜰거임
		for(int i = 1; i <= arry.size(); i++){ // 저장된 나라만큼 for문
			if(request.getParameter("bfcityEn"+i) != null) { // 저장된 나라의 값을 얻어왔을 때 if문 통과
				dao.savePlan(id, idCheck, request.getParameter("bfcityEn"+i), request.getParameter("bfcityKr"+i), request.getParameter("bfsche"+i));
				// 모든 값을 받아서 insert하는 sql문이 있음 +i는 planInsert.jsp에서 넘어온 값들의 순서를 의미
				check = true;
				// 저장된 값이 있으므로 true로 변경
			}
		}
		int count; // 새롭게 추가한 도시들의 수를 나타내기 위해 생성
		if(request.getParameterValues("count") != null){ // count의 값이 null이라면 들어오지 못함
			count = request.getParameterValues("count").length; // 새롭게 추가한 도시들의 수를 나타냄
			
			for(int i = 1; i <= count; i++){ // 새롭게 추가한 도시들의 길이만큼 for문
				if(request.getParameter("cityEn"+i) != null) { // 저장된 나라의 값을 얻어왔을 때 if문 통과
					dao.savePlan(id, idCheck, request.getParameter("cityEn"+i), request.getParameter("cityKr"+i), request.getParameter("sche"+i));
					// 모든 값을 받아서 insert하는 sql문이 있음 +i는 planInsert.jsp에서 넘어온 값들의 순서를 의미
					check = true;
					// 저장된 값이 있으므로 true로 변경
				}
			}
		}
		request.setAttribute("check", check);
		return new ActionForward("/project/updateProc.jsp", false);
	}

}
