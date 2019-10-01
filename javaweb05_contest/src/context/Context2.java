package context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//创建Context对象，三种方式拿到的是同一个对象；
				ServletContext sc=this.getServletContext();
				//获取数据
				System.out.println("Context2.service()"+":"+sc.getAttribute("str"));
	}

}
