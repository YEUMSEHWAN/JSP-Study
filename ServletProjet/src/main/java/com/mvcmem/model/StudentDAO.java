package com.mvcmem.model;

import java.util.*;
import java.sql.*;
import javax.sql.*;//������ �ҽ�

import com.boardone.BoardDAO;

import javax.naming.*;

public class StudentDAO {

	private static StudentDAO instance = null;
	private StudentDAO() {}
	
	public static StudentDAO getInstance() {

		if (instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		return instance;
	}
	
	
	
	private Connection getConnection() {

		Connection conn = null;

		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();

		} catch (NamingException e) {
			System.out.println("Connection ���� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection ���� ����");
			e.printStackTrace();
		}
		return conn;

	}// DB ����

	// ���̵� üũ
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from student where id = ?");

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (!rs.next())
				result = false;

		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}
		}
		return result;
	}// end idCheck

	// zipcode READ-------------------------

	// �����ȣ�� �����ͺ��̽����� �˻��ؼ� Vetor�� ������ �� ������ �ִ� �޼ҵ� ����
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();

		try {
			conn = getConnection();// DB����
			String strQuery = "select * from zipcode where dong like'" + dong + "%'";// �����ۼ�
			pstmt = conn.prepareStatement(strQuery);
			rs = pstmt.executeQuery();// executeQuery()�� update()�� ��� ���� �ʼ�

			while (rs.next()) {
				ZipCodeVO tempZipcode = new ZipCodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));

				vecList.addElement(tempZipcode);
				
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}
		}
		return vecList;
	}
	// ========zipcode READ end======================================

	/*
	 * ������ �����ͺ��̽��� ȸ�������͸� �����ϱ� ���� ����� ����
	 */

	public boolean memberInsert(StudentVO vo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String strQuery = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(strQuery);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());

			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;

		} catch (SQLException s1) {
			s1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}
		}
		return flag;
	}// ----end memberInsert-------------------------------------------------------

	/*
	 * �α��� ��ư�� Ŭ���ϸ� �Է��� ���̵�� ��й�ȣ,���������� �����ͺ��̽��� ����Ǿ��ִ� ���̵�� ��й�ȣ�� ���ؼ� ������ �α��� ����,
	 * �ٸ��� ����ó��. �����ͺ��̽����� ���̵�� ��й�ȣ�� ���Ͽ� �� ����� ���������� �������ִ� �޼ҵ带 ���� 1: �α��� ����, 0:
	 * ��й�ȣ ����, -1:���̵� ����
	 */

	public int loginCheck(String id, String pass) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int check = -1;// ���̵� ����.

		try {
			conn = getConnection();

			String strQuery = "select pass from student where id =?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPass = rs.getString("pass");
				if (pass.equals(dbPass))
					check = 1;
				else
					check = 0;// ��й�ȣ ����
			}

		} catch (SQLException s1) {
			s1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}
		}
		return check;

	}// ----end loginCheck-----------------------------------

	public StudentVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO vo = null;

		try {
			conn = getConnection();
			String strQuery = "select * from student where id =?";
			pstmt = conn.prepareStatement(strQuery);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {// ���̵� �ش��ϴ� ȸ���� �����Ѵٸ�..
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));

			}

		} catch (SQLException s1) {
			s1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}
		}
		return vo;
	}

	// �������� ��ư�� Ŭ������ ��� �����ͺ��̽��� update �� �����ؾ���.
	// �������� ó���� �� �� �ִ� �޼ҵ� ����
	
	public void updateMember(StudentVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String strQuery = "update student set pass = ?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?,address1=?,address2=? where id=?";

			pstmt = conn.prepareStatement(strQuery);

			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());
			
			pstmt.executeUpdate();

		} catch (SQLException s1) {
			s1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException s2) {}
			if (conn != null) try {conn.close();} catch (SQLException s3) {}
		}
}//end updateMember
	
	/*
	 * ȸ��Ż�� ��ư�� Ŭ���ϸ� �����ͺ��̽��� ȸ�������Ͱ� �����Ǿ����
	 * �����ͺ��̽����� ����ó������ �޼ҵ� ����
	 */
	
	public int deleteMember(String id, String pass) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPass = "";//�����ͺ��̽��� ����� ��й�ȣ�� �ǹ���
		
		int result = -1;
		
		try {
			
			conn = getConnection();
			
			String strQuery = "select pass from student where id=?";
			
			pstmt = conn.prepareStatement(strQuery);
			
			pstmt.setString(1, id);
			
			rs = 
					pstmt.executeQuery();
			
			if(rs.next()) {
				dbPass = rs.getString("pass");
				
				if(dbPass.equals(pass)) {//����Ȯ��==> true
					pstmt = conn.prepareStatement("delete from student where id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1;//ȸ��Ż�� ����
				}else {//��й�ȣ ����-->����Ȯ�� ����
					result = 0;
				}
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}
		}
		return result;
		}	
	}

