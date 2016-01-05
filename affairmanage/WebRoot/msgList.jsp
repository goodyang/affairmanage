<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

	<div id="place">当前位置：[<a href="index.jsp">首页</a>] - [消息列表]</div>
	<div id="channelcont">
	<div id="channelleft">
	<div class="channelinleft">
	<div class="channeltit"></div>
	
	<dl>
		<c:forEach items="${requestScope.messageList }" var="message">
		<dt>>><a href="GetMessage?messageID=${message.messageID }">${message.messageTitle }</a></dt>
		<dd>
			<div align="right">发布人ID: ${message.employeeID} 
							发布时间： ${message.publishTime} </div>
		</dd>
		</c:forEach>
	</dl>
	
	<div>
		<div align="center">
			<c:choose>
				<c:when test="${page.hasPrePage}">
					<a href="GetMessageList?currentPage=1">首页</a> | 
			<a href="GetMessageList?currentPage=${page.currentPage -1 }">上一页</a>
				</c:when>
				<c:otherwise>
					首页 | 上一页
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.hasNextPage}">
					<a href="GetMessageList?currentPage=${page.currentPage + 1 }">下一页</a> | 
			<a href="GetMessageList?currentPage=${page.totalPage }">尾页</a>
				</c:when>
				<c:otherwise>
					下一页 | 尾页
				</c:otherwise>
			</c:choose>
			当前为第${page.currentPage}页,共${page.totalPage}页
		</div>
	</div>
	
	</div>
	</div>
	</div>
	
<%@ include file="footer.jsp" %>
