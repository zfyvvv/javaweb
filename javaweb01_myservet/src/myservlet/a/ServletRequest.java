package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet request����
 * 	request�����浱ǰ���������������Ϣ�����Ի�ȡ����ͷ���ݣ������������Լ������û����ݣ�
 * 	�ö�������tomcat����������Ϊʵ�δ��ݸ�Servlet��service�����У�
 * 	����ȡ�������ݲ�����ʱ�����򲻻ᱨ�������null��������ǰ�жϣ�
 * @author DELL
 */
public class ServletRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//����ͷ���ݣ�
		System.out.println(req.getMethod());//��ȡ����ʽ
		System.out.println(req.getRequestURL());//��ȡ����URL
		System.out.println(req.getRequestURI());//��ȡ����URI
		System.out.println(req.getScheme());//��ȡ����Э�飻
		//���������ݣ���ֵ�ԣ�
		String str=req.getHeader("User-Agent");//��ȡָ�������ݣ�Ҳ���Ի�����������ݣ�
		System.out.println(str);// Mozilla/5.0 ...
		//��ȡ�û����ݣ�
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");//���ܻ��ͬ����ֵͬ�Ķ���ѡ�񣻼���ѡ
		System.out.println(name+":"+pwd);//����ʹ��String[] str=req.getParameterValues();
	}
}
