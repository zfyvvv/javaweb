package login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 1.新建项目需进行tomcat的ployed配置，将class文件配置到webinf下面；
 * 2.新建Servletw文件（已经继承的class文件），需进行xml文件配置，即修改别名，以进行访问；
 * @author DELL
 *
 */
public class Page extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		//req对象的作用域；//代码优化；
		String str=(String) req.getAttribute("str")==null?"":(String) req.getAttribute("str");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<font color='red' size='10px'>"+str+"</font>");
		resp.getWriter().write("<form action='login'  method='get'>");
		resp.getWriter().write("用户名：<input type='text' name='uname' value=''/><br/>");
		resp.getWriter().write("密码：<input type='password' name='pwd' value=''/><br/>");
		resp.getWriter().write("<input type='submit'  value='登录'/><br/>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		
		/*if(str!=null){
			resp.getWriter().write("<html>");
			resp.getWriter().write("<head>");
			resp.getWriter().write("</head>");
			resp.getWriter().write("<body>");
			resp.getWriter().write("<font color='red' size='10px'>"+str+"</font>");
			resp.getWriter().write("<form action='login'  method='get'>");
			resp.getWriter().write("用户名：<input type='text' name='uname' value=''/><br/>");
			resp.getWriter().write("密码：<input type='password' name='pwd' value=''/><br/>");
			resp.getWriter().write("<input type='submit'  value='登录'/><br/>");
			resp.getWriter().write("</form>");
			resp.getWriter().write("</body>");
			resp.getWriter().write("</html>");
		}else{
			resp.getWriter().write("<html>");
			resp.getWriter().write("<head>");
			resp.getWriter().write("</head>");
			resp.getWriter().write("<body>");
			//resp.getWriter().write("<font color='red' size='20px'>"+str+"</font>");
			resp.getWriter().write("<form action='login'  method='get'>");
			resp.getWriter().write("用户名：<input type='text' name='uname' value=''/><br/>");
			resp.getWriter().write("密码：<input type='password' name='pwd' value=''/><br/>");
			resp.getWriter().write("<input type='submit'  value='登录'/><br/>");
			resp.getWriter().write("</form>");
			resp.getWriter().write("</body>");
			resp.getWriter().write("</html>");
		}*/
		
		
	}

}
