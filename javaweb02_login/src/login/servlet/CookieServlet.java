package login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.pojo.User;
import login.service.LoginService;
import login.service.LoginServiceImpl;
/**
 * Cookie��Ϣ��Ч�飺
 * 	�ж��������Ƿ������ȷ��Cookie��Ϣ
 * 	�������Ч�����Ϣ�Ƿ���ȷ��
 * 		���Ч����ȷ��ֱ����Ӧ��ҳ���û�
 * 		���Ч�鲻��ȷ����Ӧ��¼ҳ��
 * 	���û��������ת������¼ҳ�棻
 * 
 * ע�⣺ģ���������¼Ч������ʹҳ��ر�Ҳ���ԣ�ֻҪ������������ʷ��¼��
 * �����ͬ����ʹ����ͬ��������⣻���Ǵ�ckҳ��ת��mainҳ���ǣ���ʾ����Null,
 * ����ckҳ��req��������ݣ�û�й���mainҳ�棬�����ǲ�ͬ�����req����
 * ����ͬreq�����������ݹ���һ���û����Է��Ͷ������ǰ����ͬһ���û����͵Ĳ�ͬ��������ݹ������⣻
 * -->session!
 * @author DELL
 *
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		//resp.setCharacterEncoding("text/html;charset=utf-8");//ϸ�ڣ���
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
			//��ȡcookie��Ϣ
		Cookie[] cks=req.getCookies();
		if(cks!=null){
			//��Ҫ�����ݿ����Ч�飻����ֹ�û��Լ�ɾ�����ݣ�
			//����cookie����
			String uid="";
			for(Cookie c:cks){
				if("uid".equals(c.getName())){//ֻ��uid���cookie������ֵ����uid;
					uid=c.getValue();
				}
				//����uid�Ƿ���ڣ�
				if("".equals(uid)){//��ֹ�û������������ʷ���ݺ�������value=������uid;
					req.getRequestDispatcher("page").forward(req, resp);
					return ;
				}else{
					//Ч��uid�����ݿ���
						//��ȡҵ������
						LoginService ls=new LoginServiceImpl();
						User u=ls.checkUidService(uid);
						if(u!=null){//ҵ����ѯ��u��ֱ�ӵ�¼��ҳ�棻
							//ֻҪ��ת����¼ҳ�棻���뽫�鵽�����ݴ洢��session�У�
							req.getSession().setAttribute("user", u);
							//��ҳ������������
								//���ʱ����String��ȡ����Ҳ��String;ת��Int;
								int nums= (int) this.getServletContext().getAttribute("nums");
								nums+=1;
								this.getServletContext().setAttribute("nums", nums);
							//�ض���
							resp.sendRedirect("/login/main");
							return;
						}
				}
			}
		}else{
			//��Ӧ������
			//����ת��
			req.getRequestDispatcher("page").forward(req, resp);
		}
		
		
		
		
		
	}
}
