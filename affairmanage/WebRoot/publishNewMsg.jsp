<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://ckeditor.com" prefix="CK" %>

<%@ include file="header.jsp" %>
    	
   	<div id="place">��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [��������Ϣ]</div>
   	<div id="channelcont">
   		<div id="channelleft">
   			<div class="channelinleft">
   				<div id="messageBox">
   					<p> 
   						<font color="red"> ${requestScope.error} </font> 
   					</p>
   					<form action="MsgPublic" method="post">
   					<p>��Ϣ���⣺<input type="text" name="title" size="50"/></p>
   					<p>��Ϣ���ݣ�</p>
   					<p><CK:editor editor="myToolbar" basePath="/ckeditor" ></CK:editor></p>
   					<p align="center">
   						<input type="submit" value="�ύ" />
   						<input type="reset" value="����" />
   					</p>
   					</form>
   				</div>
   			</div>
   		</div>
   	</div>
   	
<%@ include file="footer.jsp" %>
