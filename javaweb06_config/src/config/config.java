package config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletConfig����ѧϰ��
 * 	���⣺��λ�ȡ��web.xml�и�ÿ��servlet�������õ����ݣ�
 * 	�����ServletConfig����
 * 	ʹ�ã�
 * 		��ȡServletConfig����
 * 		��ȡweb.xml���������ݣ������ã�
 * web.xml��ѧϰ��
 * 	���ã�������Ŀ��ص�������Ϣ������Servlet������һЩ���ݶԳ����������
 * 	ʹ�ã�����servlet|ȫ�ֲ���|�ֲ�����|������|������
 * 	λ�ã�
 * 		ÿ��web��Ŀ�ж���һ��web.xml�ļ�   �����ģ�����ʹ���Լ����õ�xml�ļ���
 * 		Tomcat��>conf->web.xml       �������ã����û�е������ã���ʹ�ù��������ã�
 * 		local:8080/login/ -->this is my jsp page!  ������ΪTomcat�µ�xml�ļ����Ѿ������ˣ�
 * 
 * 	���ݣ�ȫ��������|servlet����|������|������
 * 		������XML�ļ��е���д˳��������⣬���Ǽ�����˳��
 * 		web��������˳��ServletContext->context.param->listener->filter->servlet;
 * 		����ʱ��������������ʱ��
 * server.xml:
 * 	���������
 * 		<Server>
 * 			<Service>
 * 				<Connector>
 * 				</Connector>
 * 					<Engine>
 * 						<Host>
 * 							<Context/>
 * 						</Host>
 * 					</Engine>
 * 			</Service>
 * 		</Server>
 * 	ע�⣺���ܻ���<Lister></Lister>�ȣ�һ��<Service>ֻ����һ��<Engine>�������ж��<Connector>��
 * 		<Connector>������������ö���˿ںţ�8080�ȣ�
 * 		<Engine>����η�������棻�������������棻��һ��<Server>��������<Service>������ʹ�ö���˿ںţ�ʹ�ö�����棩
 * 		<Host>����������ʱ����ô�������ļ�����localhost��webappsĿ¼��Ĭ�ϵ�Ҳ��localhost��
 * 		<Context/>���ҵķ�ʽ��
 * 		
 * 	������̣��ȸ��ݼ������Ķ˿ں�8080���õ�����
 * 			����������Ϣ��ַlocalhost������IP��ȥ<Host>����Ŀ��Ŀ¼��Ȼ���ҵ�webapps;
 * 			��webappsĿ¼�¸���URI��Ϣ���ҵ���ص���Ŀ��Ϣ��
 * 	�Ȳ���
 * 		<Context path="/Pet"  reloadable="true" doucBase="F:/PetWeb"/>
 * 		���¼��أ����Ǹ��ƣ��ʲ������������Ƶ�<Host>���棬·����webroot���棻
 * 		ʹ���Ȳ��������webroot�µ���Ŀ�Ѿ�ɾ������һ����ɾ����ӵ���仰��Tomcat����ز�����ֱ�ӱ���
 * �䲿������������Ŀ�����䲿�𣬼�ÿ�θ���java����Ҫ����Tomcat��
 * 
 * 
 * 
 * 
 * @author DELL
 *
 */
public class config extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡServletConfig����
		ServletConfig sc=this.getServletConfig();
		//��ȡweb.xml����������
		String code=sc.getInitParameter("config");
		System.out.println(code);
				
	}
	

}
