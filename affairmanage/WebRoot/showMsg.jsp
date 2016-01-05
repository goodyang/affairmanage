<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://ckeditor.com" prefix="CK" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>
	
	<div id="place">当前位置：[<a href="index.jsp">首页</a>] - [消息列表] - [查看具体消息]</div>
	<div id="channelcont">
	<div id="channelleft">
	<div class="channelinleft">
		<br />
		<h2 align="center">${message.messageTitle} </h2>
		<br />
		${message.messageContent }
		<div align="right">发布人ID：${message.employeeID }
			发布时间：${message.publishTime }</div>
			
		<div>
			<h5 style="color:red">领导批复：${empty criticism ? "暂无" : criticism.criticismContent }</h5>
		</div>
		<hr />
		
		<c:forEach items="${requestScope.replyList }" var="reply">
			<div>
				${reply.replyContent }
				<div align="right">回复人ID： ${reply.employeeID }
					回复时间： ${reply.replyTime }</div>
				<hr />
			</div>
		</c:forEach>
		<div align="center">
			第<c:forEach varStatus="stat" begin="1" end="${page.totalPage}">
				<a href="GetMessage?messageID=${message.messageID}&currentPage=${stat.index}">${stat.index}</a>
			</c:forEach>页
		</div>
	</div>
	
	<div align="left">
		<p>回复:</p>
		<p><font color="red">${error }</font></p>
		<form action="CommitReply" method="post">
			<CK:editor editor="replyContent" basePath="/ckeditor">
			<input type="hidden" name="messageID" value="${message.messageID }" />
			<input type="submit" value="提交" />
			<input type="reset" value="重置" />
			</CK:editor>
		</form>
	</div>
	
	<c:if test="${sessionScope.employee.lead }">
		<div align="left">
		<p>批复：</p>
		<p><font color="red">${error }</font></p>
		<form action="CommitCriticism" method="post">
			<CK:editor editor="criticismContent" basePath="ckeditor">
				<input type="hidden" name="messageID" value="${message.messageID }" />
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</CK:editor>
		</form>
		</div>
	</c:if>
	</div>
	</div>
	
<%@ include file="footer.jsp" %>
