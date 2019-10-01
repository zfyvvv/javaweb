package login.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.pojo.User;
import login.service.LoginService;
import login.service.LoginServiceImpl;
/**
 * ����������������:
 * 1.ʹ��Stringת����name=new String(name.getBytes("iso8859-1"),"utf-8");
 * 	ÿһ��������Ҫת����
 * 2.ʹ�ù���������Ϣ�������������أ�һ�㲻�����
 * 	get��ʽ��req.setCharacterEncoding("utf-8");��������tomcat->conf->service.xml->connector��ǩ�е����ԣ�
 * 	method��ʽ��	req.setCharacterEncoding("utf-8");
 * 	
 * Servletʹ���ܽ᣺
 * 	��������������������
 * 	�������������󣬽��н���������request���󴢴��������ݣ�
 * 	���������ö�Ӧ��servlet��������������request������Ϊʵ�δ��ݵ�servlet�ķ�����
 * 	servlet�ķ���ִ�н��д���
 * 		������������ʽ
 * 		������Ӧ�����ʽ
 * 		��ȡ������Ϣ
 * 		����������Ϣ
 * 			����ҵ������
 * 			����ҵ������ķ���
 * 		��Ӧ������
 * �������̣������-->������-->���ݿ�-->������-->�����
 * 
 * ����ת����ѧϰ
 * 	���ã����servlet������������
 * 	ʹ�ã�req.getRequestDispatcher("Ҫת���ĵ�ַ").forward(req, resp);//���·����ʹ�ñ������ɣ�
 * 	�ص㣺һ�������������ַ����Ϣ���䣻
 * 	ע�⣺����ת����ֱ��return �������ɣ�
 * 
 * request�����������
 * 	���ã�Ϊ�˽��һ�������ڲ�ͬServlet��req�������ݣ��������ݺ��������ݣ��Ĺ������⣻
 * 		tomcat�ṩ��һ����req������������Զ������ݵ��ֶΣ�������������servlet���д��ݣ�
 * 	ʹ�ã�req.setAttribute("str", "�û������������");
 * 	������һ�����������е�servlet�����ݹ������⣻
 * 	�ص㣺������������ÿ�����󶼻ᴴ��������������һ�������ڣ�
 * 
 * ʹ���ض���
 * 	���ã������ǰ����servlet�޷����д������ʹ������ת������ɱ������ظ��ύ��
 * 	ʹ�ã�resp.sendRedirect("main");//��Ե�ַ�������ַʹ��URI��
 * 	�ص㣺���������������ַ���仯������req�������ݲ��ɹ�����
 * 	ʱ��������������б���������Ҫ������ʹ�ã�
 * 		��������servlet�޷���������ʹ���ض����Ա�֧����ҳ��ת��֧����ҳ�棩��
 * 	���ǣ����ݲ��ɹ���Ϊ����servlet���ͬһ��req��������ݣ�cookie-->session!
 * 	
 * Cookie:
 * ���ã�������͵Ĳ�ͬ��������ݹ������⣡���ض�������У�
 * ʹ�ã�����cookie����
 * 		Cookie c=new Cookie(String name,Strng value);
 * 		��Ӧcookie��Ϣ���ͻ��ˣ�
 * 		resp.addCookie(c);
 * ע�⣺һ��cookie����洢һ�����ݣ�
 * 
 * �����ҳ���û�����ʾΪnull�����⣺
 * 	ԭ��:�û���¼�ɹ���ʹ���ض�����ʾ��ҳ�棬���û����ض���ĵڶ�������û�л��ȡ��һ�ε���������ݣ�
 * 	�����ʹ��session
 * 	
 * ʹ��ServletContext���������վ��������
 * 	���û���¼�д�����������Ȼ��洢��ServletContext�����У�
 * 	����ҳ����ȡ�����������û���
 * 
 * 
 * 	
 * @author DELL
 *
 */
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//��Ӧ��������
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("uname");//���Ϊnull�����������ط�����Ҫ���׶�xml�ļ��У�
		//name=new String(name.getBytes("iso8859-1"),"utf-8");
		String pwd=req.getParameter("pwd");
		System.out.println(name+":"+pwd);
		
		////��req��õ����ݣ��Բ�������ʽת��ҵ��㣻
		LoginService ls=new LoginServiceImpl();
		User u=ls.checkLoginService(name, pwd);
	
		
		if(u!=null){
			//����cookie��Ϣ��ʵ���������ܵ�¼��
				Cookie c=new Cookie("uid",u.getId()+"");
				//����cookie����Ч��
				c.setMaxAge(3*24*3600);
				c.setPath("/login/ck");
				//���cookie��Ϣ
				resp.addCookie(c);
			//Ч���¼�ɹ�
			//System.out.println("��¼�ɹ���");
			//�����ݴ洢��session��
			HttpSession hs=req.getSession();
			hs.setAttribute("user", u);
			
			//������ҳ������
				//��ȡ����������
				ServletContext sc=this.getServletContext();
				if(sc.getAttribute("nums")!=null){
					int nums=Integer.parseInt((String) sc.getAttribute("nums"));//����ת����
					//���������´洢
					nums+=1;
					sc.setAttribute("nums", nums);
				}else{//��һ�η��ʣ�
					sc.setAttribute("nums", 1);
				}
				
			//�ض���
			resp.sendRedirect("main");
			return ;
		}else{
			//System.out.println("��¼ʧ�ܣ�");
			req.setAttribute("str", "�û������������");
			//����ת��
			req.getRequestDispatcher("page").forward(req, resp);
			return ;
		}
		
	}

}
