package com.saga.affairmanage.factory;

import com.saga.affairmanage.dao.MessageDAO;
import com.saga.affairmanage.daoImpl.MessageDAOImpl;

public class MessageDAOFactory {
	public static MessageDAO getMessageDAOInstance() {
		return new MessageDAOImpl();
	}
}
