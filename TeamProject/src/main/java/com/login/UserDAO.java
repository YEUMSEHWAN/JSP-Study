package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;
import com.mysql.cj.exceptions.RSAException;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Connection getConnection() {
		// mySQL 접속
		Connection conn = null;
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "tiger";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 로그인..
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM user WHERE userID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			if (rs.getString(1).equals(userPassword))
				return 1;// 로그인 성공
			else
				return 0;// 비밀번호 불일치
			}
			return -1;// 아이디가 없을 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;// 데이터베이스 오류
	}

	// 회원 정보를 db에 저장
	public boolean memberInsert(UserVO vo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String SQL = "insert into user values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);

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
		// memberInsert end----------------------------

	}

	// userID Check
	public boolean idCheck(String userID) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from user where userID = ?");

			pstmt.setString(1, userID);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				result = false;
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
					s2.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s3) {
				}

		}
		return result;
	} // userID Check end------------

	// 로그인 체크
	public int loginCheck(String userID, String userPassword) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int check = -1;// 아이디 없음..

		try {
			conn = getConnection();

			String SQL = "select userPassword from user where userID =?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPass = rs.getString("userPassword");
				if (userPassword.equals(dbPass))
					check = 1;
				else
					check = 0;// 비밀번호 오류..!!
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

	}// login check end....

	public UserVO getMember(String userID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO vo = null;

		try {
			conn = getConnection();
			String SQL = "select * from user where userID =?";
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new UserVO();
				vo.setuserID(rs.getString("userID"));
				vo.setuserPassword(rs.getString("userPassword"));
				vo.setuserEmail(rs.getString("userEmail"));
				vo.setuserName(rs.getString("Username"));
				vo.setuserJumin(rs.getString("Userjumin"));
				vo.setuserAlchol(rs.getString("Useralchol"));

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

	public void updateMember(UserVO vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String SQL = "update user set userPassword=?, userEmail=?, userName=?, userAlchol=? where userID=?";
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, vo.getuserPassword());
			pstmt.setString(2, vo.getuserEmail());
			pstmt.setString(3, vo.getuserName());
			pstmt.setString(4, vo.getuserAlchol());
			pstmt.setString(5, vo.getuserID());

			pstmt.executeUpdate();

		} catch (SQLException s1) {
			s1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		} // end updateMember
	}

	public int deleteMember(String userID, String userPassword) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPass = "";// 데이터베이스에 저장된 비밀번호.

		int result = -1;

		try {
			conn = getConnection();

			String SQL = "select userPassword from user where userID= ?";

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPass = rs.getString("userPassword");
				if (dbPass.equals(userPassword)) {// 본인확인 -> true
					pstmt = conn.prepareStatement("delete from user where userID= ?");
					pstmt.setString(1, userID);
					pstmt.executeUpdate();
					result = 1;// 회원탈퇴 성공시..
				} else { // 비밀번호 오류-->본인확인 실패
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
