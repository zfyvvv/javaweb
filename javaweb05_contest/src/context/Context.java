package context;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servletcontext:--->��Ȼ���Լ��������غ��ˣ����Σ���
 * 	���⣺��������û����ݹ������⣻
 * 	�ص㣺�������������û�����
 * 	������һ����Ŀ����Ч��
 * 	�������ڣ��������������رգ�
 * 	ʹ�ã���ͬ�û��Ĳ�ͬ��������õ���
 * 		��ȡServletContext�������ַ�ʽ
 * 		ServletContext���󴢴�ͻ�ȡ���ݣ�
 * 		sc.setAttribute("str","ServletContext����ѧϰ��");
 * 		ServletContext sc=this.getServletContext();sc.getAttribute("str")
 * 		ע�⣺һ���û��棬��һ���û�ȡ����ͬ���û����Զ�ServletContext������д�ȡ��
 * 		��ȡ�����ݲ�����ʱ������Ϊnull��
 * 	��ȡ��Ŀ��web.xml�ļ���ȫ�ֱ��������ã�Ҳ���Ի�����е����ò�����ֵ��
 * 		web.xml�У�<context-param>//ע��һ���ǩֻ�ܴ洢һ���ֵ�ԣ���������������<context-param>
  					<param-name>name</param-name>
  					<param-value>zhangsan</param-value>
  				</context-param>
  		java�����У�String str=sc.getInitParameter("name");	
  				sc.getInitParameterNames() ���ؼ�����ö�٣�
  		���ã�����̬���ݺʹ�����н��
  	��ȡ��Ŀwebroot����Դ�ľ���·����
  		sc.getRealPath("String path");��ȡ������Ŀ�ĸ�Ŀ¼��pathΪ��Ŀ��Ŀ¼�µĶ���
  	��ȡwebroot��Ŀ��Ŀ¼����Դ�Ķ���
  		InputStream is=sc.getResourceAsStream("/doc/1.txt");
  		ע�⣺���ַ�ʽֻ�ܻ����Ŀ��Ŀ¼�µ���Դ�ļ���claa�ļ�����������Ҫʹ�����������ȡ��
  ServletConfig����Ϊÿ��Servlet������Ķ��󣬿������Ϊ���飻
 * @author DELL
 *
 */
public class Context extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡContext�������ַ�ʽ�õ�����ͬһ������
			//��ʽһ
			ServletContext sc=this.getServletContext();
			//��ʽ��
			ServletContext sc2=this.getServletConfig().getServletContext();
			//��ʽ��
			ServletContext sc3=req.getSession().getServletContext();
		//ʹ��ServletContext����������ݵĹ���
			sc.setAttribute("str","ServletContext����ѧϰ��");
		//��ȡ��Ŀ��web.xml�ļ���ȫ�ֱ��������ã�
			String str=sc.getInitParameter("name");
		//sc.getInitParameterNames()
			System.out.println("ȫ�����ò�����"+str);
		//��ȡ��Ŀwebroot����Դ�ľ���·����
			// String path="D:\\Program Files\\Apache Software Foundation\\
				//Tomcat 7.0\\webapps\\context\\doc\\1.txt";
			String path=sc.getRealPath("/doc/1.txt");
			System.out.println(path);
		//��ȡwebroot��Ŀ��Ŀ¼����Դ�Ķ���
		InputStream is=sc.getResourceAsStream("/doc/1.txt");
		
	}
	

}
