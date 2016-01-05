<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
   
<%@ include file="header.jsp" %>
	
	<div id="place">当前位置：[<a href="index.jsp">首页</a>] - [员工身份识别]</div>
	
	
	<div id="menunav2">
		<div class="tit">
			<h1>员工身份识别</h1>
		</div>
		<div id="shenfenshibie">
			<font color="red">${requestScope.error}</font>
	   		<form action="StatusRecogniseAction" method="post">
	   			<p>员工编号: <input type="text" name="employeeID" value="${param.employeeID}"/></p>
	   			<p>&nbsp;</p>
	   			<p>系统口令: <input type="password" name="password"/></p>
	   			<p><input type="submit" value="提交" /> <input type="reset" value="重置"/></p>
	   		</form>
		</div>
	</div>
	
<%@ include file="footer.jsp" %>
