package login.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.pojo.User;
import login.service.LoginService;
import login.service.LoginServiceImpl;
/**
 * 处理请求乱码问题:
 * 1.使用String转化：name=new String(name.getBytes("iso8859-1"),"utf-8");
 * 	每一次请求都需要转化；
 * 2.使用公共配置信息：（跟浏览器相关，一般不会出错）
 * 	get方式：req.setCharacterEncoding("utf-8");还需设置tomcat->conf->service.xml->connector标签中的属性；
 * 	method方式：	req.setCharacterEncoding("utf-8");
 * 	
 * Servlet使用总结：
 * 	浏览器向服务器发起请求
 * 	服务器接受请求，进行解析并创建request对象储存请求数据，
 * 	服务器调用对应的servlet进行请求处理，并将request对象作为实参传递到servlet的方法；
 * 	servlet的方法执行进行处理
 * 		设置请求编码格式
 * 		设置响应编码格式
 * 		获取请求信息
 * 		处理请求信息
 * 			创建业务层对象
 * 			调用业务层对象的方法
 * 		响应处理结果
 * 数据流程：浏览器-->服务器-->数据库-->服务器-->浏览器
 * 
 * 请求转发的学习
 * 	作用：多个servlet联动处理请求；
 * 	使用：req.getRequestDispatcher("要转发的地址").forward(req, resp);//相对路径，使用别名即可；
 * 	特点：一次请求，浏览器地址栏信息不变；
 * 	注意：请求转发后，直接return 结束即可；
 * 
 * request对象的作用域：
 * 	作用：为了解决一次请求内不同Servlet的req对象数据（请求数据和其他数据）的共享问题；
 * 		tomcat提供了一个给req对象添加我们自定义数据的手段，并可以向后面的servlet进行传递；
 * 	使用：req.setAttribute("str", "用户名或密码错误");
 * 	作用域：一次请求内所有的servlet的数据共享问题；
 * 	特点：服务器创建，每次请求都会创建，生命周期是一次请求内；
 * 
 * 使用重定向：
 * 	作用：如果当前请求，servlet无法进行处理；如果使用请求转发，造成表单数据重复提交；
 * 	使用：resp.sendRedirect("main");//相对地址，网络地址使用URI；
 * 	特点：两次请求；浏览器地址栏变化；两个req对象（数据不可共享！）
 * 	时机：如果请求中有表单数据且重要，建议使用；
 * 		如果请求后servlet无法处理，建议使用重定向（淘宝支付网页跳转到支付宝页面）；
 * 	但是：数据不可共享；为了让servlet获得同一个req对象的数据，cookie-->session!
 * 	
 * Cookie:
 * 作用：解决发送的不同请求的数据共享问题！（重定向过程中）
 * 使用：创建cookie对象
 * 		Cookie c=new Cookie(String name,Strng value);
 * 		响应cookie信息给客户端；
 * 		resp.addCookie(c);
 * 注意：一个cookie对象存储一条数据；
 * 
 * 解决主页面用户名显示为null的问题：
 * 	原因:用户登录成功后，使用重定向显示主页面，而用户的重定向的第二次请求没有或获取第一次的请求的数据；
 * 	解决：使用session
 * 	
 * 使用ServletContext对象完成网站计数器：
 * 	在用户登录中创建计数器，然后存储到ServletContext对象中；
 * 	在主页面里取出计数器给用户；
 * 
 * 
 * 	
 * @author DELL
 *
 */
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//响应请求结果：
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("uname");//如果为null，建议改这个地方，不要轻易懂xml文件中；
		//name=new String(name.getBytes("iso8859-1"),"utf-8");
		String pwd=req.getParameter("pwd");
		System.out.println(name+":"+pwd);
		
		////从req获得的数据，以参数的形式转给业务层；
		LoginService ls=new LoginServiceImpl();
		User u=ls.checkLoginService(name, pwd);
	
		
		if(u!=null){
			//创建cookie信息，实现三天免密登录；
				Cookie c=new Cookie("uid",u.getId()+"");
				//设置cookie的有效期
				c.setMaxAge(3*24*3600);
				c.setPath("/login/ck");
				//添加cookie信息
				resp.addCookie(c);
			//效验登录成功
			//System.out.println("登录成功！");
			//将数据存储到session中
			HttpSession hs=req.getSession();
			hs.setAttribute("user", u);
			
			//创建网页计数器
				//获取计数器数据
				ServletContext sc=this.getServletContext();
				if(sc.getAttribute("nums")!=null){
					int nums=Integer.parseInt((String) sc.getAttribute("nums"));//类型转换！
					//自增后重新存储
					nums+=1;
					sc.setAttribute("nums", nums);
				}else{//第一次访问；
					sc.setAttribute("nums", 1);
				}
				
			//重定向
			resp.sendRedirect("main");
			return ;
		}else{
			//System.out.println("登录失败！");
			req.setAttribute("str", "用户名或密码错误");
			//请求转发
			req.getRequestDispatcher("page").forward(req, resp);
			return ;
		}
		
	}

}
