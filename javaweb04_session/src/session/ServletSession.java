package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * session����ѧϰ��
 * 	���⣺ͬһ���û���ͬ������������ݹ������⣨���������õ����ĵ����ݣ�
 * 	�����ʹ��session������(java�д洢���ݵ��Ǳ����Ͷ���)
 * 	ԭ���������ݲ�ֹһ������ʹ�ö���ȥ�������ݣ���ô��ô��������أ���ôȥȡ�����أ�
 * 		�ڷ������˸��ݴ��û������󴴽�����û���صĶ��󣬲���cookie�����Ѹö����IDֵ��JESESSIONID���浽������ˣ�
 * 		��һ��������û�еģ��û���һ�η��ʷ�����������������һ��session����ʹ��cookie�����浽�������
 * 		���û��ٴ�����ʱ������JESESSIONIDֵ��ȡsession����
 * 	�ص㣺�����ڷ������ˣ��ɷ���������������cookie��������Ч��Ϊһ�λỰ�������һֱ��ʹ�ã�δ�رգ�����
 * 		��������Ĭ�ϴ洢ʱ��Ϊ30���ӣ�
 * 	ʹ�ã�HttpSession hs=req.getSession();//��ʹ�������ǻ�ȡ��
 * 		���������ӵ��session�ı�ʶ����JESESSIONID�����򷵻����Ӧ��session����
 * 		���������û����session�ı�ʶ����JESESSIONID�����򴴽��µ�session���󣬲�����ID��Ϊcookie���ݴ洢��������У�
 * 		���session����ʧЧ�ˣ�Ҳ�����´���һ��session���󣬲�����JESESSIONID�洢��������ڴ��У�
 * 		����session�洢ʱ�䣺
 * 			hs.setMaxInactiveInterval(5);
 * 			ע�⣺û��ʹ�������٣�ʹ�������¼�ʱ��
 * 		����session��ǿ��ʧЧ��hs.invalidate();
 * 		�洢��ȡ�����ݣ�
 * 			hs.setAttribute("name", name);hs.getAttribute("name")	
 * 			ע�⣺�洢�Ķ�����ȡ���Ķ��������ڲ�ͬ�������У����Ǵ洢Ҫ����ȡ��������ͬ�����󣬲��ǲ�ͬ��servlet����
 * 			һ������һ��servlet�д�ȡ������һ��servlet��ȡ����
 * 		ʹ��ʱ����
 * 			һ���������ݿ��в鵽��User����洢��session��
 * 			һ���û��ڵ�¼WEB��Ŀʱ�Ὣ�û��ĸ�����Ϣ�洢��session�У������û�����������ʹ�ã�
 * 		�ܽ᣺���һ���û��Ĳ�ͬ��������ݹ������⣻
 * 			ֻҪjesesionid��ʧЧ��session����ʧЧ������£��û������������ڴ���ʱ���ܻ�ȡ��ͬһsession����
 * 		������һ�λỰ�����û�����JESESSION��session��ʧЧ�������Ϊ������Ŀ�ڣ�
 * 				ʧЧ�����µ�¼��
 * 		ʧЧ������������û���������رգ��û�û�й����������session�ڷ�������ʧЧ���Ѿ������µ�session��
 * 		ʧЧ����
 * 			ͨ���Ա��û������sessionid�ͺ�̨��ȡ��sessionID���Աȣ������һ����ʧЧ��
 * 			�����ض��򵽵�¼ҳ�棬���û����µ�¼��
 * 		�޸�ʧЧĬ��ʱ�䣺tomcat-->session-config-->session-timeout-->30!
 * ע�⣺1.JESESSIONID�洢��cookie����ʱ�洢�ռ��У�������رռ�ʧЧ����������رգ��򿪺��½��µ�session����
 * 		 2.
 * req:һ�����������ݹ������⣻
 * session:ͬһ���û���ͬ��������ݹ������⣻
 * ServletContext:��ͬ�û������ݹ�������-->һ����Ŀֻ��һ������ͬ���û��õ���ֻ����һ�����ɷ������������û�����
 * 				�������ڣ��ӷ�������ʼ���������رգ�
 * @author DELL
 *
 */
public class ServletSession extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ����ʽ��
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ��
			String name="����";
		//����������Ϣ��
			//����session����
			HttpSession hs=req.getSession();//��ʹ�������ǻ�ȡ��
			System.out.println(hs.getId());
			//����session����Ч�ڣ�
			//hs.setMaxInactiveInterval(5);
			//����session��ǿ��ʧЧ��
			//hs.invalidate();
			//�洢����a
			hs.setAttribute("name", name);
		//��Ӧ������Ϣ��
		resp.getWriter().write("session ѧϰ��");
	}
}
