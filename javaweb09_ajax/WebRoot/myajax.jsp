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
	<!-- 
	Ajax学习：
		1.ajax的概念：
			局部刷新技术。不是一门新技术，是多种技术的组合，是浏览器端的技术；
		2.ajax的作用：
			实现在当前结果页面中显示其他请求的响应内容；
		3.ajax的使用
			ajax的基本使用流程：
				//创建ajax引擎对象；
				//复写ajax.onreadystatechange
					//判断ajax状态码
						//判断响应状态码
							//获取响应内容（响应内容的格式，补充内容）
								//普通字符城：ajax.responseText;
								//json（重点）：其实也是一种字符串；ajax.responseText;
									把java中User u的一个对象，转换成js可以解析的obj对象；
									其实就是将数据按照json格式拼接好的字符串，方便使用eval（）方法；
									将接受到的字符串直接转换成js对象；
									Json格式：->网上有资源；JSON!
									var 对象名={
										属性名：属性值；
										属性名：属性值；
										...
									}
								//XML数据：ajax.responseXML;返回document对象；
								记得把表头的text/html->text/xml;
								
							//处理响应内容（js操作文档结构）	
				//发送请求
					//get请求
						get的请求实体拼接在URL后面，？隔开，键值对；
						ajax.open("get", "ajax?name=张三&pwd=333",true);//请求的相关信息：方式，地址
						ajax.send(null);//正式请求，请求数据，如果为get，请求数据应该在请求地址后面；如果为post，数据单独发；
					//post请求：请求实体单独发送；
						ajax.open("post", "ajax");
						字节码数据传递的时候，以键值对的形式提交；方便服务器解析数据；
						ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
						ajax.send("name=张三&pwd=333");
					
			4.ajax的状态码
				ajax状态码
					readyState:0,1,2,3,4
						4表示响应内容被成功接收；
				响应状态码
					status:
					200:OK
					404：资源未找到
					405：请求方式和后台处理请求方式不匹配；
					500：服务器繁忙（内部服务器错误）
			5.ajax的异步和同步
				ajax.open(method,url,async)
				async:设置代码同步|异步执行；true代表异步，默认也是异步；false代表同步；
			6.ajax的封装：
				传进去的参数为：method;url;data;响应状态码；（！！！！）
	 -->
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
						//获取元素对象
						var showdiv=document.getElementById("showdiv");
						//获取元素内容
						showdiv.innerHTML=result;
					}else if(ajax.status==404){
						var showdiv=document.getElementById("showdiv");
						showdiv.innerHTML="请求资源不存在！";
					}else if(ajax.status==404){
						var showdiv=document.getElementById("showdiv");
						showdiv.innerHTML="服务器繁忙！";
					}
				}else{
					var showdiv=document.getElementById("showdiv");
					showdiv.innerHTML="<img src='img/1.gif' width='200px' heigth='100px'/>";
				}
			}
			//发送请求
			ajax.open("get", "ajax",true);//请求的相关信息：方式，地址
			ajax.send(null);//正式请求，请求数据，如果为get，请求数据应该在请求地址后面；如果为post，数据单独发；
			alert("哈哈哈哈！");//等待Ajax之后，打印“哈哈”——>同步；不等待Ajax，打印“哈哈”->异步！
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
