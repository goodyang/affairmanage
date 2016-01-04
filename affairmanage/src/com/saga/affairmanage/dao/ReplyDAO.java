package com.saga.affairmanage.dao;

import java.util.List;

import com.saga.affairmanage.bean.Reply;
import com.saga.affairmanage.util.Page;

public interface ReplyDAO {
	public void addReply(Reply reply);
	public List<Reply> findReplayByMsgID(int messageID, Page page);
	public int findCountByMsgID(int messageID);
}
