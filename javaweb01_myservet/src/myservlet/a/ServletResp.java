package myservlet.a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletResponse����
 * 	������Ӧ���ݵ��������һ������
 * 	������Ӧͷ
 * 	������Ӧ״̬��
 * 	������Ӧʵ��
 * 
 * �ܽ᣺service()������������̣�
 * 	������Ӧ�����ʽ
 * 	��ȡ��������-->req
 * 	������������-->java ����
 * 		���ݿ�˼�루MVC��
 * ��Ӧ������-->resp
 * @author DELL
 *
 */
public class ServletResp extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ������Ϣ
		//����������Ϣ
		//��Ӧ������Ϣ
			//������Ӧͷ
			resp.setHeader("key", "logitech");
			resp.addHeader("sb", "zfy");
			resp.addHeader("sb", "xsb");
			//resp.setHeader("content-type", "text/html;charset=utf-8");
			resp.setContentType("text/html;charset=utf-8");
			//resp.setContentType("text/xml;charset=utf-8");
			//resp.setContentType("text/plain;charset=utf-8");
			//������Ӧ״̬��
			//resp.sendError(404, "this is error!");
			//������Ӧʵ��
			resp.getWriter().write("<b>this is my resp!</b>");
			//resp.getWriter().write("�ú�ѧϰ���������ϣ�");
	}

}
