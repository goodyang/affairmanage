<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'statusRecognise.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   
   <div id="userinfoRecognise">
   		<font color="red">${requestScope.error}</font>
   		<form action="StatusRecogniseAction" method="post">
   			<p>员工编号: <input type="text" name="employeeID" value="${param.employeeID}"/></p>
   			<p>&nbsp;</p>
   			<p>系统口令: <input type="password" name="password"/></p>
   			<p><input type="submit" value="提交" /> <input type="reset" value="重置"/></p>
   		</form>
   </div>
   
   
  </body>
</html>
