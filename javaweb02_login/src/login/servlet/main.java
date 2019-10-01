package login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.pojo.User;

public class main extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取session对象数据；
		HttpSession hs=req.getSession();
		User u=(User) hs.getAttribute("user");
		//获取ServletContext对象的数据
		int nums=(int) this.getServletContext().getAttribute("nums");
		
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<h3>欢迎"+u.getName()+"访问学生管理系统</h3>");
		resp.getWriter().write("当前网页浏览次数为："+nums);
		resp.getWriter().write("<hr>");
		resp.getWriter().write("<form action='show' method='get' >");
		resp.getWriter().write("<input type='submit' value='查看个人信息'>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");

	}

}
