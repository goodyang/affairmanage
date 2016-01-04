package com.saga.affairmanage.factory;

import com.saga.affairmanage.dao.ReplyDAO;
import com.saga.affairmanage.daoImpl.ReplyDAOImpl;

public class ReplyDAOFactory {
	public static ReplyDAO getReplayDaoInstance() {
		return new ReplyDAOImpl();
	}
}
