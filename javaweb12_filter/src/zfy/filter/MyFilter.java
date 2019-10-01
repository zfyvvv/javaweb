package zfy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ��������ʹ�ã�
 * 	���ã��Է��������ܵ���������Դ����Ӧ�����������Դ���й�������servlet��
 * 
 * 	ʹ�ã�
 * 		����һ��ʵ��Filter�ӿڵ��ࣻ
 * 
 * 		��д�ӿڵķ�����
 * 			init():������������ִ�У���ʼ����Դ��
 * 			doFilter��������������ķ������ڴ˷����п��Զ���Դʵ�ֹ���
 * 						ע�⣺��Ҫ�ֶ���������з���
 * 							chain.doFilter(req, resp);
 * 							���к��ִ�к�������
 * 			destory():�������ر�ʱ��ִ�У�
 * 
 * 		��web.xml�ļ��н��й����������ã�
 * 			<filter>
  				<filter-name>myfilter</filter-name>
  				<filter-class>zfy.filter.MyFilter</filter-class>
  			</filter>
  			<filter-mapping>
  				<filter-name>myfilter</filter-name>
  				<url-pattern>/*</url-pattern>
  			</filter-mapping>
  			ע�⣺
  				<url-pattern>/*
  					������������
  				<url-pattern>*.do
  					����.do��β������һ������ģ�����أ�
  				<url-pattern>/fs.do
  					����ĳһ������
  	���������������ڣ��������������رգ�
  	
  	�ܽ᣺�����������������ã������������uri��Ϣ���е��ã�
  	ִ�У�������������󵽷����������������ܵ���������uri��Ϣ��web.xml���Ҷ�Ӧ�Ĺ���������ִ��doFilter����;
  		�÷����Դ˴����������ݷ���Ҫ������У����к�������з���Ҫ��Ĺ�������������й��ˣ��ҵ���Ӧִ�е�servlet����������
  		servlet��������Ϻ�Ҳ����servlet���������ˣ��������������Ӧ��doFilter��������ִ�У�
  	������
  		ͬһ�����ʽ
  		session�����ж�session�Ƿ�ʧЧ���Ƿ�Ϊnull��
  		Ȩ�޹���
  		��Դ����ͬһˮӡ����г�ʻ�ȣ�
 * @author DELL
 *
 */
public class MyFilter implements Filter{

	@Override
	public void destroy() {
			System.out.println("MyFilter.destroy()�ر���...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter.doFilter()����ִ��");
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setContentType("utf-8");
		//�ж�session
		HttpSession hs=((HttpServletRequest)req).getSession();
		if(hs.getAttribute("user")==null){//Ϊ�գ�����ת����¼ҳ�棻
			((HttpServletResponse)resp).sendRedirect("/a/login.jsp");
		}else{//����
			chain.doFilter(req, resp);
			System.out.println("MyFilter.doFilter()���к�ִ�к������...");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
			System.out.println("MyFilter.init()������...");
	}

}
