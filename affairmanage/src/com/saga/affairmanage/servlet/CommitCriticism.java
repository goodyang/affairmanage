package com.saga.affairmanage.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saga.affairmanage.bean.Criticism;
import com.saga.affairmanage.bean.Employee;
import com.saga.affairmanage.dao.CriticismDAO;
import com.saga.affairmanage.factory.CriticismDAOFactory;

public class CommitCriticism extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("gbk");
		String criticismContent = req.getParameter("criticismContent");
		int messageID = Integer.parseInt(req.getParameter("messageID"));
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		Employee employee = (Employee)req.getSession().getAttribute("employee");
		if(employee == null) {
			req.setAttribute("error", "要进行批复必须首先进行身份验证");
		}else {
			if(criticismContent == null || "".equals(criticismContent)) {
				req.setAttribute("error", "必须输入批复内容");
			}else {
				Criticism criticism = new Criticism();
				criticism.setCriticismContent(criticismContent);
				criticism.setEmployeeID(employee.getEmployeeID());
				criticism.setMessageID(messageID);;
				criticism.setCriticismTime(new Date());			
				CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
				criticismDAO.addCriticism(criticism);
			}
		}
		dispatcher = servletContext.getRequestDispatcher("/GetMessage?messageID="+messageID);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
