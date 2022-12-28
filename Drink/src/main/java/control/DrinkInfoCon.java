package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DrinkBean;
import model.DrinkDAO;


@WebServlet("/DrinkInfoCon.do")
public class DrinkInfoCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//num
		int no = Integer.parseInt(request.getParameter("no"));
		
		//데이터베이스에 접근
		DrinkDAO bdao = new DrinkDAO();
		//하나의 게시글에 대한 정보를 리턴
		DrinkBean bean = bdao.getOneDrink(no);
		
		request.setAttribute("bean", bean);
		
		//view -jsp 쪽으로 데이터를 넘겨줌
		RequestDispatcher dis = request.getRequestDispatcher("index.jsp?center=DrinkInfo.jsp");
		dis.forward(request, response);
		
		
	}
}
