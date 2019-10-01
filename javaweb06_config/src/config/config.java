package config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletConfig对象学习：
 * 	问题：如何获取在web.xml中给每个servlet单独配置的数据？
 * 	解决：ServletConfig对象
 * 	使用：
 * 		获取ServletConfig对象
 * 		获取web.xml中配置数据（先配置）
 * web.xml的学习：
 * 	作用：储存项目相关的配置信息，保护Servlet，解耦一些数据对程序的依赖；
 * 	使用：配置servlet|全局参数|局部参数|过滤器|监听器
 * 	位置：
 * 		每个web项目中都有一个web.xml文件   单独的，优先使用自己配置的xml文件；
 * 		Tomcat—>conf->web.xml       公共配置，如果没有单独配置，就使用公共的配置；
 * 		local:8080/login/ -->this is my jsp page!  这是因为Tomcat下的xml文件中已经配置了；
 * 
 * 	内容：全局上下文|servlet配置|过滤器|监听器
 * 		他们在XML文件中的书写顺序可以随意，但是加载有顺序；
 * 		web容器加载顺序：ServletContext->context.param->listener->filter->servlet;
 * 		加载时机：服务器启动时；
 * server.xml:
 * 	核心组件：
 * 		<Server>
 * 			<Service>
 * 				<Connector>
 * 				</Connector>
 * 					<Engine>
 * 						<Host>
 * 							<Context/>
 * 						</Host>
 * 					</Engine>
 * 			</Service>
 * 		</Server>
 * 	注意：尽管还有<Lister></Lister>等；一个<Service>只能有一个<Engine>，可以有多个<Connector>；
 * 		<Connector>：里面可以设置多个端口号；8080等；
 * 		<Engine>：这次服务的引擎；可以有两个引擎；（一个<Server>可以配多个<Service>，后续使用多个端口号，使用多个引擎）
 * 		<Host>：请求来的时候怎么找请求文件；有localhost和webapps目录；默认的也是localhost；
 * 		<Context/>：找的方式，
 * 		
 * 	请求过程：先根据监听到的端口号8080，拿到请求；
 * 			根据请求信息地址localhost或其他IP，去<Host>找项目的目录；然后找到webapps;
 * 			在webapps目录下根据URI信息，找到相关的项目信息；
 * 	热部署：
 * 		<Context path="/Pet"  reloadable="true" doucBase="F:/PetWeb"/>
 * 		重新加载，不是复制；故不用重启；复制到<Host>下面，路径到webroot下面；
 * 		使用热部署，如果在webroot下的项目已经删除，请一定存删除添加的这句话，Tomcat会加载不到，直接报错；
 * 冷部署：现在做的项目都是冷部署，即每次更改java后都需要重启Tomcat，
 * 
 * 
 * 
 * 
 * @author DELL
 *
 */
public class config extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取ServletConfig对象
		ServletConfig sc=this.getServletConfig();
		//获取web.xml中配置数据
		String code=sc.getInitParameter("config");
		System.out.println(code);
				
	}
	

}
