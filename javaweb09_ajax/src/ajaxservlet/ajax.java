package ajaxservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//获取请求信息
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		System.out.println(name+":"+pwd+":"+req.getMethod());
		
		resp.getWriter().write("今天在王者峡谷遇见一个傻瓜！！");
	}
}
