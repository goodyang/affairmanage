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
		<h1>������Ϣ</h1>
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
		<h1>Ա����Ϣ</h1>
	</div>
	
	<div id="employee">
		<c:choose>
			<c:when test="${empty sessionScope.employee }">
				û�н������ʶ�����Ƚ������ʶ��
			</c:when>
			<c:otherwise>
				<ul>
					<li>Ա����ţ�${employee.employeeID}</li>
					<li>Ա��������${employee.employeeName}</li>
					<li>Ա���Ա�${employee.employeeSex ? '��' : 'Ů'}</li>
					<li>�������ڣ�${employee.employeeBirth}</li>
					<li>�칫�ҵ绰��${employee.employeePhone}</li>
					<li>סַ��${employee.employeePlace}</li>
					<li>������쵼��${employee.lead?'��':'��' }</li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	</div>
	</div>
	
	<div id="indexsec"></div>
	
<%@ include file="footer.jsp" %>







