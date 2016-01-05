package com.saga.affairmanage.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saga.affairmanage.bean.Employee;
import com.saga.affairmanage.bean.Message;
import com.saga.affairmanage.dao.MessageDAO;
import com.saga.affairmanage.factory.MessageDAOFactory;

public class MsgPublish extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("gbk");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		Employee employee = (Employee)req.getSession().getAttribute("employee");
		if(employee == null) {
			req.setAttribute("error", "要发布消息必须首先进行身份验证");
			dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
		}else {
			if(title == null || "".equals(title)) {
				req.setAttribute("error", "必须输入消息标题");
				dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
			}else {
				Message message = new Message();
				message.setEmployeeID(employee.getEmployeeID());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				message.setPublishTime(new Timestamp(new Date().getTime()));
				MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
				messageDAO.addMessage(message);
				dispatcher = servletContext.getRequestDispatcher("/GetMessageList");
			}
		}
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
