<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Msg Page</title>
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
   <h1>${msg }</h1>
   <ul>
   	<li><a href="<c:url value='/index.jsp'/>">主页</a></li>
   	<li><a href="<c:url value='/user/free/login.jsp'/>">登录</a></li>
   	<li><a href="<c:url value='/user/free/register.jsp'/>">注册</a></li>
   </ul>
  </body>
</html>
