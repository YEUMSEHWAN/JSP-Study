package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.*;
import com.mysql.cj.exceptions.RSAException;

public class UserDAO {

	// DB ����
	private Connection getConnection() {
		Connection conn = null;
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "scott";
			String dbPassword = "tiger";

			// mySQL�� �����Ҽ� �ְ� ���ִ� �Ű�ü
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	// ���̵� üũ
	public boolean idcheck(String userID) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from user where userID = ?");

			pstmt.setString(1, userID);

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
	}

	public boolean memberInsert(UserVO vo) {//db����
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = getConnection();
			
			pstmt = conn.createStatement();
			
			 rs = pstmt.executeQuery("insert into user values(?,?,?,?,?,?)");
			
			// mySQL�� �����Ҽ� �ְ� ���ִ� �Ű�ü

			pstmt.setString(1, vo.getuserID());
			pstmt.setString(2, vo.getuserPassword());
			pstmt.setString(3, vo.getuserEmail());
			pstmt.setString(4, vo.getuserName());
			pstmt.setString(5, vo.getuserJumin());
			pstmt.setString(6, vo.getuserAlchol());

			int count = pstmt.executeUpdate();

			if (count > 0)
				flag = true;

		} catch (SQLException s1) {
			s1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return flag;
	}// ------------------end memberInsert---------------------------------

	/*
	 * �α��� ��ư�� Ŭ���ϸ� �Է��� ID�� Password,���������� �����ͺ��̽��� ����Ǿ��ִ� ������ ���Ͽ�
	 * ������ �α��� ����, �ٸ��� ����ó��. ó�� ����� ���������� �������ִ� �޼ҵ� ����
	 * 1:�α��� ����, 0 : ��й�ȣ ����, -1 : ���̵� ����.
	 */
	
	public int loginCheck(String userID, String userPassword) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int check = -1;//���̵� ���� ���
		
		try {
			conn = getConnection();
			
			String strQuery = "select pass from user where id = ?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpass = rs.getString("pass");
				if(userPassword.equals(dbpass))
					check = 1;//�α��� ����
				else
					check = 0; //��й�ȣ ����
			}
			
		} catch (SQLException s1) {
			s1.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s2) {
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}
		}
		return check;
		
		
	}
	
	
}
