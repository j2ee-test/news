<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻列表</title>
    
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
    		<th>新闻标题</th>
    		<th>操作</th>
    	</tr>
<c:forEach items="${newsList }" var="n">    
    	<tr style="text-align: center;" bordercolor="rgb(78,78,78)">
    		<td>${n.caption }(<c:if test="${n.exam == 1 }">已发布</c:if><c:if test="${n.exam == 0 }">待审核</c:if>)</td>
    		<td>
    		<c:if test="${type eq 'check' }">
    		  <a onclick="alert('审核成功！')" href="<c:url value='/admin/AdminNewsServlet?method=check&newsId=${n.newsId }'/>">通过审核</a>
    		</c:if>
    		<c:if test="${type eq 'delete' }">
    		  <a onclick="return confirm('您真要删除该新闻吗?')" href="<c:url value='/admin/AdminNewsServlet?method=delete&newsId=${n.newsId }'/>">删除</a>
    		</c:if>
    		</td>
    	</tr>
</c:forEach>
   
    </table>
  </body>
</html>
