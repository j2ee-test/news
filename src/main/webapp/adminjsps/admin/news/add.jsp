<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加新闻</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
<style type="text/css">
	body {background: rgb(254,238,189);}
	table {font-family: 宋体; font-size: 11pt; border-color: rgb(78,78,78);  width: 60%;}
	#th {background: rgb(78,78,78);}
	
	.input{
		border:0;
	}
</style>

  <body>
  <h2 style="text-align: center;">添加新闻</h2>
 <div class="div-out"> 
 <form action="<c:url value="/admin/AdminNewsServlet"/>" method="post" onsubmit="return checkaaa()"/>
	<table width="600" align="center" border="1">
		<tbody>
			<input type="hidden" name="method" value="add" />
			<tr><td>标题：</td><td>
					<input class="input" type="text" size="100" name="caption" id="caption"></td>
			</tr>
			<tr><td>正文：</td><td style="height:300px;">
					<input class="input" style="height:500px;" type="text" size="100" name="content" id="content"></td>
			</tr>
			<tr><td>类型：</td><td>
					<select name="newsType" id="newsType">
					<c:forEach items="${newsTypeList}"  var="newsType">      
				   		<option value="${newsType.tname}">${newsType.tname}</option>
					</c:forEach>								
					</select>
				</td>
			</tr>
			<tr>
				<td>作者：${sessionScope.session_user }</td>
				<td><input style="background-color:#E0E0E0;" readonly=" readonly="true" type="text" name="author" value="123"/></td>
			</tr>
			<tr>
				<td>日期：</td>
				<td><input type="datetime-local" name="newsTime" id="newsTime"></td>
			</tr>
			<tr>
				<td colspan="2">    
					<div>
    					<script id="content" type="text/plain" style="width:800px;height:500px;"></script>
					</div>
	</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input style="text-align:center" type="submit" value="添加新闻"></td>
			</tr>
		</tbody>
	</table>
</form>
</div>
<script type="text/javascript">

	function checkaaa(){
		var caption = document.getElementById("caption").value;
		var content = document.getElementById("content").value;
		var newsType = document.getElementById("newsType").value;
		var newsTime = document.getElementById("newsTime").value;	
		if(caption.trim() == "" || content.trim() == "" || newsType.trim() == "" || newsTime.trim() == ""){
			alert("您还有没有填写的部分。请填写完整后提交！");
			return false;
		}else
		return true;
	}
</script>
</body>
</html>
