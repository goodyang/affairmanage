package com.saga.affairmanage.dao;

import java.util.List;

import com.saga.affairmanage.bean.Message;
import com.saga.affairmanage.util.Page;

public interface MessageDAO {
	public void addMessage(Message message);
	public void updateMessage(Message message);
	public void deleteMessage(int messageID);
	public List<Message> findAllMessage(Page page);
	public Message findMessage(int messageID);
	public int findAllCount();
}
