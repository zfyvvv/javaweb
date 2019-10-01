<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
JSTL的学习;
	作用：使用逻辑标签提供jsp中逻辑代码的编写效率；底层还是java
	使用：
		JSTL的核心标签库（重点）
		JSTL的格式化标签库（讲解）
		JSTL的SQL标签库
		JSTL的函数标签库
		JSTL的XML标签库
	JSTL的核心标签库：
		1.声明jar包；myeclispe中自带有，eclipse中需要导入；Apache提供的
		2.声明JSTL标签的引入；
			<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		3.内容：
			基本标签：取、存、删
				<c:out value="数据" default="默认值"></c:out>
					数据可以常量，也可以是EL表达式；
					作用：将数据输出给客户端；
				<c:set var="hellow" value="hellow pagecontext" scope="page"></c:set><br/>
					作用：将数据存储到作用域中，
					var:键名
					value：储存的数据
					scope：要存储的作用域对象，page request session application
				<c:remove var="hellow" scope="page"/><br/>
					作用：删除作用域中指定键的数据；
					var:要删除的键名
					scope：指定作用域，可选
						如果不选，则默认删除所有该键名的数据；
			判断标签
				<c:if test="${判断条件}">
					前端代码
				</c:if>
				作用：相当于java中的单分支判断；
				注意：逻辑判断依赖于EL中的逻辑判断，数据从作用域中取；
				<c:choose>
					<c:when test="${表达式}">前端代码</c:when>
					<c:when test="${表达式}">前端代码</c:when>
					...
					<c:otherwise>前端代码</c:otherwise>
				</c:choose>
				作用：多分支条件判断，类似java中的多分支判断
			循环标签
				<c:forEach begin="1" end="4" step="2" varStatus="vs">
					前端代码
				</c:forEach>
				使用：
					begin:起始位置
					end:结束位置
					step：步长
					varStatus:声明变量每次循环的数据（角标，次数，是否第一次或最后一次）
						注意：数据存储在作用域中，需通过EL表达式进行
						${vs.index}--${vs.count}-${vs.first}--${vs.last}
					items:声明要遍历的对象，结合EL表达式
				遍历List
				<c:forEach items="${参数}" var="str">
					${表达式}<br/>
				</c:forEach>
				使用：
				遍历Map
				<c:forEach items="${map}" var="m">
					${m.key}--${m.value}--${m}<br/>
				</c:forEach>
				注意：获取值为key和value；
	JSTL的格式化标签库（讲解）
		1.声明jar包
		2.声明JSTL标签的引入；相对应
		3.常用标签：
	...
--%>
<b>JSTL基本标签的学习</b><br/>
<%
String str="haha";
%>
<c:out value="哈哈"></c:out>--哈哈--${str} <br/>
<c:out value="${str2}"  default="嘿嘿"></c:out>
<c:set var="hellow" value="hellow pagecontext" scope="page"></c:set><br/>
<c:set var="hellow" value="hellow request" scope="request"></c:set><br/>
<c:out value="${pageScope.hellow} "></c:out><br/>
<c:out value="${requestScope.hellow} "></c:out><br/>
<c:remove var="hellow" scope="page"/><br/>
<c:out value="${pageScope.hellow} "></c:out><br/>
<c:out value="${requestScope.hellow} "></c:out><br/>
<hr/>
<b>JSTL逻辑标签的学习</b><br/>
<%-- jsp源码实现 --%>
<%
	int a=2;
	if(a<3){
%>
<b>a的值小于3</b><br/>
<%} %>
<%-- jsp源码实现 --%>
<c:set var="a" value="2"></c:set>
<c:if test="${a<3}">
	<b>a的值小于3,jstl</b><br/>
</c:if>
<c:set var="score" value="30"></c:set>
<c:choose>
	<c:when test="${score>80}"><b>优秀！</b><br/></c:when>
	<c:when test="${score>60&&score<80}"><b>及格！</b><br/></c:when>
	<c:otherwise><b>继续努力！</b><br/></c:otherwise>
</c:choose>
<c:forEach begin="1" end="4" step="2" varStatus="vs">
	11111--${vs.index}--${vs.count}-${vs.first}--${vs.last}<br/>
</c:forEach>
<%
	List list=new ArrayList();
	list.add("a");
	list.add("b");
	list.add("c");
	request.setAttribute("list", list);
	
	Map map=new HashMap();
	map.put("a", "aa");
	map.put("b", "bb");
	request.setAttribute("map", map);
	
%>
<c:forEach items="${list}" var="str">
	${str}<br/>
</c:forEach>
<c:forEach items="${map}" var="m">
	${m.key}--${m.value}--${m}<br/>
</c:forEach>
















