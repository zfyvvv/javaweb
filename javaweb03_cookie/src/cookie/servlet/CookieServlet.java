package cookie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Cookieѧϰ��
 * ���ã�����˷��͵Ĳ�ͬ��������ݹ������⣻
 * ʹ�ã�
 * 		cookie�Ĵ����ʹ��棺
 *   		���� cookie����
 *   		����cookie����ѡ��
 *   			������Ч��
 * 				����·��
 * 			��Ӧcookie��Ϣ���ͻ���
 * 		cookie�Ļ�ȡ��
 * 			��ȡcookie���飻
 * 			Cookie[] cks=req.getCookies();
 * 			ʹ��forѭ����������
 * 
 * 				
 * ע�⣺һ��cookie������Դ洢һ����Ϣ��������Ϣ����ʹ�ö��cookie����
 * �ص㣺������˵����ݴ洢�������洢���ݵ������ڷ������ˣ�
 * 		��ʱ�洢�����ݴ洢����������ڴ����棻(�ر�һ�����������cookie��Ϣ��ʧ)
 * 		��ʱ�洢����������cookie����Ч�ڣ������ڿͻ��˵�Ӳ���У�����Ч���ڷ���·��������Ҫ�󶼻ḽ������Ϣ��
 * 		Ĭ�����ú�cookie��Ϣ��ÿ�����󶼻ḽ��������������Ч·����ֻ�и���Ч·���µķ��ʲų���cookie��Ϣ��
 * 		����������֮��cookie��Ϣ���ڣ�
 * 
 * @author DELL
 *
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������Ӧ����
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		//����������Ϣ
		//��Ӧ������Ϣ
			//ʹ��cookie�������������˵����ݴ���
				//����cookie����
				Cookie c=new Cookie("mygirlfriend","LTTTTTTT");
				Cookie c2=new Cookie("handsomeboy","zfyyyyyy");
				//����cookie��Ϣ
					c2.setMaxAge(3*24*3600);
				//������Ч·��
					c2.setPath("/cookie/abc");
				//��Ӧcookie��Ϣ��
				resp.addCookie(c);
				resp.addCookie(c2);
			//ֱ����Ӧ
			resp.getWriter().write("Cookie study!");
			//����ת��
			//�ض���
	}
}
