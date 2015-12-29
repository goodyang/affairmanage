package com.saga.affairmanage.factory;

import com.saga.affairmanage.dao.EmployeeDAO;
import com.saga.affairmanage.daoImpl.EmployeeDAOImpl;

public class EmployeeDAOFactory {
	public static EmployeeDAO getEmployeeDAOInstance() {
		return new EmployeeDAOImpl();
	}
}
