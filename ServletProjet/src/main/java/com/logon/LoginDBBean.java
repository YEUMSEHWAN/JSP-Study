package com.logon;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;


public class LoginDBBean {

	private static LoginDBBean instance = new LoginDBBean();

	public static LoginDBBean getInstance() {
		return instance;
	}
	
	private LoginDBBean() { }
	
	private Connection getConnection() throws Exception{
		
		Context initContext = new InitialContext();
		DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
		
		
		return ds.getConnection();
		
	}
	
	
	
	//사용자 인증(아이디,비밀번호)
	public int userCheck (String id, String passwd) throws Exception{
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String dbpasswd = "";

	int check = -1;// 아이디 없음.

	try {
		conn = getConnection();

		String strQuery = "select pass from tempmember where id =?";
		pstmt = conn.prepareStatement(strQuery);
		pstmt.setString(1, id);

		rs = pstmt.executeQuery();
		if (rs.next()) {
			dbpasswd = rs.getString("passwd");
			if (dbpasswd.equals(passwd)) check = 1;//회원 인증 성공
			else check = 0;// 비밀번호 오류
		
		}else
			check =-1;//해당 아이디 존재하지 않음.
		

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

	}
	
	
}
