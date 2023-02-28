package com.city.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.FreeCommentDAO;
import com.city.model.FreeCommentVO;

public class FreeCommentDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		String userID = null;
		if (request.getSession().getAttribute("loginID") != null) {//유저아이디이름으로 세션이 존재하는 회원들은 
			userID = (String) request.getSession().getAttribute("loginID");//유저아이디에 해당 세션값을 넣어준다.
		}
		
		int num = 0;
		if (request.getParameter("num") != null){
			num = Integer.parseInt(request.getParameter("num"));
		}
		
		//댓글이 유효한지 판별
				int commentID = 0;
				if (request.getParameter("commentID") != null) {
					commentID = Integer.parseInt(request.getParameter("commentID"));
				}
		
				FreeCommentVO comment = new FreeCommentDAO().getComment(commentID);
				FreeCommentDAO commentDAO = new FreeCommentDAO();
				int result = commentDAO.delete(commentID);
				
				String real = "C:\\teamproject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project\\project\\imageSave";
				/* String commentReal = "C:\\Users\\SUCCU\\Desktop\\JSP_STUDY\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TeamProject\\boardone\\img\\uploadImg"; */
				if(result != -1) {
					File delFile = new File(real+"\\"+comment.getImageUID()+".jpg");
					if(delFile.exists()){
						delFile.delete();
					}
				}
				
				request.setAttribute("result", result);
				request.setAttribute("num", num);
				request.setAttribute("commentID", commentID);
				request.setAttribute("comment", comment);
		
		return new ActionForward("/project/freeCommentDelete.jsp", false);
	}

}
