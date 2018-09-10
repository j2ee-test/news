<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="req" value="${pageContext.request }"/>
<c:set var="base" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath }/"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${base }" target="body">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: white; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">MagicYang新闻系统</h1>
<div style="font-size: 10pt;">
<c:choose>
	<c:when test="${not empty sessionScope.session_user }">
		您好：${sessionScope.session_user.name }&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="UserServlet?method=changePassword" target="body">修改密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="UserServlet?method=quit" target="_top">退出</a>
	</c:when>
	<c:otherwise>
		<a href="<c:url value="/user/free/login.jsp"/>" target="body">登录</a> |&nbsp; 
		<a href="<c:url value="/user/free/register.jsp"/>" target="body">注册</a>
	</c:otherwise>
</c:choose>
</div>
  </body>
</html>
