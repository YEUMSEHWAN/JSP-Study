package com.board.Action;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�� ����� ó���ϴ� Ŭ����
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// �� �������� ������ �� ��� �� ����
		int pageSize = 5;

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // Strign�̴ϱ� ��������.
		}

		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;

		int count = 0;
		int number = 0;
		List<BoardVO> articleList = null;
		BoardDAO dbPro = BoardDAO.getInstance();// <===db����

		// ��ü ���� ���� �ϳ��� �����ϸ�
		if (count > 0) {
			// �ϳ��� �����ϸ� ����Ʈ�� ���.
			articleList = dbPro.getArticles(startRow, endRow);

		} else {
			articleList = Collections.emptyList();
		}

		// �� ��Ͽ� ǥ���� ��ȣ
		number = count - (currentPage - 1) * pageSize;

		//�ش� �信�� ����� �Ӽ� ����
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
