package mvc;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.collections4.map.HashedMap;

import java.util.*;




public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//��ɾ�� ��ɾ�ó�� Ŭ������ ������ �ҷ��� ������.
	private Map<String, Object> commandMap = 
			new HashMap<String, Object>();
	
	//��ɾ�� ó�� Ŭ������ ���εǾ� �ִ� Command.properties ������ �о�ͼ�
	//Map ��ü�� commandMap�� �����Ѵ�.
	
	
	
	public void init(ServletConfig config) throws ServletException {
	
		//web.xml ���Ͽ��� propertyConfig �� �ش�Ǵ� init-param�ǰ��� �о��
		String props = config.getInitParameter("propertyConfig");
		
		//��ɾ�� ó��Ŭ������ ���������� ������ Properties ��ü�� ������
		Properties pr = new Properties();
		
		String path = config.getServletContext().getRealPath("/WEB-INF");
		FileInputStream f = null;
		
		try {
		//Command.properties ������ ������ �о��
			f= new FileInputStream(new File(path,props));
			//Command.properties ������ ������ Properties ��ü�� ������
			pr.load(f);
			
		} catch (IOException e) {
			throw new ServletException(e);
		}finally {
			if( f != null)try {f.close();}catch(IOException ex) {}
		}
		
		//Iterator ��ü�� �̿��ؼ� ���� ������ Ű���� �о��.
		//Iterator ��ü ����
		Iterator<Object> keyIter = pr.keySet().iterator();//keyset()��������, �ߺ���� x
		
		while(keyIter.hasNext()) {
			String command =(String)keyIter.next();
			String className = pr.getProperty(command);
			
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance(); 
				// �ش� Ŭ������ ��ü�� ������
				
				//Map ��ü�� commandMap�� ��ü�� ������
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			}catch(InstantiationException e) {
				throw new ServletException(e);
			}catch(IllegalAccessException e) {
				throw new ServletException(e);
			}	
		}
	}

	//���� get���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	requestPro(request, response);
	
	}

	//���� post���
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	requestPro(request, response);
	
	}
	//������� ��û�� �м��ؼ� �ش� �۾��� ó���ϴ� �޼ҵ�
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String view = null;
		CommandProcess com = null;
		
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath())==0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandProcess)commandMap.get(command);
			view = com.requestPro(request, response);
			
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	
	}
}
