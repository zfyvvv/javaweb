package context;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servletcontext:--->居然和自己的类名重合了，尴尬！！
 * 	问题：解决不用用户数据共享问题；
 * 	特点：服务器创建，用户共享，
 * 	作用域：一个项目内有效，
 * 	生命周期：服务器启动到关闭；
 * 	使用：不同用户的不同请求均可拿到；
 * 		获取ServletContext对象：三种方式
 * 		ServletContext对象储存和获取数据：
 * 		sc.setAttribute("str","ServletContext对象学习！");
 * 		ServletContext sc=this.getServletContext();sc.getAttribute("str")
 * 		注意：一个用户存，另一个用户取；不同的用户可以对ServletContext对象进行存取；
 * 		获取的数据不存在时，返回为null；
 * 	获取项目中web.xml文件中全局变量的配置；也可以获得所有的配置参数的值；
 * 		web.xml中：<context-param>//注意一组标签只能存储一组键值对，多组可以声明多个<context-param>
  					<param-name>name</param-name>
  					<param-value>zhangsan</param-value>
  				</context-param>
  		java程序中：String str=sc.getInitParameter("name");	
  				sc.getInitParameterNames() 返回键名的枚举；
  		作用：将静态数据和代码进行解耦，
  	获取项目webroot下资源的绝对路径：
  		sc.getRealPath("String path");获取的是项目的根目录，path为项目根目录下的对象；
  	获取webroot项目根目录下资源的对象
  		InputStream is=sc.getResourceAsStream("/doc/1.txt");
  		注意：此种方式只能获得项目根目录下的资源文件，claa文件的流对象需要使用类加载器获取；
  ServletConfig对象：为每个Servlet单独配的对象，可以理解为秘书；
 * @author DELL
 *
 */
public class Context extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取Context对象，三种方式拿到的是同一个对象；
			//方式一
			ServletContext sc=this.getServletContext();
			//方式二
			ServletContext sc2=this.getServletConfig().getServletContext();
			//方式三
			ServletContext sc3=req.getSession().getServletContext();
		//使用ServletContext对象完成数据的共享
			sc.setAttribute("str","ServletContext对象学习！");
		//获取项目中web.xml文件中全局变量的配置；
			String str=sc.getInitParameter("name");
		//sc.getInitParameterNames()
			System.out.println("全局配置参数："+str);
		//获取项目webroot下资源的绝对路径：
			// String path="D:\\Program Files\\Apache Software Foundation\\
				//Tomcat 7.0\\webapps\\context\\doc\\1.txt";
			String path=sc.getRealPath("/doc/1.txt");
			System.out.println(path);
		//获取webroot项目根目录下资源的对象
		InputStream is=sc.getResourceAsStream("/doc/1.txt");
		
	}
	

}
