package myservlet.a;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 3-Servlet生命周期：
 * 	1、从第一次调用到服务器关闭；
 * 	2、如果web.xml文件中配置有load-on-startup,生命周期为服务器启动到服务器关闭；
 * 注意：
 * 	init()是Servlet初始化执行，即第一次加载进内存时候执行；
 * 	destroy()是Servlet被销毁时执行，即服务器关闭时执行；
 * @author DELL
 *
 */
public class ServletLife extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet初始化...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("servlet life!");
		resp.getWriter().write("servlet life22222");
		System.out.println("servlet life!");
		System.out.println("servlet life22222");
	}
	
	@Override
	public void destroy() {
		System.out.println("我被销毁了...");
	}
}
