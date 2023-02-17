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
		// mySQL ����
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

	// �α���..
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM user WHERE userID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			if (rs.getString(1).equals(userPassword))
				return 1;// �α��� ����
			else
				return 0;// ��й�ȣ ����ġ
			}
			return -1;// ���̵� ���� ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;// �����ͺ��̽� ����
	}

	// ȸ�� ������ db�� ����
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

	// �α��� üũ
	public int loginCheck(String userID, String userPassword) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int check = -1;// ���̵� ����..

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
					check = 0;// ��й�ȣ ����..!!
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

		String dbPass = "";// �����ͺ��̽��� ����� ��й�ȣ.

		int result = -1;

		try {
			conn = getConnection();

			String SQL = "select userPassword from user where userID= ?";

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPass = rs.getString("userPassword");
				if (dbPass.equals(userPassword)) {// ����Ȯ�� -> true
					pstmt = conn.prepareStatement("delete from user where userID= ?");
					pstmt.setString(1, userID);
					pstmt.executeUpdate();
					result = 1;// ȸ��Ż�� ������..
				} else { // ��й�ȣ ����-->����Ȯ�� ����
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
