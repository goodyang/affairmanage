package com.saga.affairmanage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saga.affairmanage.bean.Criticism;
import com.saga.affairmanage.bean.Message;
import com.saga.affairmanage.bean.Reply;
import com.saga.affairmanage.dao.CriticismDAO;
import com.saga.affairmanage.dao.MessageDAO;
import com.saga.affairmanage.dao.ReplyDAO;
import com.saga.affairmanage.factory.CriticismDAOFactory;
import com.saga.affairmanage.factory.MessageDAOFactory;
import com.saga.affairmanage.factory.ReplyDAOFactory;
import com.saga.affairmanage.util.Page;
import com.saga.affairmanage.util.PageUtil;

public class GetMessage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int messageID = Integer.parseInt(req.getParameter("messageID"));
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		Message message = messageDAO.findMessage(messageID);
		req.setAttribute("message", message);
		
		int currentPage = 0;
		String currentPagestr = req.getParameter("currentPage");
		if(currentPagestr == null || "".equals(currentPagestr)) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPagestr);
		}
		
		ReplyDAO replyDAO = ReplyDAOFactory.getReplayDaoInstance();
		Page page = PageUtil.createPage(5, replyDAO.findCountByMsgID(messageID), currentPage);
		
		List<Reply> replies = replyDAO.findReplayByMsgID(messageID, page);
		
		req.setAttribute("replyList", replies);
		req.setAttribute("page", page);
		
		CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
		Criticism criticism = criticismDAO.findCriticismByMsgID(messageID);
		
		req.setAttribute("criticism", criticism);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/showMsg.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}












