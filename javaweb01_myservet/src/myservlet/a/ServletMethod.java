package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * service()|doget()|dopost()比较：
 * 	service():可以处理get|post请求，会优先使用；
 * 	doget():处理get请求；
 * 	dopost():处理post请求；
 * 注意：
 * 	如果service()中写有super.service(req, resp),service()完成后会再次根据请求方式调用doget()|dopost()；
 * 	一般不覆写super.service(req, resp)方法，如果覆写后没有写doget()|dopost()，会出现405错误；
 * 	只写service()就可以了，在service()里面进行判断；
 * 
 * Servlet中常见的错误l
 * 	404:资源未找到；
 *		URL中的别名错误；URL中的虚拟项目名称拼写错误；
 *	500：  
 *		ClassNotFound 一般为xml中配置的类名写错，可以有ctrl进行验证；i/0,方法体中代码执行错误;
 *	405:请求方式和servlet中的方法不匹配；请求方式不支持；
 *		尽量使用service()，且不要调用父类中的service()；
 * @author DELL
 *
 */
public class ServletMethod extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("我是service().......");
		super.service(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("我是doGet().......");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("我是doPost().......");
	}
}
