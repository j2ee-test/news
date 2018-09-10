<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request }"/>
<c:set var="base" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath }/"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${base }">
    
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
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
		font-size: 10pt;
		width: 90%;
		margin:auto;
	}
	.oneNews {
		margin:10px;
		border: solid 2px gray;
		width: 100%;
		height: 1000px;
	}
	.newsBar{
		margin:10px;
		width:30%;
		height:20px;
		float:left;
	}
</style>
  </head>
  
  <body>
 <c:forEach items="${pb.beanList }" var="news">
 
  <div class="oneNews">
  	<div class="newsBar">
  		作者：${news.author }
  	</div>
  	<div class="newsBar">
  		新闻时间：${news.newsTime }
  	</div>
    <div class="newsBar">
  		发布时间：${news.publishTime }
  	</div>
    <br/>
    <div style="font-size:30px;text-align:center;">${news.caption }</div>
   	<div>${news.content }</div>
  </div>
  </c:forEach>
  <br/>
  <center>
<c:if test="${!empty pb.beanList }">
  第${pb.pc }页/共${pb.tp }页
  <a href="<c:url value="/NewsServlet?method=${searchMethod }&pc=1&tid=${tids }"/>">首页</a>
  <c:if test="${pb.pc > 1 }">
  <a href="<c:url value="/NewsServlet?method=${searchMethod }&pc=${pb.pc-1 }&tid=${tids }"/>">上一页</a>
  </c:if>
  <c:if test="${pb.pc < pb.tp }">
  <a href="<c:url value="/NewsServlet?method=${searchMethod }&pc=${pb.pc+1 }&tid=${tids }"/>">下一页</a>
  </c:if>
  <a href="<c:url value="/NewsServlet?method=${searchMethod }&pc=${pb.tp }&tid=${tids }"/>">尾页</a>
</c:if>
<c:if test="${empty pb.beanList }">该分类还没有新闻！</c:if>
  </center>
  </body>
 
</html>
