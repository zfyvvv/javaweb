package zfy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 过滤器的使用：
 * 	作用：对服务器接受到的请求资源和响应给浏览器的资源进行管理；保护servlet；
 * 
 * 	使用：
 * 		创建一个实现Filter接口的类；
 * 
 * 		覆写接口的方法；
 * 			init():服务器启动即执行，初始化资源；
 * 			doFilter（）：拦截请求的方法，在此方法中可以对资源实现管理
 * 						注意：需要手动对请求进行放行
 * 							chain.doFilter(req, resp);
 * 							放行后可执行后续程序
 * 			destory():服务器关闭时候执行；
 * 
 * 		在web.xml文件中进行过滤器的配置：
 * 			<filter>
  				<filter-name>myfilter</filter-name>
  				<filter-class>zfy.filter.MyFilter</filter-class>
  			</filter>
  			<filter-mapping>
  				<filter-name>myfilter</filter-name>
  				<url-pattern>/*</url-pattern>
  			</filter-mapping>
  			注意：
  				<url-pattern>/*
  					拦截所有请求；
  				<url-pattern>*.do
  					拦截.do结尾的请求；一般用来模块拦截；
  				<url-pattern>/fs.do
  					拦截某一个请求
  	过滤器的声明周期：服务器启动到关闭；
  	
  	总结：过滤器的声明和配置，服务器会根据uri信息进行调用；
  	执行：浏览器发送请求到服务器，服务器接受到请求后根据uri信息在web.xml中找对应的过滤器进行执行doFilter方法;
  		该方法对此次请求处理后根据符合要求则放行，放行后如果还有符合要求的过滤器则继续进行过滤，找到对应执行的servlet进行请求处理；
  		servlet请求处理完毕后，也就是servlet方法结束了，还需继续返回响应的doFilter方法继续执行；
  	案例：
  		同一编码格式
  		session管理：判断session是否失效，是否为null；
  		权限管理
  		资源管理：同一水印，和谐词汇等；
 * @author DELL
 *
 */
public class MyFilter implements Filter{

	@Override
	public void destroy() {
			System.out.println("MyFilter.destroy()关闭中...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter.doFilter()初次执行");
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("utf-8");
		//判断session
		HttpSession hs=((HttpServletRequest)req).getSession();
		if(hs.getAttribute("user")==null){//为空，则跳转到登录页面；
			((HttpServletResponse)resp).sendRedirect("/a/login.jsp");
		}else{//放行
			chain.doFilter(req, resp);
			System.out.println("MyFilter.doFilter()放行后执行后续结果...");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
			System.out.println("MyFilter.init()启动中...");
	}

}
