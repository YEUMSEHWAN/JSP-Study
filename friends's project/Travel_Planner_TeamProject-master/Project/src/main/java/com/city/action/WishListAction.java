
package com.city.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.CityDAO;
import com.city.model.MembershipDAO;
import com.city.model.SaveCityVO;
import com.city.model.WishListVO;

public class WishListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		CityDAO dao = CityDAO.getInstance();
		
		// id로 idCheck값 리스트로 받아옴(중복x)
		List<String> arry = dao.getCity(id);
		TreeSet<String> set = new TreeSet<String>(arry);
		List<String> resultArry = new ArrayList<>(set);
		int arraySize = resultArry.size(); // 저장된 일정이 있는지 확인하기 위함

		List<SaveCityVO> planList = new ArrayList<>();
		planList = dao.getCityInfo(id);
		
		String[] cityResult_kr = new String[resultArry.size()]; 
		
		
		List<SaveCityVO> result = new ArrayList<>();
		
		for(int i = 0; i < resultArry.size(); i++) {
			SaveCityVO vo = new SaveCityVO();
			cityResult_kr[i] = "";
			for(int j = 0; j < planList.size(); j++) {
				if(resultArry.get(i).equals(planList.get(j).getSave_city_idCheck())) {
					if(j == 2 || j == 5 || j == 8) {
						cityResult_kr[i] += "<br> → "+planList.get(j).getSave_city_kor();
					} else {
						cityResult_kr[i] += " → "+planList.get(j).getSave_city_kor();
					}
				}
			}
			vo.setSave_city_kor(cityResult_kr[i]);
			vo.setSave_city_idCheck(resultArry.get(i));
			result.add(vo);
		}
		
		// 닉네임 얻어오기
		MembershipDAO m_dao = MembershipDAO.getInstance();
		String nick = m_dao.getNick(id);
		
		// 아이디 첫글자 뽑기
		String id_first = id.substring(0, 1);
		
		request.setAttribute("result", result);
		request.setAttribute("arraySize", arraySize);
		request.setAttribute("nick", nick);
		request.setAttribute("id_first", id_first);
		
		// 위시 리스트(도시)
		List<WishListVO> cityWishList = dao.getwishListCity(id);
		request.setAttribute("cityWishList", cityWishList);
		
		return new ActionForward("/project/wishList.jsp", false);
	}

}
