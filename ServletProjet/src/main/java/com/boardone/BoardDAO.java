package com.boardone;

import java.sql.*;
import java.util.*;

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

	// �̰����� ���� �Խ��� �۾� ����� �ϳ��� �޼ҵ带 �߰��� �ۼ��ϸ� ��.
	// ���� �����ͺ��̽��� �߰��ϴ� �޼ҵ�
	public void insertArticle(BoardVO article) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();

		int number = 0;
		String strQuery = "";

		try {

			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			if (num != 0) {// 0�� �ƴѰ�쿡�� �亯����.
				strQuery = "update board set step=step+1 where ref = ? and step > ?";

				pstmt = conn.prepareStatement(strQuery);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);

				pstmt.executeUpdate();

				step = step + 1;
				depth = depth + 1;

			} else {// �� ���� ���
				ref = number;
				step = 0;
				depth = 0;
			}
			strQuery = "insert into board(num, writer, email, subject, pass, regdate, ref, step, depth, content, ip) values(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(strQuery);

			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPass());
			pstmt.setTimestamp(5, article.getRegdate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, step);
			pstmt.setInt(8, depth);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());

			pstmt.executeUpdate();

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
	}// end insertArticle
	/*
	 * �� �ۼ��� �����ϰ� ���� list.jsp�� �����̷�Ʈ �ϵ��� �Ǿ� ���� ���� ����� ������ list.jsp�� �ۼ��ؾ��� �� ��ü ����
	 * ������ �����ͼ� ����� ���������.
	 */

	public int getArticleCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = ConnUtil.getConnection();
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
		return x;

	}

	/*
	 * board ���̺����� �����͸� �����ͼ� ������ �޼ҵ带 �߰� List<BoardVO>
	 */
	public List<BoardVO> getArticles() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BoardVO> articleList = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select * from board order by num desc");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<BoardVO>();
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
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
		return articleList;
	}

	/*
	 * list.jsp. ���������� �� ������ ������ �� ������ �� �� �ֵ��� ����.
	 * 
	 * ���� num�� �Ű������� �ؼ� �ϳ��� ���� �����ͼ� ������. �������� �����ͺ��̽����� ������
	 * 
	 * �� �ϳ��� ������ �������� �޼ҵ带 �����ؾ���.
	 */

	public BoardVO getArticle(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("update board set readcount=readcount+1 where num=?");
			pstmt.setInt(1,num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from board where num=?");
			pstmt.setInt(1,num);
			pstmt.executeQuery();
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					
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
		return article;

	}//end Article..
	
	/*
	 * �� ���� ��ư�� ���� ��� updateForm.jsp �������� �̵��ϵ��� ��ũ�� �ɾ���.
	 * 
	 * �� ������ �� ��Ϻ���� �ٸ��� ��ȸ���� ������Ű�� �ʴ´�.
	 * ��ȸ�� ������ �����ϰ� num �� �����ϴ� �۸� �������� �޼ҵ带 �����Ѵ�.
	 */

	public BoardVO updateGetArticle(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			conn = ConnUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from board where num=?");
			pstmt.setInt(1,num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					
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
		return article;
		
		
	}//end updateGetArticle
	
	
	
	public int updateArticle(BoardVO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbpasswd = "";
		String strQuery = "";
		int result = -1;
		
		try {
			
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select pass from board where num=?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
					
					if(rs.next()) {
						dbpasswd = rs.getString("pass");
						
						if(dbpasswd.equals(article.getPass())) {
							
							strQuery = "update board set writer=?,email=?,subject=?,content=? where num=?";
							pstmt = conn.prepareStatement(strQuery);
							pstmt.setString(1, article.getWriter());
							pstmt.setString(2, article.getEmail());
							pstmt.setString(3, article.getSubject());
							pstmt.setString(4, article.getContent());
							pstmt.setInt(5, article.getNum());
							
							pstmt.executeUpdate();
							result = 1;//��������
						}else {
							result = 0;//���� ����
						}
					}
			
			
		}catch (SQLException s1) {
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
	
	
	
	
	
	
	
	
}