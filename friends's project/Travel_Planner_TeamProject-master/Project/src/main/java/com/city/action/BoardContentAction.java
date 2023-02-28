package com.city.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.BoardDAO;
import com.city.model.BoardVO;
import com.city.model.CommentDAO;
import com.city.model.CommentVO;
import com.city.model.EvaluationDAO;
import com.city.model.EvaluationVO;
import com.city.model.MembershipDAO;

public class BoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		
		
			
			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			
				BoardDAO dbPro = BoardDAO.getInstance();
				BoardVO article = dbPro.getArticle(num);
				
				EvaluationDAO evaDAO = new EvaluationDAO();
				int gechuCnt = evaDAO.countGechu(num);
				
				MembershipDAO dao  = MembershipDAO.getInstance();
				
				int gechu = 0;
				int bichu = 0;
				ArrayList<EvaluationVO> listEva = evaDAO.getList(num);
				for(int i=0; i<listEva.size(); i++){
					gechu = gechu + listEva.get(i).getGechu();
					bichu = bichu + listEva.get(i).getBichu();
				}
				
				CommentDAO commentDAO = new CommentDAO();
				ArrayList<CommentVO> list = commentDAO.getList(num);
				
				// project(imageSave Æú´õ ¸¸µé¾îÁà¾ßµÊ
				String commentReal = "C:\\teamproject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project\\project\\imageSave";
				
				String real = "C:\\teamproject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project\\project\\imageSave";
				File viewFile = new File(real+"\\"+article.getImageUID()+".jpg");
				
				request.setAttribute("num", num);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("article", article);
				request.setAttribute("gechuCnt", gechuCnt);
				request.setAttribute("real", real);
				request.setAttribute("viewFile", viewFile);
				request.setAttribute("gechu", gechu);
				request.setAttribute("bichu", bichu);
				request.setAttribute("list", list);
				request.setAttribute("dao", dao);
		
		return new ActionForward("/project/boardContent.jsp", false);
	}

}
