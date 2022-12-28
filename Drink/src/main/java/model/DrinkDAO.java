package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DrinkDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//데이터 베이스에 연결 메소드
	public void getCon() {
		try {
			Context initctx = new InitialContext();
			
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con = ds.getConnection();//커넥션연결 해주는 메소드
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//전체 게시글의 갯수를 리턴하는 메소드
		public int getAllCount() {
			
			int count = 0;
			
			getCon();
			try {
				//쿼리준비
				String sql = "select count(*) from drink";
				pstmt = con.prepareStatement(sql);
				//쿼리 실행 후 결과를 리턴
				rs = pstmt.executeQuery();
				if(rs.next()) {//데이터가 있다면
					count = rs.getInt(1);
				}
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		
		public Vector<DrinkBean> getAllDrink(int startRow, int endRow){
			
			Vector<DrinkBean> v = new Vector<>();
			
			getCon();
			try {
				//쿼리 작성
				String sql = "select * from (select A.*, Rownum Rnum from (select * from drink order by no desc)A) where Rnum >= ? and Rnum <= ?";
				
				//쿼리 실행할 객체 선언
				pstmt = con.prepareStatement(sql);
				//?값을 대입
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					//데이터를 패키징(가방 = Boardbean 클래스를 이용)해줌
					DrinkBean bean = new DrinkBean();
					bean.setNo(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setAlchol(rs.getInt(3));
					bean.setOrigin(rs.getString(4));
					bean.setImg(rs.getString(5));
					bean.setInfo(rs.getString(6));
					bean.setMaterial(rs.getString(7));
					bean.setFood(rs.getString(8));
					bean.setKind(rs.getInt(9));
					//패키징한 데이터를 백터에 저장
					v.add(bean);
					
				}
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return v;
		}
		
		
public Vector<DrinkBean> getTakDrink(int startRow, int endRow){
			
			Vector<DrinkBean> v = new Vector<>();
			
			getCon();
			try {
				//쿼리 작성
				String sql = "select * from (select A.*, Rownum Rnum from (select * from drink where kind = 1 order by no desc)A) where Rnum >= ? and Rnum <= ?";
				
				//쿼리 실행할 객체 선언
				pstmt = con.prepareStatement(sql);
				//?값을 대입
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					//데이터를 패키징(가방 = Boardbean 클래스를 이용)해줌
					DrinkBean bean = new DrinkBean();
					bean.setNo(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setAlchol(rs.getInt(3));
					bean.setOrigin(rs.getString(4));
					bean.setImg(rs.getString(5));
					bean.setInfo(rs.getString(6));
					bean.setMaterial(rs.getString(7));
					bean.setFood(rs.getString(8));
					bean.setKind(rs.getInt(9));
					//패키징한 데이터를 백터에 저장
					v.add(bean);
					
				}
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return v;
		}


public Vector<DrinkBean> getYakDrink(int startRow, int endRow){
	
	Vector<DrinkBean> v = new Vector<>();
	
	getCon();
	try {
		//쿼리 작성
		String sql = "select * from (select A.*, Rownum Rnum from (select * from drink where kind = 2 order by no desc)A) where Rnum >= ? and Rnum <= ?";
		
		//쿼리 실행할 객체 선언
		pstmt = con.prepareStatement(sql);
		//?값을 대입
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			//데이터를 패키징(가방 = Boardbean 클래스를 이용)해줌
			DrinkBean bean = new DrinkBean();
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAlchol(rs.getInt(3));
			bean.setOrigin(rs.getString(4));
			bean.setImg(rs.getString(5));
			bean.setInfo(rs.getString(6));
			bean.setMaterial(rs.getString(7));
			bean.setFood(rs.getString(8));
			bean.setKind(rs.getInt(9));
			//패키징한 데이터를 백터에 저장
			v.add(bean);
			
		}
		con.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return v;
}



public Vector<DrinkBean> getGaDrink(int startRow, int endRow){
	
	Vector<DrinkBean> v = new Vector<>();
	
	getCon();
	try {
		//쿼리 작성
		String sql = "select * from (select A.*, Rownum Rnum from (select * from drink where kind = 3 order by no desc)A) where Rnum >= ? and Rnum <= ?";
		
		//쿼리 실행할 객체 선언
		pstmt = con.prepareStatement(sql);
		//?값을 대입
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			//데이터를 패키징(가방 = Boardbean 클래스를 이용)해줌
			DrinkBean bean = new DrinkBean();
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAlchol(rs.getInt(3));
			bean.setOrigin(rs.getString(4));
			bean.setImg(rs.getString(5));
			bean.setInfo(rs.getString(6));
			bean.setMaterial(rs.getString(7));
			bean.setFood(rs.getString(8));
			bean.setKind(rs.getInt(9));
			//패키징한 데이터를 백터에 저장
			v.add(bean);
			
		}
		con.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return v;
}


public Vector<DrinkBean> getJungDrink(int startRow, int endRow){
	
	Vector<DrinkBean> v = new Vector<>();
	
	getCon();
	try {
		//쿼리 작성
		String sql = "select * from (select A.*, Rownum Rnum from (select * from drink where kind = 4 order by no desc)A) where Rnum >= ? and Rnum <= ?";
		
		//쿼리 실행할 객체 선언
		pstmt = con.prepareStatement(sql);
		//?값을 대입
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			//데이터를 패키징(가방 = Boardbean 클래스를 이용)해줌
			DrinkBean bean = new DrinkBean();
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAlchol(rs.getInt(3));
			bean.setOrigin(rs.getString(4));
			bean.setImg(rs.getString(5));
			bean.setInfo(rs.getString(6));
			bean.setMaterial(rs.getString(7));
			bean.setFood(rs.getString(8));
			bean.setKind(rs.getInt(9));
			//패키징한 데이터를 백터에 저장
			v.add(bean);
			
		}
		con.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return v;
}



public Vector<DrinkBean> getLiDrink(int startRow, int endRow){
	
	Vector<DrinkBean> v = new Vector<>();
	
	getCon();
	try {
		//쿼리 작성
		String sql = "select * from (select A.*, Rownum Rnum from (select * from drink where kind = 4 order by no desc)A) where Rnum >= ? and Rnum <= ?";
		
		//쿼리 실행할 객체 선언
		pstmt = con.prepareStatement(sql);
		//?값을 대입
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			//데이터를 패키징(가방 = Boardbean 클래스를 이용)해줌
			DrinkBean bean = new DrinkBean();
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAlchol(rs.getInt(3));
			bean.setOrigin(rs.getString(4));
			bean.setImg(rs.getString(5));
			bean.setInfo(rs.getString(6));
			bean.setMaterial(rs.getString(7));
			bean.setFood(rs.getString(8));
			bean.setKind(rs.getInt(9));
			//패키징한 데이터를 백터에 저장
			v.add(bean);
			
		}
		con.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return v;
}



public DrinkBean getOneDrink(int no) {
	
	getCon();
	DrinkBean bean = null;
	
	try {
		
		
		
		String sql = "select * from drink where no=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		//쿼리실행후 결과를 리턴
		rs = pstmt.executeQuery();
		if(rs.next()) {//하나의 게시글이 존재 한다면
			bean = new DrinkBean();
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAlchol(rs.getInt(3));
			bean.setOrigin(rs.getString(4));
			bean.setImg(rs.getString(5));
			bean.setInfo(rs.getString(6));
			bean.setMaterial(rs.getString(7));
			bean.setFood(rs.getString(8));
			bean.setKind(rs.getInt(9));
			
		}
		con.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return bean;
}

}
