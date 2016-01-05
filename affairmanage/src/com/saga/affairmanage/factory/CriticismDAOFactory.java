package com.saga.affairmanage.factory;

import com.saga.affairmanage.dao.CriticismDAO;
import com.saga.affairmanage.daoImpl.CriticismDAOImpl;

public class CriticismDAOFactory {
	public static CriticismDAO getCriticismDAOInstance() {
		return new CriticismDAOImpl();
	}
}
