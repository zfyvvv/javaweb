package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 1-Servlet访问流程：
 * 	1.浏览器发送信息到服务器；服务器根据URL地址；
 * 	2.根据URL信息在webapps找到对应的项目文件夹；
 * 	3.根据web.xml信息，检索到对应的Servlet类，并执行；
 * 注意：
 * URL:  http://localhost:8080/myservlet/my -->服务器地址：端口号/虚拟项目名/servlet的别名
 * URI：  虚拟项目名/servlet的别名
 * web.xml:   保护servlet！
 * 
 * 2-Servlet实现：
 * 	1.书写一个类继承HttpServlet类，重写书写service();
 * 	2.手动配置Web.xml文件，虚拟内存；
 * 	3.将相关文件拷贝到tomcat的webapps文件夹（新建文件夹），-->localhost:8080/新建文件夹名/xml中url-pattren内容
 * 	4.启动tomcat，网页输入localhost:8080/新建文件夹名/xml中url-pattren内容，获得service()中的内容；
 * 	-->Servlet优化：
 * 	1.myeclipse手动配置tomcat;
 * 	2.将web项目配置到Tomcat文件下；
 * 	3.更改Servlet内容，需要关闭Tomcat重新打开（servlet运行一次，保存在内存中）；更改xml文件不用，只需要保存即可；
 * 	4.在网页中输入localhost:8080/新建文件夹名/xml中url-pattren内容，获得service()中的内容；
 * -->Servlet再优化：
 * 	1.直接新建Servlet，直接继承HttpServlet类，并更新web.xml信息；
 * 
 * @author DELL
 *
 */
public class MyServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("this is my first servlet!!!zfy");
		System.out.println("this is my first servlet!!!zfy20190325");
	}
}
