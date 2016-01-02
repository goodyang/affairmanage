<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://ckeditor.com" prefix="CK" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=gb2312" />
    <title>企业日常事务管理系统-发布新消息</title>
    <link href="css.css" type="text/css" rel = "stylesheet" media="all" />
    <link href="css/channel.css" type="text/css" rel = "stylesheet" media="all" />
    <script type="text/javascript" src="menu.js"></script>
  </head>
  
  <body>
  	<div style="margin:0px auto;width:970px">
    <div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
    <div id="topmenu"><img width="970" height="147" src="images/banner.jpg"/></div>
    <div id="bookmunu">
    	<div class="jsmenu" id="jsmenu">
    	<ul>
    		<li class="normal"><a urn="jsmenu1" rel="conmenu" href="index.jsp">首页</a></li>
    		<li class="normal"><a urn="jsmenu2" rel="conmenu" href="GetMessageList">消息列表</a></li>
    		<li class="active"><a urn="#default_Info" rel="conmenu" href="publishNewMsg.jsp">发布新消息</a></li>
    		<li class="normal"><a urn="jsmenu3" rel="conmenu" href="statusRecognise.jsp">身份识别</a></li>
    	</ul>
    	</div>
    	
    	<div id="conmenu"></div>
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
    	
    	<div class="copyright">
    	<ul>
    	<li></li>
    	<li>企业日常事务管理系统 &nbsp;&copy;2015-2016</li>
    	</ul>
    	</div>
    	</div>
    	<div class="end">
    	<script type="text/javascript">
    		starajaxtabs("jsmenu");
    		
    		var iTab = GetCookie("nets_jsmenu");
    		iTab = iTab?parseInt(iTab):parseInt(Math.random()*5);
    		if(iTab!=0) {
    			getElement("jsmenu").getElementsByTagName("hi")[iTab].LoadTab();
    		}
    		iTab++;
    		if(iTab>4) iTab = 0;
    		SetCookie("nets_jsmenu", iTab, 365);
    		
    		function getElement(aID) {
    			return (document.getElementById) ? document.getElementById(aID):document.all[aID];
    		}
    	</script>
    	</div>
    </div>
  </body>
</html>
