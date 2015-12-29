package com.saga.affairmanage.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saga.affairmanage.bean.Employee;
import com.saga.affairmanage.dao.EmployeeDAO;
import com.saga.affairmanage.factory.EmployeeDAOFactory;

public class StatusRecognise extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeeID = req.getParameter("employeeID");
		String password = req.getParameter("password");
		
		if(employeeID == null || "".equals(employeeID.trim())) {
			req.setAttribute("error", "请输入员工编号!");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
		}else {
			if(password == null || "".equals(password.trim())) {
				req.setAttribute("error", "请输入系统口令!");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			}else {
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
				if(employee == null) {
					req.setAttribute("error", "该员工编号不存在!");
					dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
				}else {
					if(employee.getPassword().equals(password.trim())) {
						req.getSession().setAttribute("employee", employee);
						resp.sendRedirect("index.jsp");
						return;
					}else {
						req.setAttribute("error", "系统口令不正确!");
						dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
					}
				}
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
