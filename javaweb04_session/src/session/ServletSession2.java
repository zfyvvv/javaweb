package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSession2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession hs=req.getSession();
		System.out.println("ServletSession2.service()"+hs.getId());
		//必须保证取到的是同一个session，session没有失效，即没有关闭浏览器
		System.out.println("ServletSession2.service()"+":"+hs.getAttribute("name"));
	}

}
