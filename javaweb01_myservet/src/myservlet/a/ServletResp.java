package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletResponse对象：
 * 	用来响应数据到浏览器的一个对象
 * 	设置响应头
 * 	设置响应状态码
 * 	设置响应实体
 * 
 * 总结：service()请求处理代码流程：
 * 	设置响应编码格式
 * 	获取请求数据-->req
 * 	处理请求数据-->java 代码
 * 		数据库思想（MVC）
 * 响应处理结果-->resp
 * @author DELL
 *
 */
public class ServletResp extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取请求信息
		//处理请求信息
		//响应请求信息
			//设置响应头
			resp.setHeader("key", "logitech");
			resp.addHeader("sb", "zfy");
			resp.addHeader("sb", "xsb");
			//resp.setHeader("content-type", "text/html;charset=utf-8");
			resp.setContentType("text/html;charset=utf-8");
			//resp.setContentType("text/xml;charset=utf-8");
			//resp.setContentType("text/plain;charset=utf-8");
			//设置响应状态码
			//resp.sendError(404, "this is error!");
			//设置响应实体
			resp.getWriter().write("<b>this is my resp!</b>");
			//resp.getWriter().write("好好学习，天天向上！");
	}

}
