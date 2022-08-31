package com.mvcmem.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcmem.action.Action;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd != null) {//null값이 아닌 경우
			ActionFactory factory = ActionFactory.getInstance();
			
			Action action = factory.getAction(cmd);
			
			ActionForward af = action.execute(request, response);
			
			if(af.isRedirect()) {
				response.sendRedirect(af.getUrl());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());  
				rd.forward(request, response);
			}
			
			
			
		}else {//요청이 없는 경우
	
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head><title>Error</title></head>");
			out.print("<body>");
			out.print("<h4>올바른 요청이 아닙니다 !!!</h4>");
			out.print("<h4> http://localhost:9090/ServletProjet/mvcmem/member.mdo?cmd=요청키워드</h4>");
			
			
			out.print("</body>");
			out.print("</html>");
			
		}
		
	
	}

}
