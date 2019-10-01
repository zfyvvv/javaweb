package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * service()|doget()|dopost()�Ƚϣ�
 * 	service():���Դ���get|post���󣬻�����ʹ�ã�
 * 	doget():����get����
 * 	dopost():����post����
 * ע�⣺
 * 	���service()��д��super.service(req, resp),service()��ɺ���ٴθ�������ʽ����doget()|dopost()��
 * 	һ�㲻��дsuper.service(req, resp)�����������д��û��дdoget()|dopost()�������405����
 * 	ֻдservice()�Ϳ����ˣ���service()��������жϣ�
 * 
 * Servlet�г����Ĵ���l
 * 	404:��Դδ�ҵ���
 *		URL�еı�������URL�е�������Ŀ����ƴд����
 *	500��  
 *		ClassNotFound һ��Ϊxml�����õ�����д��������ctrl������֤��i/0,�������д���ִ�д���;
 *	405:����ʽ��servlet�еķ�����ƥ�䣻����ʽ��֧�֣�
 *		����ʹ��service()���Ҳ�Ҫ���ø����е�service()��
 * @author DELL
 *
 */
public class ServletMethod extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����service().......");
		super.service(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����doGet().......");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����doPost().......");
	}
}
