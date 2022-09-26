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

	// 글을 데이터베이스 추가.
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

			if (num != 0) {// 답변 글
				SQL = "update board set step=step+1 where ref=? and step > ?";

				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);

				pstmt.executeUpdate();

				step = step + 1;
				depth = depth + 1;
			} else {// 새글일 경우..
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
	 * board테이블에서 데이터 가져와서 보여줄 메소드 추가 List<BoardVO>
	 * 
	 * start : 시작번호 end : 끝번호
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
	 * list.jsp 페이지에서 글 제목을 누르면 글 내용을 볼수 있도록 구현
	 * 
	 * 글을 num을 매개변수로 해서 하나의 글을 가져와서 보여줌 상세정보를 데이터베이스에서 가져오기
	 * 
	 * 글 하나의 정보를 가져오는 메소드 구현
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
	 * 글 수정 버튼을 누를 경우 updateForm.jsp 페이지로 이동하도록 링크.
	 * 
	 * 글 수정시 글 목록보기와 다르게 조회수 증가x
	 * 
	 * 조회수 증가를 제외하고 num에 해당하는 글만 가져오는 메소드 구현
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
					result = 1;// 수정 성공
				} else {
					result = 0;// 수정실패
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
	 * 글 삭제 처리 글 삭제 폼에서 비밀번호를 입력하고 삭제를 수행하면 데이터베이스에서 비밀번호를 검색해서 비밀번호가 일치하면 삭제처리,
	 * 일치하지 않으면 비밀번호 오류
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
					result = 1;// 삭제 성공
				} else {
					result = 0;// 삭제 실패
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

	// 검색한 내용이 몇개 있는지를 반환하는 기능(what : 조건검색, content : 검색내용)
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

//검색한 내용을 리스트로 받아옴(what:검색조건, content:검색내용,시작번호, 끝번호)시작번호와 끝번호는 페이지처리를 위해
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