package com.saga.affairmanage.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.saga.affairmanage.bean.Criticism;
import com.saga.affairmanage.dao.CriticismDAO;
import com.saga.affairmanage.util.DBConnection;

public class CriticismDAOImpl implements CriticismDAO {

	@Override
	public void addCriticism(Criticism criticism) {
		Connection conn = DBConnection.getConnection();
		String addSQL = " insert into criticism (criticismContent, employeeID, criticismTime, messageID)"+
				" values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(addSQL);
			pstmt.setString(1, criticism.getCriticismContent());
			pstmt.setInt(2, criticism.getEmployeeID());
			pstmt.setTimestamp(3, new Timestamp(criticism.getCriticismTime().getTime()));
			pstmt.setInt(4, criticism.getMessageID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(pstmt);
		}
	}

	@Override
	public Criticism findCriticismByMsgID(int messageID) {
		Connection conn = DBConnection.getConnection();
		String findSQL = " select * from criticism where messageID=? order by criticismTime desc limit 0,1";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Criticism criticism = null;
		try {
			pstmt = conn.prepareStatement(findSQL);
			pstmt.setInt(1, messageID);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				criticism = new Criticism();
				criticism.setCriticismID(rs.getInt(1));
				criticism.setCriticismContent(rs.getString(2));
				criticism.setEmployeeID(rs.getInt(3));
				criticism.setCriticismTime(rs.getDate(4));
				criticism.setMessageID(rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(pstmt);
		}
		
		return criticism;
	}
	
}
