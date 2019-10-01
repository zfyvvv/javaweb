package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * session技术学习：
 * 	问题：同一个用户不同的请求处理的数据共享问题（张三不能拿到李四的数据）
 * 	解决：使用session技术；(java中存储数据的是变量和对象)
 * 	原理：由于数据不止一个，故使用对象去保存数据；那么怎么保存对象呢？怎么去取对象呢？
 * 		在服务器端根据此用户的请求创建与该用户相关的对象，并用cookie技术把该对象的ID值（JESESSIONID）存到浏览器端；
 * 		第一次请求是没有的，用户第一次访问服务器，服务器创建一个session对象；使用cookie技术存到浏览器；
 * 		当用户再次请求时，根据JESESSIONID值获取session对象；
 * 	特点：储存在服务器端；由服务器创建；依赖cookie技术；有效期为一次会话（浏览器一直在使用，未关闭；）；
 * 		服务器中默认存储时间为30分钟；
 * 	使用：HttpSession hs=req.getSession();//即使创建又是获取；
 * 		如果请求中拥有session的标识符（JESESSIONID），则返回其对应的session对象、
 * 		如果请求中没有用session的标识符（JESESSIONID），则创建新的session对象，并将其ID作为cookie数据存储到浏览器中；
 * 		如果session对象失效了，也会重新创建一个session对象，并将其JESESSIONID存储在浏览器内存中；
 * 		设置session存储时间：
 * 			hs.setMaxInactiveInterval(5);
 * 			注意：没有使用则销毁；使用则重新计时；
 * 		设置session的强制失效：hs.invalidate();
 * 		存储和取出数据：
 * 			hs.setAttribute("name", name);hs.getAttribute("name")	
 * 			注意：存储的动作和取出的动作发生在不同的请求中，但是存储要先于取出；（不同的请求，不是不同的servlet！）
 * 			一般是在一个servlet中存取，在另一个servlet中取出；
 * 		使用时机：
 * 			一般会把在数据库中查到的User对象存储到session中
 * 			一般用户在登录WEB项目时会将用户的个人信息存储到session中，供该用户的其他请求使用；
 * 		总结：解决一个用户的不同请求的数据共享问题；
 * 			只要jesesionid不失效和session对象不失效的情况下，用户的任意请求在处理时都能获取到同一session对象；
 * 		作用域：一次会话；该用户；在JESESSION和session不失效的情况下为整个项目内；
 * 				失效则重新登录；
 * 		失效的两种情况：用户把浏览器关闭，用户没有关浏览器，但session在服务器中失效，已经创建新的session；
 * 		失效处理：
 * 			通过对比用户请求的sessionid和后台获取的sessionID做对比，如果不一致则失效；
 * 			可以重定向到登录页面，让用户重新登录；
 * 		修改失效默认时间：tomcat-->session-config-->session-timeout-->30!
 * 注意：1.JESESSIONID存储在cookie的临时存储空间中，浏览器关闭即失效；（浏览器关闭，打开后即新建新的session对象）
 * 		 2.
 * req:一次请求内数据共享问题；
 * session:同一个用户不同请求的数据共享问题；
 * ServletContext:不同用户的数据共享问题-->一个项目只用一个，不同的用户拿到的只用那一个！由服务器创建，用户共享；
 * 				生命周期：从服务器开始到服务器关闭；
 * @author DELL
 *
 */
public class ServletSession extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式；
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息；
			String name="张三";
		//处理请求信息；
			//创建session对象
			HttpSession hs=req.getSession();//即使创建又是获取；
			System.out.println(hs.getId());
			//设置session的有效期；
			//hs.setMaxInactiveInterval(5);
			//设置session的强制失效；
			//hs.invalidate();
			//存储数据a
			hs.setAttribute("name", name);
		//响应请求信息；
		resp.getWriter().write("session 学习！");
	}
}
