<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page session="true" %>
<%@page errorPage="error.jsp" %>
<%@page isErrorPage="true" %>
<%-- 
JSP介绍：将java,servlet/html语言综合在一起的语言；本质为一个servlet！
JSp运行原理：服务器—>tomcat->JSP文件转译servlet->响应服务器；
JSP三种注释：
	前端语言注释：会被转译，也会被发送，但是不会被浏览器执行;<!-- 
	java语言注释：会被转译，但是不会被servlet执行（不会发送，更不会被浏览器执行）；//
	Jsp注释是：不会被转译；“<%--  
	
Jsp的page指令学习：
	jsp文件转译成servlet的设置工作；
	<%@ page 属性名="属性值"  属性名="属性值"...%>
	属性：
	language:声明jsp要被转译成的语言；
	import：声明转译的java文件导入的包，不同的包使用逗号隔开；
	pageEncoding:当前文件保存数据的格式；（我们写文件数据使用的是utf-8,底层转译成java文件也是utf-8，故不会乱码；）
	contentType:设置jsp数据响应给浏览器时，浏览器解析和编码的格式；
	session:设置转译的servlet文件中是否开启session支持，默认为开启，false表示关闭；
	errorpage:设置jsp运行错误跳转的页面；
	extends:设置jsp转译成java文件要继承的父类（包名&类名）
	作用：配置jsp文件转译java相关的参数；
	
jsp的局部代码块：
	特点：
		局部代码块中声明的java代码都会原样转译到jsp对应的servlet文件的_Jspservice方法中；
		使用：<%  java代码  %>
	缺点：如果进行逻辑判断，书写麻烦，阅读困难；->servlte 做逻辑输出；jsp，做页面处理，尽量不要使用jsp做逻辑处理
jsp的全局代码块：
	特点：声明的java代码作为全局代码转译到对应的servlet类中；
	使用：<%!   全局代码%>
	注意：要在局部代码块中进行调用；注意不要写错位置，写错还不报错！！
	
jsp的脚本段语句：
	特点：帮助我们快速的获取变量值或者方法的返回值作为数据响应给浏览器；
	使用：	String str="jsp中使用逻辑效验数据很难受！！!!!";
			<b><%out.write(str); %></b>  <==><% =变量名|方法%>
	注意：变量|方法后面不要加分号；
	位置：除jsp文件配置的任意位置；
	
jsp的静态引入&动态引入：
	静态引入：
		<%@include file="相对路径" %>
		特点：当前jsp和引入jsp转译成一个servlet文件；在网页中显示合并后的页面；
		注意：静态引入的jsp文件不会单独转译成一个servlet文件；不能使用java代码中声明的同名变量；
	动态引入：
		<jsp:include page="相对路径"></jsp:include>
		特点：没有合成一个servlet文件； 会将引入的文件单独转译，在当前文件转译好的java文件中
			调用引入的jsp文件的转译文件；
			在网页中显示合并后的显示效果（同静态引入）
		注意：
			动态引入中允许文件中声明同名变量；
		降低jsp代码的冗余，便于维护升级；如果同名变量较多，推荐使用动态引入；
		
jsp的转发标签：
	<jsp:forward page="forward.jsp"></jsp:forward>
	一次请求，地址栏信息不变；
	注意：在转发标签中间除了写<jsp:param name="str" value="aaa"/>子标签不会报错，其他任意标签都会报错；
		该子标签可以给一次请求内部条件数据，以键值对的形式存在；相当于给request对象封存了数据；
		附带数据以？号形式拼接在request对象后面；
	取的方法：request.getParameter("str")
	
jsp九大内置对象：直接拿这些对象，进行操作；转译成servlet时，自动生成并声明的对象；
	注意：只能写在局部代码块|脚本语言中，即servlet中的service（）中；不能再全局代码块中使用；
	内容：
		pageContext：页面上下文对象，里面封存了其他的8个对象；可以通过它获取其他8个对象；封存jsp运行信息；
			注意：一个jsp只用一个pagecontext对象，!
			作用域：当前页面，只用当前jsp（转译成的servlet中service（））中；!
		request：封存当前请求数据的对象，有Tomcat服务器创建；!
		session：此对象用来储存用户的不同请求的共享数据，一次会话；!
		application：就是servletcontext对象，一个项目只有一个，存储用户共享数据，以及完成其他操作等，项目内；
		response：响应对象，用来响应请求处理结果给浏览器的对象；设置响应头，重定向；
		out：响应对象，jsp内部使用，带有缓冲区的响应对象，效率高于response对象，但不能设置响应头；
		page：代表当前jsp的对象，相当于java中的this；
		exception:异常对象，储存当前 运行的异常信息；
			注意：使用此对象需要在page指定中使用属性isErrorPage="true"开启；
		config:也就是servletconfig对象，获取xml中的配置数据完成一些初始化数据的读取；
		
	四个作用域对象：
		pagecontext：当前页面，解决当前页面内的数据共享问题；范围窄，使用少，获取当前页面的其他内置对象；
		request：一次请求，一次请求内servlet的数据共享；通过请求转发，将数据流转到下一个servlet；请求转发
		session：一次会话，一个用户的请求的数据共享；一个用户，将数据从一次请求流转给其他请求；重定向
		application：项目内，不用用户的数据共享问题；将数据从一个用户流转给其他用户；项目共享数据；
		作用：数据流转；
		
	jsp的路径：
		相对路径：<a href="a.jsp">a.jsp</a>
			/资源名；可以完成跳转，
			但是：一，资源的位置不可以随意改动；二需要使用../进行文件夹的跳出，使用比较麻烦；
		绝对路径：<a href="/jsp/b.jsp">b.jsp</a>
			/虚拟项目名/资源资源路径
			注意：jsp中资源路径的第一个/表示服务器根目录，相当于:localhsot:8080;
		使用jsp自带 的全局路径声明：-->相当于绝对路径；
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>	
		<base href="<%=basePath%>">
		作用：
			给资源前面自动添加项目路径  http://127.0.0.1:8080/虚拟项目名/
		
		重点使用第二个，第三种方式是myeclispe中自带的！
	
 --%>
 <html>
 	<head>
 		<title>jsp基本语法学习</title>
 		<meta charset="utf-8" />
 	</head>
 	<body>
 		<h3>jsp基本语法学习</h3>
 		<hr />
 		<!-- 局部代码块 -->
 		<%
 			//声明java代码域
 			String str="jsp中使用逻辑效验数据很难受！！!!!";
 			int a=2;
 			if(a>3){
 		%>
 		<b>jsp学习很简单！！</b>
 		<%} else{ %>
 		<b><%=str%></b>
 		<%text();} %>
 		<!--全局代码块  -->
 		<%!
 		int b=5;
 		public void text(){
 			System.out.println("我是全局代码块声明！！");
 		}
 		%>
 		<%-- <!--jsp的静态引入  -->
 		<%@include file="includeStatic.jsp" %>
 		<!--jsp的动态引入  -->
 		<jsp:include page="includeActive.jsp"></jsp:include>
 		<!-- jsp的转发标签 -->
 		<jsp:forward page="forward.jsp">
 			<jsp:param name="str" value="aaa"/>
 		</jsp:forward>  --%>
 		<!-- jsp的九大内置对象学习 -->
 		<%
    	String s=request.getParameter("str2");
    	request.getAttribute("str2");
    	%>
    	
    	<!-- jsp文件的路径 -->
    	<br>
    	<a href="a.jsp">a.jsp</a>
    	<br>
    	<a href="/jsp/b.jsp">b.jsp</a>
 			
 	</body>
 </html>
 
 
 
 
 
 
 
 