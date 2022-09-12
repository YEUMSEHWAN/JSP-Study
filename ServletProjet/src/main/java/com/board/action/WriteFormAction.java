package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// 새글일 경우 num = 0이라고 해서 넘겨줄 것이고 답변글일 경우 원래의 글번호의 num을 받아와서
		// 넘겨줌 num을 통해서 새글은지 답변글인지를 구분할 수 있다.

		int num = 0, ref = 1, step = 0, depth = 0;

		try {
			if (request.getParameter("num") != null) {
				num = Integer.parseInt(request.getParameter("num"));
				ref = Integer.parseInt(request.getParameter("ref"));
				step = Integer.parseInt(request.getParameter("step"));
				depth = Integer.parseInt(request.getParameter("depth"));
			}
		} catch (Exception e) {
		}
		request.setAttribute("num", num);
		request.setAttribute("ref", ref);
		request.setAttribute("step", step);
		request.setAttribute("depth", depth);

		return "/board/writeForm.jsp";

	}

}
