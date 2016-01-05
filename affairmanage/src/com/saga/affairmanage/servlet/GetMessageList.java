package com.saga.affairmanage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saga.affairmanage.bean.Message;
import com.saga.affairmanage.dao.MessageDAO;
import com.saga.affairmanage.factory.MessageDAOFactory;
import com.saga.affairmanage.util.Page;
import com.saga.affairmanage.util.PageUtil;

public class GetMessageList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int currentPage = 0;
		String currentPageStr = req.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
		List<Message> messages = messageDAO.findAllMessage(page);
		req.setAttribute("messageList", messages);
		req.setAttribute("page", page);
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/msgList.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
