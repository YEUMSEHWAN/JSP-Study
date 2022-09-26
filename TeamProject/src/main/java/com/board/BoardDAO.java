package com.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	private static BoardDAO instance = null;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {

		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

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

	// ���� �����ͺ��̽� �߰�.
	public void insertArticle(BoardVO article) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();

		int number = 0;
		String SQL = "";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			if (num != 0) {// �亯 ��
				SQL = "update board set step=step+1 where ref=? and step > ?";

				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);

				pstmt.executeUpdate();

				step = step + 1;
				depth = depth + 1;
			} else {// ������ ���..
				ref = number;
				step = 0;
				depth = 0;
			}
			SQL = "insert into board(num, writer, email, subject, userPassword, regdate, ref, step, depth, content)"
					+ " values(board_+seq.nextval,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getUserPassword());
			pstmt.setTimestamp(5, article.getRegdate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, step);
			pstmt.setInt(8, depth);
			pstmt.setString(9, article.getContent());
			pstmt.setString(1, article.getWriter());

			pstmt.executeUpdate();
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sq1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sq2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sq3) {
				}
		}
	} // end insertArticle

	public int getArticleCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return x;
	}// end getArticleCount

	/*
	 * board���̺��� ������ �����ͼ� ������ �޼ҵ� �߰� List<BoardVO>
	 * 
	 * start : ���۹�ȣ end : ����ȣ
	 */
	public List<BoardVO> getArticles(int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BoardVO> articleList = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (" + "select rownum rnum, num, writer, email, subject, "
					+ "userPassword, readcount, ref, step, depth, regdate, content from("
					+ "select * from board order by ref desc, step asc)) " + "where rnum >= ? and rnum <= ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<BoardVO>(end - start + 1);

				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setUserPassword("userPassword");
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setContent(rs.getString("content"));
				} while (rs.next());
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return articleList;
	}// end getArticles

	/*
	 * list.jsp ���������� �� ������ ������ �� ������ ���� �ֵ��� ����
	 * 
	 * ���� num�� �Ű������� �ؼ� �ϳ��� ���� �����ͼ� ������ �������� �����ͺ��̽����� ��������
	 * 
	 * �� �ϳ��� ������ �������� �޼ҵ� ����
	 */
	public BoardVO getArticle(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;

		try {

			conn = getConnection();
			pstmt = conn.prepareStatement("update board set readcount=readcount+1 where num =?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from board where num =?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setUserPassword("userPassword");
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setContent(rs.getString("content"));

			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return article;
	}// end getArticle

	/*
	 * �� ���� ��ư�� ���� ��� updateForm.jsp �������� �̵��ϵ��� ��ũ.
	 * 
	 * �� ������ �� ��Ϻ���� �ٸ��� ��ȸ�� ����x
	 * 
	 * ��ȸ�� ������ �����ϰ� num�� �ش��ϴ� �۸� �������� �޼ҵ� ����
	 */
	public BoardVO updateGetArticle(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from board where num =?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setUserPassword("userPassword");
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setContent(rs.getString("content"));
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return article;
	}// end updateGetArticle

	public int updateArticle(BoardVO article) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPassword = "";
		String SQL = "";

		int result = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select userPassword from board where num =?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbPassword = rs.getString("userPassword");

				if (dbPassword.equals(article.getUserPassword())) {

					SQL = "update board set writer=?, email=?, subject=?, content=? where num=?";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());

					pstmt.executeUpdate();
					result = 1;// ���� ����
				} else {
					result = 0;// ��������
				}
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return result;
	}// end updateArticle

	/*
	 * �� ���� ó�� �� ���� ������ ��й�ȣ�� �Է��ϰ� ������ �����ϸ� �����ͺ��̽����� ��й�ȣ�� �˻��ؼ� ��й�ȣ�� ��ġ�ϸ� ����ó��,
	 * ��ġ���� ������ ��й�ȣ ����
	 */
	public int deleteArticle(int num, String userPassword) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPassword = "";

		int result = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select userPassword from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbPassword = rs.getString("userPassword");

				if (dbPassword.equals(userPassword)) {
					pstmt = conn.prepareStatement("delete from board where num=?");
					pstmt.setInt(1, num);

					pstmt.executeUpdate();
					result = 1;// ���� ����
				} else {
					result = 0;// ���� ����
				}
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return result;
	}// end deleteArticle..

	// �˻��� ������ � �ִ����� ��ȯ�ϴ� ���(what : ���ǰ˻�, content : �˻�����)
	public int getArticleCount(String what, String content) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select conut(*) from board where " + what + " like '%" + content + "%'");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return x;
	}// end getArticleCount

//�˻��� ������ ����Ʈ�� �޾ƿ�(what:�˻�����, content:�˻�����,���۹�ȣ, ����ȣ)���۹�ȣ�� ����ȣ�� ������ó���� ����
	public List<BoardVO> getArticles(String what, String content, int start, int end) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BoardVO> articleList = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from (" + "select rownum rnum, num, writer, email, subject, "
					+ "userPassword, readcount, ref, step, depth,regdate, content from(" + "select * from board where "
					+ what + " like '%" + content + "%' order by ref desc, step asc)) "
					+ "where rnum >= ? and rnum <= ?");

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				articleList = new ArrayList<BoardVO>(end - start + 1);

				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setUserPassword("userPassword");
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setContent(rs.getString("content"));
					articleList.add(article);
				} while (rs.next());

			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
		}
		return articleList;

	}// end getArticles

}