package com.city.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecDAO {

	private static RecDAO instance = null;

	private RecDAO() {
		// TODO Auto-generated constructor stub
	}

	public static RecDAO getInstance() {
		if (instance == null) {
			synchronized (RecDAO.class) {
				instance = new RecDAO();
			}
		}
		return instance;
	}

	public List<RecVO> getMap() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<RecVO> array = new ArrayList<>();

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select * from reco");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecVO recmap = new RecVO(); // °´Ã¼ ¸¸µë

				// db¿¡¼­ °¡Á®¿Í¾ßµÊ
				recmap.setNum(rs.getInt("num"));
				recmap.setReccityname(rs.getString("reccityname"));
				recmap.setKoreaname(rs.getString("koreaname"));
				recmap.setContinent(rs.getString("continent"));
				recmap.setMainlongitude(rs.getString("mainlongitude"));
				recmap.setMainlatitude(rs.getString("mainlatitude"));
				recmap.setPin1longitude(rs.getString("pin1longitude"));
				recmap.setPin1latitude(rs.getString("pin1latitude"));
				recmap.setPin2longitude(rs.getString("pin2longitude"));
				recmap.setPin2latitude(rs.getString("pin2latitude"));
				recmap.setPin3longitude(rs.getString("pin3longitude"));
				recmap.setPin3latitude(rs.getString("pin3latitude"));
				recmap.setPin4longitude(rs.getString("pin4longitude"));
				recmap.setPin4latitude(rs.getString("pin4latitude"));
				recmap.setPin5longitude(rs.getString("pin5longitude"));
				recmap.setPin5latitude(rs.getString("pin5latitude"));
				recmap.setPin1explainname(rs.getString("pin1explainname"));
				recmap.setPin2explainname(rs.getString("pin2explainname"));
				recmap.setPin3explainname(rs.getString("pin3explainname"));
				recmap.setPin4explainname(rs.getString("pin4explainname"));
				recmap.setPin5explainname(rs.getString("pin5explainname"));
				recmap.setPin1explain(rs.getString("pin1explain"));
				recmap.setPin2explain(rs.getString("pin2explain"));
				recmap.setPin3explain(rs.getString("pin3explain"));
				recmap.setPin4explain(rs.getString("pin4explain"));
				recmap.setPin5explain(rs.getString("pin5explain"));
				array.add(recmap);
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

		return array;
	}

	
	  

}