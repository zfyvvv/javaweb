package login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.pojo.User;
import login.service.LoginService;
import login.service.LoginServiceImpl;
/**
 * Cookie信息的效验：
 * 	判断请求中是否带有正确的Cookie信息
 * 	如果有则效验该信息是否正确；
 * 		如果效验正确则直接响应主页给用户
 * 		如果效验不正确则响应登录页面
 * 	如果没有则请求转发给登录页面；
 * 
 * 注意：模拟三天免登录效果，即使页面关闭也可以；只要不重新清理历史记录；
 * 解决不同请求使用相同请求的问题；但是从ck页面转到main页面是，显示的是Null,
 * 即：ck页面req请求的数据，没有共享到main页面，两次是不同请求的req对象；
 * 即不同req请求对象的数据共享，一个用户可以发送多个请求，前提是同一个用户发送的不同请求的数据共享问题；
 * -->session!
 * @author DELL
 *
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		//resp.setCharacterEncoding("text/html;charset=utf-8");//细节！！
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			//获取cookie信息
		Cookie[] cks=req.getCookies();
		if(cks!=null){
			//需要和数据库进行效验；（防止用户自己删除数据）
			//遍历cookie数组
			String uid="";
			for(Cookie c:cks){
				if("uid".equals(c.getName())){//只拿uid这个cookie，将其值付给uid;
					uid=c.getValue();
				}
				//检验uid是否存在；
				if("".equals(uid)){//防止用户清理浏览器历史数据后，留下了value=“”的uid;
					req.getRequestDispatcher("page").forward(req, resp);
					return ;
				}else{
					//效验uid，数据库中
						//获取业务层对象
						LoginService ls=new LoginServiceImpl();
						User u=ls.checkUidService(uid);
						if(u!=null){//业务层查询到u，直接登录主页面；
							//只要是转到登录页面；必须将查到的数据存储到session中；
							req.getSession().setAttribute("user", u);
							//网页计数器自增；
								//存的时候是String，取出来也是String;转成Int;
								int nums= (int) this.getServletContext().getAttribute("nums");
								nums+=1;
								this.getServletContext().setAttribute("nums", nums);
							//重定向
							resp.sendRedirect("/login/main");
							return;
						}
				}
			}
		}else{
			//响应处理结果
			//请求转发
			req.getRequestDispatcher("page").forward(req, resp);
		}
		
		
		
		
		
	}
}
