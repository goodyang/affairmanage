package com.saga.affairmanage.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.saga.affairmanage.bean.Reply;
import com.saga.affairmanage.dao.ReplyDAO;
import com.saga.affairmanage.util.DBConnection;
import com.saga.affairmanage.util.Page;

public class ReplyDAOImpl implements ReplyDAO{

	@Override
	public void addReply(Reply reply) {
		Connection conn = DBConnection.getConnection();
		String addSQL = "insert into reply (replyContent, employeeID, replyTime, messageID) "+
					" values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(addSQL);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getEmployeeID());
			pstmt.setTimestamp(3, new Timestamp(reply.getReplyTime().getTime()));
			pstmt.setInt(4, reply.getMessageID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
	}

	@Override
	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		List<Reply> replyList = new ArrayList<Reply>();
		Connection conn = DBConnection.getConnection();
		String findALLSQL = "select * from reply where messageID=? order by replyTime desc limit ?,?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reply reply = null;
		
		try {
			pstmt = conn.prepareStatement(findALLSQL);
			pstmt.setInt(1, messageID);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				reply = new Reply();
				int index = 1;
				reply.setReplyID(rs.getInt(index++));
				reply.setReplyContent(rs.getString(index++));
				reply.setEmployeeID(rs.getInt(index++));
				reply.setReplyTime(rs.getTimestamp(index++));
				reply.setMessageID(rs.getInt(index++));
			
				replyList.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return replyList;
	}

	@Override
	public int findCountByMsgID(int messageID) {
		Connection conn = DBConnection.getConnection();
		String findAllCountSQL = "select count(*) from reply where messageID=? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			pstmt = conn.prepareStatement(findAllCountSQL);
			pstmt.setInt(1, messageID);
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
