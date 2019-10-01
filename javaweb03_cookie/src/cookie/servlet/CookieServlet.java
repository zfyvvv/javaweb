package cookie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Cookie学习：
 * 作用：解决了发送的不同请求的数据共享问题；
 * 使用：
 * 		cookie的创建和储存：
 *   		创建 cookie对象；
 *   		设置cookie（可选）
 *   			设置有效期
 * 				设置路径
 * 			响应cookie信息给客户端
 * 		cookie的获取：
 * 			获取cookie数组；
 * 			Cookie[] cks=req.getCookies();
 * 			使用for循环遍历数组
 * 
 * 				
 * 注意：一个cookie对象可以存储一条信息，多条信息可以使用多个cookie对象
 * 特点：浏览器端的数据存储技术，存储数据的声明在服务器端；
 * 		临时存储：数据存储在浏览器的内存里面；(关闭一次浏览器，该cookie信息消失)
 * 		定时存储：可以设置cookie的有效期，储存在客户端的硬盘中，在有效期内符合路径的请求要求都会附带该信息；
 * 		默认设置好cookie信息后，每次请求都会附带；除非设置有效路径，只有该有效路径下的访问才出现cookie信息；
 * 		重启服务器之后，cookie信息还在；
 * 
 * @author DELL
 *
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置响应编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		//处理请求信息
		//响应请求信息
			//使用cookie对象进行浏览器端的数据储存
				//创建cookie对象
				Cookie c=new Cookie("mygirlfriend","LTTTTTTT");
				Cookie c2=new Cookie("handsomeboy","zfyyyyyy");
				//设置cookie信息
					c2.setMaxAge(3*24*3600);
				//设置有效路径
					c2.setPath("/cookie/abc");
				//响应cookie信息；
				resp.addCookie(c);
				resp.addCookie(c2);
			//直接响应
			resp.getWriter().write("Cookie study!");
			//请求转发
			//重定向
	}
}
