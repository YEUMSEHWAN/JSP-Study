package com.city.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.control.ActionForward;
import com.city.model.FreeCommentDAO;
import com.city.model.FreeCommentVO;
import com.city.model.MembershipDAO;
import com.city.model.MembershipVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FreeCommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MembershipDAO dao  = MembershipDAO.getInstance();
		FreeCommentVO comment  = new FreeCommentVO();
		
		String userID = null;
	 	String userName = "";
	 	if(request.getSession().getAttribute("loginID") != null){
	 		userID = (String) request.getSession().getAttribute("loginID");
	 		MembershipVO vo = dao.getMember(userID);
			userName = vo.getNick();
	 	}
	 	
	 	
		String realFolder="";
		String saveFolder = "project/imageSave";
		String encType = "utf-8";
		int maxSize=5*1024*1024;
		
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = null;
		
		multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());		
		String fileName = multi.getFilesystemName("fileName");
		String commentText = multi.getParameter("commentText"); 
		comment.setCommentText(commentText);
	 	
	 	UUID uid = null;
	 	String uidName = null;
	 	if(fileName != null){
	 		uidName = UUID.randomUUID().toString();
	 	}
	 	
	 	
	 	int num = 0; 
	 	if (request.getParameter("num") != null){
	 		num = Integer.parseInt(request.getParameter("num"));
	 	}
	 	
	 	int commentID = -1;
	 	
	 	if(userID != null) {
	 	FreeCommentDAO commentDAO = new FreeCommentDAO();
 		commentID = commentDAO.write(num, userID, comment.getCommentText(), userName, uidName);
	 	}
	 	
		if( commentID != -1) {
	 		if(fileName != null){
				File oldFile = new File(realFolder+"\\"+fileName);
				File newFile = new File(realFolder+"\\"+uidName+".jpg");
				oldFile.renameTo(newFile);
	 		}
		}
 		
		request.setAttribute("num", num);
		request.setAttribute("commentID", commentID);
		
		return new ActionForward("/project/freeComment.jsp", false);
	}

}
