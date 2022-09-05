package com.board.Action;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//글 목록을 처리하는 클래스
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// 한 페이지에 보여줄 글 목록 수 지정
		int pageSize = 5;

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // Strign이니까 더블쿼터.
		}

		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;

		int count = 0;
		int number = 0;
		List<BoardVO> articleList = null;
		BoardDAO dbPro = BoardDAO.getInstance();// <===db연결

		// 전체 글의 수가 하나라도 존재하면
		if (count > 0) {
			// 하나라도 존재하면 리스트를 출력.
			articleList = dbPro.getArticles(startRow, endRow);

		} else {
			articleList = Collections.emptyList();
		}

		// 글 목록에 표시할 번호
		number = count - (currentPage - 1) * pageSize;

		//해당 뷰에서 사용할 속성 저장
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
		
		
		return "board/list.jsp";
	}

}
