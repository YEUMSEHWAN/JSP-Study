package com.city.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.control.ActionForward;
import com.city.model.FreeCommentDAO;
import com.city.model.FreeCommentVO;
import com.city.model.EvaluationDAO;
import com.city.model.EvaluationVO;
import com.city.model.FreeBoardDAO;
import com.city.model.FreeBoardVO;
import com.city.model.MembershipDAO;

public class FreeBoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("loginID");
		
		
			
			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			
				FreeBoardDAO dbPro = FreeBoardDAO.getInstance();
				FreeBoardVO article = dbPro.getArticle(num);
				
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
				
				FreeCommentDAO commentDAO = new FreeCommentDAO();
				ArrayList<FreeCommentVO> list = commentDAO.getList(num);
				
				String commentReal = "C:\\teamproject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Project\\project\\imageSave";
				/* String commentReal = "C:\\Users\\SUCCU\\Desktop\\JSP_STUDY\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TeamProject\\boardone\\img\\uploadImg"; */
				
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
		
		return new ActionForward("/project/freeBoardContent.jsp", false);
	}
}
