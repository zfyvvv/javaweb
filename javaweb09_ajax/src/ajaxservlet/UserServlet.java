package ajaxservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.User;
import service.UserService;
import serviceImp.UserServiceImp;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//获取请求信息
		String name=req.getParameter("name");
		//System.out.println("用户请求信息为："+name);
		//处理请求信息
			//获取业务层对象
			UserService us=new UserServiceImp();
			User u=us.getUserInfoService(name);
			System.out.println("成功！");
		//响应处理结果
			//把javav对象转换成js对象；
		resp.getWriter().write("{name:'张三',pwd:333}");
		
	}

}
