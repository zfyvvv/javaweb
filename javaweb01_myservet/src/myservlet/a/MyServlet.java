package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 1-Servlet�������̣�
 * 	1.�����������Ϣ��������������������URL��ַ��
 * 	2.����URL��Ϣ��webapps�ҵ���Ӧ����Ŀ�ļ��У�
 * 	3.����web.xml��Ϣ����������Ӧ��Servlet�࣬��ִ�У�
 * ע�⣺
 * URL:  http://localhost:8080/myservlet/my -->��������ַ���˿ں�/������Ŀ��/servlet�ı���
 * URI��  ������Ŀ��/servlet�ı���
 * web.xml:   ����servlet��
 * 
 * 2-Servletʵ�֣�
 * 	1.��дһ����̳�HttpServlet�࣬��д��дservice();
 * 	2.�ֶ�����Web.xml�ļ��������ڴ棻
 * 	3.������ļ�������tomcat��webapps�ļ��У��½��ļ��У���-->localhost:8080/�½��ļ�����/xml��url-pattren����
 * 	4.����tomcat����ҳ����localhost:8080/�½��ļ�����/xml��url-pattren���ݣ����service()�е����ݣ�
 * 	-->Servlet�Ż���
 * 	1.myeclipse�ֶ�����tomcat;
 * 	2.��web��Ŀ���õ�Tomcat�ļ��£�
 * 	3.����Servlet���ݣ���Ҫ�ر�Tomcat���´򿪣�servlet����һ�Σ��������ڴ��У�������xml�ļ����ã�ֻ��Ҫ���漴�ɣ�
 * 	4.����ҳ������localhost:8080/�½��ļ�����/xml��url-pattren���ݣ����service()�е����ݣ�
 * -->Servlet���Ż���
 * 	1.ֱ���½�Servlet��ֱ�Ӽ̳�HttpServlet�࣬������web.xml��Ϣ��
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
