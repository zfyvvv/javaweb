package cookie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 1.��ȡcookie���飻
 * 2.���cookie���飬����ͨ�������ҳ���
 * @author DELL
 *
 */
public class GetCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html,charset=utf-8");
		//��ȡ������Ϣ
			//��ȡcookie��Ϣ
			Cookie[] cks=req.getCookies();
			if(cks!=null){//��ֹ��ָ���쳣��
				for(Cookie c:cks){
					String name=c.getName();
					String value=c.getValue();
					System.out.println(name+":"+value);
				}
			}
			//��ȡ�û���Ϣ
		//����������Ϣ
	}
}
