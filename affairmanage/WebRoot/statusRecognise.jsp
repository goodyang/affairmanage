<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
   
<%@ include file="header.jsp" %>
	
	<div id="place">��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [Ա�����ʶ��]</div>
	
	
	<div id="menunav2">
		<div class="tit">
			<h1>Ա�����ʶ��</h1>
		</div>
		<div id="shenfenshibie">
			<font color="red">${requestScope.error}</font>
	   		<form action="StatusRecogniseAction" method="post">
	   			<p>Ա�����: <input type="text" name="employeeID" value="${param.employeeID}"/></p>
	   			<p>&nbsp;</p>
	   			<p>ϵͳ����: <input type="password" name="password"/></p>
	   			<p><input type="submit" value="�ύ" /> <input type="reset" value="����"/></p>
	   		</form>
		</div>
	</div>
	
<%@ include file="footer.jsp" %>
