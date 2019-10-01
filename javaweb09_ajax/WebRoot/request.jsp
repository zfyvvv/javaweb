<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myjsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 声明js代码域 -->
	<script type="text/javascript">
	function getData(){
			//创建Ajax引擎对象
				var ajax;
				if(window.XMLHttpRequest){//火狐浏览器
					ajax=new XMLHttpRequest();
				}else if(window.ActiveXObject){//IE浏览器
					ajax=new ActiveXObject("Msxml2.XMLHTTP");
				}
			//复写onreadystatement函数
			ajax.onreadystatechange=function(){//onreadystatechange是一个监听函数；
				//判断Ajax的状态码
				if(ajax.readyState==4){//当状态码为4的时候，才执行；if也执行了4次，里面的内容执行一次；
					//判断响应状态码
					if(ajax.status==200){//添加必要的逻辑判断，更加合理！
						//获取响应内容；
						var result=ajax.responseText;
						//处理响应内容
						alert(result);
					}
			}
			}
			//发送请求
				//get()方式：请求实体拼接在URL后面
					//ajax.open("get", "ajax?name=张三&pwd=333",true);//请求的相关信息：方式，地址
					//ajax.send(null);//正式请求，请求数据，如果为get，请求数据应该在请求地址后面；如果为post，数据单独发；
				//psot方式：请求实体需要单独的发送；
					ajax.open("post", "ajax");
					//字节码数据传递的时候，以键值对的形式提交；方便服务器解析数据；
					ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					ajax.send("name=张三&pwd=333");
	}
	</script>
	<style type="text/css">
	#showdiv{
		border:solid 1px ;
		width:200px;
		height:100px;
	}
	</style>
  </head>
  
  <body>
    <h3>欢迎来到王者峡谷</h3>
    <input type="button" value="测试" onclick="getData()">
    <div id="showdiv">
    
    </div>
  </body>
</html>
