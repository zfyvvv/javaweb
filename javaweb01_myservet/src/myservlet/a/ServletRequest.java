package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet request对象：
 * 	request对象封存当前请求的所有请求信息；可以获取请求头数据，请求行数据以及请求用户数据；
 * 	该对象是由tomcat创建，并作为实参传递给Servlet的service（）中，
 * 	当获取请求数据不存在时，程序不会报错，会出现null；故需提前判断；
 * @author DELL
 */
public class ServletRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//请求头数据；
		System.out.println(req.getMethod());//获取请求方式
		System.out.println(req.getRequestURL());//获取请求URL
		System.out.println(req.getRequestURI());//获取请求URI
		System.out.println(req.getScheme());//获取请求协议；
		//请求行数据（键值对）
		String str=req.getHeader("User-Agent");//获取指定行数据，也可以获得所有行数据；
		System.out.println(str);// Mozilla/5.0 ...
		//获取用户数据；
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");//不能获得同键不同值的多项选择；即多选
		System.out.println(name+":"+pwd);//可以使用String[] str=req.getParameterValues();
	}
}
