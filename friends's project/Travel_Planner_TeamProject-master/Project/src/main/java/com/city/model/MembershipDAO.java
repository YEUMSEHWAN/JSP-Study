package com.city.model;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class MembershipDAO {
		
	private static MembershipDAO instance = null;
	
	private MembershipDAO() { }
 		
	public static MembershipDAO getInstance() {
		
	/*
	 * data의 thread-safe 를 하기 위해 자바에서는 synchronized 키워드를 제공해 
	 * 스레드간 동기화를 시켜 data의 thread-safe를 가능케합니다.
	 */
		
		if(instance == null) {
			synchronized (MembershipDAO.class) {
				instance = new MembershipDAO();			
		}		
	}
		return instance;
}
	private Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		} catch (NamingException ne) {
			System.out.println("Connection　실패");
			ne.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}// 기본 DB연결

	
	//db에서 IDcheck 
	public boolean idCheck(String id) {
	boolean result = true;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		conn = getConnection();
			                //쿼리문 바인딩 함수 사용
		pstmt = conn.prepareStatement("select * from member where id = ?");
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		if(!rs.next()) result = false;
		
		
	} catch (SQLException s1) {
		s1.printStackTrace();
		
		
	} finally {
		if(rs != null) try{rs.close();}catch(SQLException s1){}
		if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
		if(conn != null) try{conn.close();}catch(SQLException s3){}		
	}
	
	return result;
	
} // end of idCheck
	
//	닉네임 중복체크 하기 위해 DB안에 있는지 비교
	public boolean nickCheck(String nick) {
		
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			
				conn = getConnection();
														
				pstmt = conn.prepareStatement("select * from member where nick = ?");
				
				pstmt.setString(1, nick);
				 	
				rs = pstmt.executeQuery();
				if(!rs.next()) result = false;
				
				
		} catch (SQLException s1) {
			s1.printStackTrace();
			
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return result;
	}//end of nickCheck 
	
	public String getNick(String id) {
		
		String result = "";
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			
				conn = getConnection();
														
				pstmt = conn.prepareStatement("select * from member where id = ?");
				
				pstmt.setString(1, id);
				 	
				rs = pstmt.executeQuery();
				if(rs.next()) result = rs.getString("nick");
				
				
		} catch (SQLException s1) {
			s1.printStackTrace();
			
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return result;
	}//end of nickCheck 

	//DB에 회원데이터 저장
	public boolean memberInsert(MembershipVO vo) {
		
		boolean flag = false; //true과 되면 성공
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
		
			String strQuery = "insert into member values(?,?,?,?)";
			
			pstmt = conn.prepareStatement(strQuery);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getEmail());
		
			int count = pstmt.executeUpdate();
			if(count > 0) flag = true;
		
		}catch(SQLException s1) {	
			s1.printStackTrace();
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return flag;
	}// end of memberInsert
	
	public int loginCheck(String id, String pass) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int check = -1; //초기는 아이디 없음으로 설정
		
		try {
			conn = getConnection();
			
			String strQuery = "select pass from member where id =?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getString("pass"); //비밀번호를 가져와 dbpass에 저장
				if(pass.equals(dbPass)) check =1; // 파라미터값과 동일 하면 로그인 성공
				else check = 0; // 아닐 경우 아이디는 맞지만 비번이 맞지 않으니 실패
			}
		}catch(SQLException s1) {	
			s1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return check;
	} // end of loginCheck
	
	//정보수정 
	public MembershipVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;  
		ResultSet rs = null;
		
		
		MembershipVO vo = null;
		
		try {
			conn = getConnection();
			String strQuery = "select * from member where id=?";
			pstmt = conn.prepareStatement(strQuery);
			
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
		
		if(rs.next()) {
			vo = new MembershipVO();
			
			vo.setId(rs.getString("id"));
			vo.setPass(rs.getString("pass"));
			vo.setNick(rs.getString("nick"));
			vo.setEmail(rs.getString("email"));
		
		}
	
		}catch(SQLException s1) {	
			s1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return vo;
		
	}//end of getMember
	
	//회원정보수정 완료
	public void updateMember(MembershipVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try { 
			conn = getConnection();
			
		String strQuery = "update member set pass =? where id=?";
		pstmt = conn.prepareStatement(strQuery);
			//비밀번호만 바꿀꺼임
		pstmt.setString(1, vo.getPass());
		pstmt.setString(2, vo.getId());
		
		pstmt.executeUpdate();
			
			
			
		}  catch(SQLException s1) {	
			s1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		
	}//end of updateMember
	
	
	//회원탈퇴
	
	  public int deleteMember(String id, String pass) { 
	  
      Connection conn = null;
	  PreparedStatement pstmt = null; 
	  ResultSet rs = null;
	  
	  String dbPass="";
	  
	  int result = -1; 
	  
	  try {
		  conn = getConnection();
		  
		  String strQuery = "select pass from member where id=?";
		  
		  pstmt = conn.prepareStatement(strQuery);
		  pstmt.setString(1, id);
		  rs = pstmt.executeQuery();
		  //아이디를 조회해서 비밀번호가 맞으면 탈퇴시킬수있게
		  
		  if(rs.next()) {
			 
			  dbPass = rs.getString("pass");
			  
			 if(dbPass.equals(pass)) {
				 
			  pstmt = conn.prepareStatement("delete from member where id =?");
			  pstmt.setString(1, id);
			  pstmt.executeUpdate();
			  
			  result = 1; //회원탈퇴 OK
		  } else { //비밀번호가 오류일때 조건
			  result = 0;
		  }
		 }
		  
	  	}catch(SQLException s1) {	
			s1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
		  if(rs != null) try{rs.close();}catch(SQLException s1){}
		  if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
		  if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
	  
	  
	  return result; 
	  }//end of deleteMember

	  //2022-09-26 비밀번호찾기
	  public String findpw(String id, String email) {
		  Connection conn = null;
		  PreparedStatement pstmt = null; 
		  ResultSet rs = null;
		  
		  String fpw = "";
		  
			try {
				conn = getConnection();
				String strQuery = "select * from member where id=? and email=?"; 
				pstmt = conn.prepareStatement(strQuery);
				
				pstmt.setString(1, id);
				pstmt.setString(2, email);
				
				rs=pstmt.executeQuery();
			
			if(rs.next()) {
				fpw = rs.getString("pass");
			
			}
		
			}catch(SQLException s1) {	
				s1.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try{rs.close();}catch(SQLException s1){}
				if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
				if(conn != null) try{conn.close();}catch(SQLException s3){}		
			}
			
			return fpw;
	  }
	  
	  
	  
	  
	  
	  
} //end of DAO
	

