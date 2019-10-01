<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'data.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	需求分析：
		1.在当前页面显示结果，使用ajax技术；
		2.创建ajax函数
		3.调用ajax函数发送请求到userservlet
		4.调用业务层获取对应的数据；
	-->
	<!-- 声明JS代码域 -->
	<script type="text/javascript">
	function getData(){
		//获取用户信息
		var name=document.getElementById("uname").value;//var name=document.getElementId("uname");!!
		//创建引擎
		var ajax;
		if(window.XMLHttpRequest){
			ajax=new XMLHttpRequest();
		}else if(window.ActiveXObject){
			ajax=new ActiveXObject("Msxml2.XMLHTTP");
		}
		//复写onreadystatechange()
		ajax.onreadystatechange=function(){
			if(ajax.readyState==4){
				if(ajax.status==200){
					var result=ajax.responseText;
					eval("var obj="+result);
					alert(1111111);
					
				}
			}
		}
		//发送请求
		ajax.open("get", "user?name="+name);
		ajax.send(null);
	}
	</script>
  </head>
  
  <body>
    <h3>欢迎访问英雄商店</h3>
    <hr>
    英雄名称：<input type="text" name="uname"	value=""	id="uname">
    	<input type="button"	value="搜索" onclick="getData()">
    <hr>
    <table border="1px">
    	<tr>
    	<td>编号</td>
    	<td>名称</td>
    	<td>价格</td>
    	<td>位置</td>
    	<td>描述</td>
    	</tr>
    </table>
    
  </body>
</html>
