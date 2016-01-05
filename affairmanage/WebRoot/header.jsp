<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://ckeditor.com" prefix="CK" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta content="text/html; charset=gb2312" http-equiv="Content-Type" />
    <title>企业日常事务管理系统-查看具体消息</title>
	<link type="text/css" href="css.css" rel="stylesheet" media="all" />
	<link type="text/css" href="css/channel.css" rel="stylesheet" media="all" />
	<script type="text/javascript" src="menu.js"></script>
	<style type="text/css">
		.STYLE1 {font-size: 16px}
		.STYLE2 {
			color: #CCCCCC;
			font-size: 14px;
		}
		.STYLE3 {font-size: 14px}
	</style>
  </head>
  <%  
  	String requestURI = request.getRequestURI();
  	String basepath = request.getContextPath();
  	String pagePath = requestURI.substring(requestURI.indexOf(basepath)+basepath.length()+1, requestURI.indexOf("jsp")-1);
  	int i=1;
   %>
  <body>
    <div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
	<div id="topmenu"><img src="images/banner.jpg" width="970" height="147" /></div>
	<div id="bookmunu">
	<div class="jsmenu" id="jsmenu">
	<ul>
	   <li class=<%if(pagePath.equals("index")){%>"active"><a urn="#default_Info"<%}else{ %>"normal"><a urn="jsmenu<%=i++%>" <%} %> rel="conmenu" href="index.jsp">首页</a></li>
	  <li class=<%if(pagePath.equals("msgList")||pagePath.equals("showMsg")){ %>"active"><a urn="#default_Info"<%}else{ %>"normal"><a urn="jsmenu<%=i++%>" <%} %> rel="conmenu" href="GetMessageList">消息列表</a></li>
	  <li class=<%if(pagePath.equals("publishNewMsg")){ %>"active"><a urn="#default_Info"<%}else{ %>"normal"><a urn="jsmenu<%=i++%>" <%} %> rel="conmenu" href="publishNewMsg.jsp">发布新消息</a></li>
	  <li class=<%if(pagePath.equals("statusRecognise")){ %>"active"><a urn="#default_Info"<%}else{ %>"normal"><a urn="jsmenu<%=i++%>" <%} %> rel="conmenu" href="statusRecognise.jsp">身份识别</a></li>
	  </ul>
	</div>
	</div>
