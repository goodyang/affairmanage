<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://ckeditor.com" prefix="CK" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>
	
	<div id="place">��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [��Ϣ�б�] - [�鿴������Ϣ]</div>
	<div id="channelcont">
	<div id="channelleft">
	<div class="channelinleft">
		<br />
		<h2 align="center">${message.messageTitle} </h2>
		<br />
		${message.messageContent }
		<div align="right">������ID��${message.employeeID }
			����ʱ�䣺${message.publishTime }</div>
			
		<div>
			<h5 style="color:red">�쵼������${empty criticism ? "����" : criticism.criticismContent }</h5>
		</div>
		<hr />
		
		<c:forEach items="${requestScope.replyList }" var="reply">
			<div>
				${reply.replyContent }
				<div align="right">�ظ���ID�� ${reply.employeeID }
					�ظ�ʱ�䣺 ${reply.replyTime }</div>
				<hr />
			</div>
		</c:forEach>
		<div align="center">
			��<c:forEach varStatus="stat" begin="1" end="${page.totalPage}">
				<a href="GetMessage?messageID=${message.messageID}&currentPage=${stat.index}">${stat.index}</a>
			</c:forEach>ҳ
		</div>
	</div>
	
	<div align="left">
		<p>�ظ�:</p>
		<p><font color="red">${error }</font></p>
		<form action="CommitReply" method="post">
			<CK:editor editor="replyContent" basePath="/ckeditor">
			<input type="hidden" name="messageID" value="${message.messageID }" />
			<input type="submit" value="�ύ" />
			<input type="reset" value="����" />
			</CK:editor>
		</form>
	</div>
	
	<c:if test="${sessionScope.employee.lead }">
		<div align="left">
		<p>������</p>
		<p><font color="red">${error }</font></p>
		<form action="CommitCriticism" method="post">
			<CK:editor editor="criticismContent" basePath="ckeditor">
				<input type="hidden" name="messageID" value="${message.messageID }" />
				<input type="submit" value="�ύ" />
				<input type="reset" value="����" />
			</CK:editor>
		</form>
		</div>
	</c:if>
	</div>
	</div>
	
<%@ include file="footer.jsp" %>
