<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.saga.affairmanage.dao.MessageDAO" %>
<%@ page import="com.saga.affairmanage.factory.MessageDAOFactory" %>
<%@ page import="com.saga.affairmanage.util.Page" %>
<%@ page import="com.saga.affairmanage.util.PageUtil" %>
<%@ page import="com.saga.affairmanage.bean.Message" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>	
	
	<div id="indexfirst">
	<div id="thenew">
	<div class="tit">
		<h1>最新消息</h1>
	</div>
	<div class="STYLE1" id="therecom">
		<%
			MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
			Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
			List<Message> messages = messageDAO.findAllMessage(pageX);
			for(Message message : messages) {
		 %>
		 
		 	<p><a href="GetMessage?messageID=<%=message.getMessageID()%>"><%=message.getMessageTitle() %></a>
		 		<span class="STYLE2"><%=message.getPublishTime() %></span></p>
		 	<p>&nbsp;</p>
		 <%} %>
	</div>
	</div>
	
	<div id="menunav">
	<div class="tit">
		<h1>员工信息</h1>
	</div>
	
	<div id="employee">
		<c:choose>
			<c:when test="${empty sessionScope.employee }">
				没有进行身份识别，请先进行身份识别！
			</c:when>
			<c:otherwise>
				<ul>
					<li>员工编号：${employee.employeeID}</li>
					<li>员工姓名：${employee.employeeName}</li>
					<li>员工性别：${employee.employeeSex ? '男' : '女'}</li>
					<li>出生日期：${employee.employeeBirth}</li>
					<li>办公室电话：${employee.employeePhone}</li>
					<li>住址：${employee.employeePlace}</li>
					<li>管理层领导：${employee.lead?'是':'否' }</li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	</div>
	</div>
	
	<div id="indexsec"></div>
	
<%@ include file="footer.jsp" %>







