<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {background: rgb(254,238,189);}
	table {font-family: 宋体; font-size: 11pt; border-color: rgb(78,78,78);  width: 60%;}
	#th {background: rgb(78,78,78);}
</style>
  </head>
  
  <body>
    <h2 style="text-align: center;">新闻列表</h2>
    <table align="center" border="1" cellpadding="0" cellspacing="0">
    	<tr id="th" bordercolor="rgb(78,78,78)">
    		<th>用户名</th>
    		<th>注册时间</th>
    		<th>用户身份</th>
    		<th>用户状态</th>
    		<th>操作</th>
    	</tr>
<c:forEach items="${userList }" var="user">    
    	<tr style="text-align: center;" bordercolor="rgb(78,78,78)">
    		<td>${user.name }</td>
    		<td>${user.registerDate }</td>
    		<td>
    		<c:if test="${user.type eq 'manager'}">管理员</c:if>
    		<c:if test="${user.type eq 'user'}">普通用户</c:if>
    		<c:if test="${user.type eq 'newsAuthor'}">新闻发布者</c:if>    		
    		</td>
    		<td>
    		<c:if test="${user.enable eq 'use'}">正在使用</c:if>
    		<c:if test="${user.enable eq 'stop'}">已停用</c:if>
    		</td>
    		
    		<td>
    		<c:if test="${type eq 'changeAdmin' }">
    		  <a href="<c:url value='/admin/AdminUserServlet?method=changeAdminPre&userId=${user.userId }'/>">修改权限</a>
    		</c:if>
    		<c:if test="${type eq 'changeEnable' }">
    		  <a onclick="alert('操作成功！')" href="<c:url value='/admin/AdminUserServlet?method=changeEnable&userId=${user.userId }'/>"><c:if test="${user.enable eq 'use' }">停用</c:if><c:if test="${user.enable eq 'stop' }">启用</c:if></a>
    		</c:if>
    		<c:if test="${type eq 'delete' }">
    		  <a onclick="return confirm('您真要删除该用户吗?')" href="<c:url value='/admin/AdminUserServlet?method=delete&userId=${user.userId }'/>">删除</a>
    		</c:if>
    		</td>
    	</tr>
</c:forEach>
   
    </table>
  </body>
</html>
