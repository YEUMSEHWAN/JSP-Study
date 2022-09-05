package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.*;
import com.mysql.cj.exceptions.RSAException;

public class UserDAO {

	// DB 연결
	private Connection getConnection() {
		Connection conn = null;
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "scott";
			String dbPassword = "tiger";

			// mySQL에 접속할수 있게 해주는 매개체
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	// 아이디 체크
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

	public boolean memberInsert(UserVO vo) {//db연결
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = getConnection();
			
			pstmt = conn.createStatement();
			
			 rs = pstmt.executeQuery("insert into user values(?,?,?,?,?,?)");
			
			// mySQL에 접속할수 있게 해주는 매개체

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
	 * 로그인 버튼을 클릭하면 입력한 ID와 Password,개인정보를 데이터베이스에 저장되어있는 정보와 비교하여
	 * 같으면 로그인 성공, 다르면 실패처리. 처리 결과를 정수형으로 리턴해주는 메소드 구현
	 * 1:로그인 성공, 0 : 비밀번호 오류, -1 : 아이디가 없음.
	 */
	
	public int loginCheck(String userID, String userPassword) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int check = -1;//아이디가 없을 경우
		
		try {
			conn = getConnection();
			
			String strQuery = "select pass from user where id = ?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpass = rs.getString("pass");
				if(userPassword.equals(dbpass))
					check = 1;//로그인 성공
				else
					check = 0; //비밀번호 오류
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
