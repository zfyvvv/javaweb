package cookie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 1.获取cookie数组；
 * 2.针对cookie数组，可以通过遍历找出；
 * @author DELL
 *
 */
public class GetCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html,charset=utf-8");
		//获取请求信息
			//获取cookie信息
			Cookie[] cks=req.getCookies();
			if(cks!=null){//防止空指针异常！
				for(Cookie c:cks){
					String name=c.getName();
					String value=c.getValue();
					System.out.println(name+":"+value);
				}
			}
			//获取用户信息
		//处理请求信息
	}
}
