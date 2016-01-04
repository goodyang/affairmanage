package com.saga.affairmanage.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saga.affairmanage.bean.Employee;
import com.saga.affairmanage.bean.Reply;
import com.saga.affairmanage.dao.ReplyDAO;
import com.saga.affairmanage.factory.ReplyDAOFactory;

public class CommitReply extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("gbk");
		String replyContent = req.getParameter("replyContent");
		int messageID = Integer.parseInt(req.getParameter("messageID"));
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		Employee employee = (Employee) req.getSession().getAttribute("employee");
		if(employee == null) {
			req.setAttribute("error", "要进行回复必须首先要进行身份验证");
		}else {
			if(replyContent == null || "".equals(replyContent)) {
				req.setAttribute("error", "必须输入回复内容");
			}else {
				Reply reply = new Reply();
				reply.setReplyContent(replyContent);
				reply.setMessageID(messageID);
				reply.setEmployeeID(employee.getEmployeeID());
				reply.setReplyTime(new Date());
				ReplyDAO replyDAO = ReplyDAOFactory.getReplayDaoInstance();
				replyDAO.addReply(reply);
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
