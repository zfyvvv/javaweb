package myservlet.a;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 3-Servlet�������ڣ�
 * 	1���ӵ�һ�ε��õ��������رգ�
 * 	2�����web.xml�ļ���������load-on-startup,��������Ϊ�������������������رգ�
 * ע�⣺
 * 	init()��Servlet��ʼ��ִ�У�����һ�μ��ؽ��ڴ�ʱ��ִ�У�
 * 	destroy()��Servlet������ʱִ�У����������ر�ʱִ�У�
 * @author DELL
 *
 */
public class ServletLife extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet��ʼ��...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("servlet life!");
		resp.getWriter().write("servlet life22222");
		System.out.println("servlet life!");
		System.out.println("servlet life22222");
	}
	
	@Override
	public void destroy() {
		System.out.println("�ұ�������...");
	}
}
