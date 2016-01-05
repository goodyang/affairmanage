<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

	<div id="place">��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [��Ϣ�б�]</div>
	<div id="channelcont">
	<div id="channelleft">
	<div class="channelinleft">
	<div class="channeltit"></div>
	
	<dl>
		<c:forEach items="${requestScope.messageList }" var="message">
		<dt>>><a href="GetMessage?messageID=${message.messageID }">${message.messageTitle }</a></dt>
		<dd>
			<div align="right">������ID: ${message.employeeID} 
							����ʱ�䣺 ${message.publishTime} </div>
		</dd>
		</c:forEach>
	</dl>
	
	<div>
		<div align="center">
			<c:choose>
				<c:when test="${page.hasPrePage}">
					<a href="GetMessageList?currentPage=1">��ҳ</a> | 
			<a href="GetMessageList?currentPage=${page.currentPage -1 }">��һҳ</a>
				</c:when>
				<c:otherwise>
					��ҳ | ��һҳ
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.hasNextPage}">
					<a href="GetMessageList?currentPage=${page.currentPage + 1 }">��һҳ</a> | 
			<a href="GetMessageList?currentPage=${page.totalPage }">βҳ</a>
				</c:when>
				<c:otherwise>
					��һҳ | βҳ
				</c:otherwise>
			</c:choose>
			��ǰΪ��${page.currentPage}ҳ,��${page.totalPage}ҳ
		</div>
	</div>
	
	</div>
	</div>
	</div>
	
<%@ include file="footer.jsp" %>
