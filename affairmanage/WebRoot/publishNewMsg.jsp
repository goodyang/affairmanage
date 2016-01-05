<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://ckeditor.com" prefix="CK" %>

<%@ include file="header.jsp" %>
    	
   	<div id="place">当前位置：[<a href="index.jsp">首页</a>] - [发布新消息]</div>
   	<div id="channelcont">
   		<div id="channelleft">
   			<div class="channelinleft">
   				<div id="messageBox">
   					<p> 
   						<font color="red"> ${requestScope.error} </font> 
   					</p>
   					<form action="MsgPublic" method="post">
   					<p>消息标题：<input type="text" name="title" size="50"/></p>
   					<p>消息内容：</p>
   					<p><CK:editor editor="myToolbar" basePath="/ckeditor" ></CK:editor></p>
   					<p align="center">
   						<input type="submit" value="提交" />
   						<input type="reset" value="重置" />
   					</p>
   					</form>
   				</div>
   			</div>
   		</div>
   	</div>
   	
<%@ include file="footer.jsp" %>
