<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改用户权限</title>
    
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
</style>
  </head>
  
  <body>
    <h1>修改用户权限</h1>
    <form action="<c:url value='/admin/AdminUserServlet'/>" method="post">
    	<input type="hidden" name="method" value="changeAdmin" />
    	<input type="hidden" name="userId" value="${user.userId }" />
    	权限名称：	
    	<select name="UserType" id="UserType">
			<option value="manager" >管理员</option>	
    		<option <c:if test="${user.type eq 'newsAuthor' }">selected = "selected"</c:if> value="newsAuthor">新闻发布者</option>	
    		<option <c:if test="${user.type eq 'user' }">selected = "selected"</c:if> value="user">普通用户</option>	
    	</select>
    	<input onclick="alert('操作成功！')" type="submit" value="修改用户权限"/>
    </form>
  </body>
</html>
