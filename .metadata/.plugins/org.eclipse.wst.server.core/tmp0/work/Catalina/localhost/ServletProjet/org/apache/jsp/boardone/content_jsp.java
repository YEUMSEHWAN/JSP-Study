/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.81
 * Generated at: 2022-08-17 08:47:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.boardone;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.boardone.BoardDAO;
import com.boardone.BoardVO;
import java.text.SimpleDateFormat;

public final class content_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/boardone/view/color.jsp", Long.valueOf(1660632893557L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.boardone.BoardDAO");
    _jspx_imports_classes.add("com.boardone.BoardVO");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

    String bodyback_c = "#e0ffff";
    String back_c = "#8fbc8f";
    String title_c = "#5f9ea0";
    String value_c = "#b0e0e6";
    String bar= "#778899";
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>게시판</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("</head>\r\n");


int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

try{
	BoardDAO dbPro = BoardDAO.getInstance();
	BoardVO article = dbPro.getArticle(num);
	
	int ref = article.getRef();
	int step = article.getStep();
	int depth = article.getDepth();


      out.write("\r\n");
      out.write("\r\n");
      out.write("<body bgcolor = \"");
      out.print(bodyback_c);
      out.write("\">\r\n");
      out.write("<div align = \"center\"><b>글 내용 상세 보기</b>\r\n");
      out.write("<br><br>\r\n");
      out.write("<form>\r\n");
      out.write("  <table width = \"500\" border = \"1\" cellpadding =\"0\" cellspacing = \"0\" bgcolor = \"");
      out.print( value_c );
      out.write("\" align = \"center\">\r\n");
      out.write("         <tr height = \"30\"> <!-- 글 번호 하고 조회수가 나와야됨 -->\r\n");
      out.write("            <td align = \"center\" width =\"125\" bgcolor=\"");
      out.print(value_c);
      out.write("\">글번호</td>\r\n");
      out.write("            <td align = \"center\" width =\"125\">\r\n");
      out.write("            ");
      out.print( article.getNum() );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("            <td align = \"center\" width =\"125\" bgcolor=\"");
      out.print(value_c);
      out.write("\">조회수</td>\r\n");
      out.write("            <td align = \"center\" width =\"125\">\r\n");
      out.write("            ");
      out.print( article.getReadcount() );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         \r\n");
      out.write("         <!--작성자와 작성일을  -->\r\n");
      out.write("         <tr height = \"30\"> <!-- 글 번호 하고 조회수가 나와야됨 -->\r\n");
      out.write("            <td align = \"center\" width =\"125\" bgcolor=\"");
      out.print(value_c);
      out.write("\">작성자</td>\r\n");
      out.write("            <td align = \"center\" width =\"125\">\r\n");
      out.write("            ");
      out.print( article.getWriter() );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("            <td align = \"center\" width =\"125\" bgcolor=\"");
      out.print(value_c);
      out.write("\">작성일</td>\r\n");
      out.write("            <td align = \"center\" width =\"125\">\r\n");
      out.write("            ");
      out.print( sdf.format(article.getRegdate()) );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>   \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <!--글 제목  글 내용 출력-->\r\n");
      out.write("         <tr height = \"30\">\r\n");
      out.write("            <td align = \"center\" width =\"125\" bgcolor=\"");
      out.print(value_c);
      out.write("\">글제목</td>\r\n");
      out.write("            <td align = \"center\" width =\"375\" colspan=\"3\">\r\n");
      out.write("            ");
      out.print( article.getSubject() );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         \r\n");
      out.write("         <tr height = \"30\">\r\n");
      out.write("            <td align = \"center\" width =\"125\" bgcolor=\"");
      out.print(value_c);
      out.write("\">글내용</td>\r\n");
      out.write("            <td align = \"left\" width =\"375\" colspan=\"3\">\r\n");
      out.write("            <pre>");
      out.print( article.getContent() );
      out.write("</pre> <!--pre태그 미리 정의된 형식의 텍스트를 정의할 떄 사용-->\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>   \r\n");
      out.write("            \r\n");
      out.write("               <!-- -->\r\n");
      out.write("         <tr height = \"30\">\r\n");
      out.write("            <td align = \"right\" bgcolor=\"");
      out.print(value_c);
      out.write("\" colspan=\"4\">\r\n");
      out.write("                <input type = \"button\" value = \"글 수정\" onclick =\"document.location.href='updateForm.jsp?num=");
      out.print(article.getNum());
      out.write("&pageNum=");
      out.print(pageNum);
      out.write("'\">\r\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                \r\n");
      out.write("               \r\n");
      out.write("                <input type = \"button\" value = \"글 삭제\" onclick =\"document.location.href='deleteForm.jsp?num=");
      out.print(article.getNum());
      out.write("&pageNum=");
      out.print(pageNum);
      out.write("'\">\r\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                \r\n");
      out.write("                <input type = \"button\" value = \"글 목록\" onclick =\"document.location.href='list.jsp?pageNum=");
      out.print(pageNum);
      out.write("'\">\r\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>   \r\n");
      out.write("      </table>\r\n");
}catch(Exception e){} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
