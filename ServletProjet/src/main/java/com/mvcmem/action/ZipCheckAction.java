package com.mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcmem.control.ActionForward;
import com.mvcmem.model.StudentDAO;
import com.mvcmem.model.ZipCodeVO;
import java.util.*;


public class ZipCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("utf-8");
		
		
		StudentDAO dao = StudentDAO.getInstance();
		
		String check = request.getParameter("check");//<--��ũ��Ʈ�� ó��
		String dong = request.getParameter("dong");

		//�Ķ���� ���� zipcodeRead()�޼ҵ��� �Ű� ������ ����
		Vector<ZipCodeVO> zipcodeList = dao.zipcodeRead(dong);

		int totalList = zipcodeList.size();
		System.out.println("�˻� ���� " + totalList);
		
		request.setAttribute("check", check);
		request.setAttribute("dong", dong);
		request.setAttribute("zipcodeList", zipcodeList);
		request.setAttribute("totalList", totalList);
		
		
		
		
		return new ActionForward("/mvcmem/zipCheck.jsp", false);
	}

}
