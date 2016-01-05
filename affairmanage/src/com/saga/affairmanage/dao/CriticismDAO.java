package com.saga.affairmanage.dao;

import com.saga.affairmanage.bean.Criticism;

public interface CriticismDAO {
	public void addCriticism(Criticism criticism);
	public Criticism findCriticismByMsgID(int messageID);
}
