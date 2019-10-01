package login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.pojo.User;

public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//获取请求信息
		HttpSession hs=req.getSession();
		if(hs.getAttribute("user")==null){//判断u是否为空，如果是重定向到登录页面；防止用户30分钟后重新登录，出现空指针异常；
		resp.sendRedirect("/login/ck");
		return;
		}
		User u=(User) hs.getAttribute("user");
		//处理请求信息
		//响应请求信息；
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<hr>");
		resp.getWriter().write("<table border='1px'>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<td>用户名</td>");
		resp.getWriter().write("<td>"+u.getName()+"</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<td>密码</td>");
		resp.getWriter().write("<td>"+u.getPwd()+"</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("<table>");
		resp.getWriter().write("</table>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		
		
	}

}
