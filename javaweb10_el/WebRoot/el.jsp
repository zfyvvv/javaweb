<%@ page language="java" import="java.util.*,zfy.po.*" pageEncoding="utf-8"%>
<!-- 使用传统方式获取作用域对象的数据 -->
<h3>EL表达式学习：使用传统方式获取作用域对象的数据</h3>
<%=request.getParameter("uname") %><br/>
<%=request.getAttribute("str") %><br/>
<%=((User)request.getAttribute("user")).getName() %><br/>
<%=((User)request.getAttribute("user")).getAdd().getCountry() %><br/>
<%=((List)request.getAttribute("list")).get(0) %><br/>
<%=((User)((List)request.getAttribute("list2")).get(0)).getName() %><br/>
<%=((Map)request.getAttribute("map")).get("name")%>
<%-- 
传统方式获取作用域的问题：
	1.需要导包  2.需要强转  3.繁琐
EL表达式：
	语法：${表达式}
		表达式：
			1.获取请求数据：
				request对象存储的数据->param.键名；返回是一个值；注意大小写！
				request对象存储的数据->paramValues.键名  返回的是一个数组；
			2.获取setAttribute()存储的数据；
				${键名} 返回键名对应的值；
				注意：存储普通字符串->直接返回值
					 存储对象->返回对象；
					 		获取对象中的数据；
					 		普通对象：
					 			${键名.属性名.属性名...}
					 		集合对象：
					 			List集合->${键名[角标]}
					 			Map集合->${键名.map集合中的键名}
	作用域的查找顺序：
		默认查找顺序：
			pageContext->request->session->application
		注意：每次都从小查找，找到以后便不再查找；
		指定查找：
		${pageScope.hellow}
		${requestScope.hellow}
		${sessionScope.hellow}
		${applicationScope.hellow}
	EL的逻辑运算：
		${算术运算符}
		${逻辑运算符}
		注意：+表示算术运算，不表示字符串的连接，会报错；
	EL的空值判断：
		${empty 键名}
		作用:判断键名对象的值是否存在；
	EL请求头数据和cookie数据：
		获取请求头数据
			${header}->返回所有请求头数据；
			${header[键名]}->返回指定键名的请求头数据；
			${headerValues[键名]}->返回指定键名（同键不同值）的值的数组；
		获取cookie数据
			${cookie}->返回所有的存储cookie对象的map集合；
			${cookie.键名}->返回指定cookie的对象；
			${cookie.键名.name}->返回指定cookie的对象存储数据的键名；
			${cookie.键名.value}->返回指定cookie的对象存储数据的值；
			
		
 --%>
 
<h3>EL表达式学习:新方法！</h3>
<b>${param.uname}</b><br/>
<b>${paramValues.fav[0]}</b><br/>
<b>${str}</b><br/>
<b>${user.name}</b><br/>
<b>${user.add.country}</b><br/>
<b>${list[0]}</b><br/>
<b>${list2[0].name}</b><br/>
<b>${map.name}</b><br/>
<%
	pageContext.setAttribute("hellow", "hello,pagecontext!");
	request.setAttribute("hellow", "hello,pagecontext!");
	session.setAttribute("hellow", "hello,pagecontext!");
	application.setAttribute("hellow", "hello,pagecontext!");

%>
  <b>${hellow}</b>
  <b>${pageScope.hellow}-${requestScope.hellow}-${sessionScope.hellow}-${applicationScope.hellow} </b>
  
  
  
  
  
  
  
