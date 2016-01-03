package com.saga.affairmanage.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.saga.affairmanage.bean.Message;
import com.saga.affairmanage.dao.MessageDAO;
import com.saga.affairmanage.util.DBConnection;
import com.saga.affairmanage.util.Page;

public class MessageDAOImpl implements MessageDAO{

	@Override
	public void addMessage(Message message) {
		Connection conn = DBConnection.getConnection();
		String addSQL = "insert into tb_message(messageTitle, messageContent, employeeID, publishTime)"+
				" values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(addSQL);
			pstmt.setString(1, message.getMessageTitle());
			pstmt.setString(2, message.getMessageContent());
			pstmt.setInt(3, message.getEmployeeID());
			pstmt.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public void updateMessage(Message message) {
		Connection conn = DBConnection.getConnection();
		String updateSQL = "update message set messageTitle=?, messageContent=?,employeeID=?, publishTime=?"+
				" where employeeID=?";
		Message testMessage = null;
		if(message.getMessageID()>0){
			testMessage = findMessage(message.getMessageID());
		}
		if(testMessage != null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				int index = 1;
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(index++, message.getMessageTitle());
				pstmt.setString(index++, message.getMessageContent());
				pstmt.setInt(index++, message.getEmployeeID());
				pstmt.setTimestamp(index++, new Timestamp(message.getPublishTime().getTime()));
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(rs);
				DBConnection.close(pstmt);
				DBConnection.close(conn);
			}
		}		
	}

	@Override
	public void deleteMessage(int messageID) {
		Connection conn = DBConnection.getConnection();
		String deleteByIDSQL = "delete from message where messageID=?";
		Message message = findMessage(messageID);
		if(message != null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(deleteByIDSQL);
				pstmt.setInt(1, messageID);
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(rs);
				DBConnection.close(pstmt);
				DBConnection.close(conn);
			}
		}	
	}

	@Override
	public List<Message> findAllMessage(Page page) {
		List<Message> messageList = new ArrayList<Message>();
		Connection conn = DBConnection.getConnection();
		String findALLSQL = "select * from message order by publishTime desc limit ?,?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;
		
		try {
			pstmt = conn.prepareStatement(findALLSQL);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				message = new Message();
				int index = 1;
				message.setMessageID(rs.getInt(index++));
				message.setMessageTitle(rs.getString(index++));
				message.setMessageContent(rs.getString(index++));
				message.setEmployeeID(rs.getInt(index++));
				message.setPublishTime(rs.getTimestamp(index++));
				
				messageList.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return messageList;
	}

	@Override
	public Message findMessage(int messageID) {
		Connection conn = DBConnection.getConnection();
		String findByIDSQL = "select * from message where messageID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;
		
		try {
			pstmt = conn.prepareStatement(findByIDSQL);
			pstmt.setInt(1, messageID);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				message = new Message();
				int index = 1;
				message.setMessageID(rs.getInt(index++));
				message.setMessageTitle(rs.getString(index++));
				message.setMessageContent(rs.getString(index++));
				message.setEmployeeID(rs.getInt(index++));
				message.setPublishTime(rs.getTimestamp(index));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return message;
	}

	@Override
	public int findAllCount() {
		Connection conn = DBConnection.getConnection();
		String findAllCountSQL = "select count(*) from message ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			pstmt = conn.prepareStatement(findAllCountSQL);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				ret = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return ret;
	}
	
}
