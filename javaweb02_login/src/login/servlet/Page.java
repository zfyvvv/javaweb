package login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 1.�½���Ŀ�����tomcat��ployed���ã���class�ļ����õ�webinf���棻
 * 2.�½�Servletw�ļ����Ѿ��̳е�class�ļ����������xml�ļ����ã����޸ı������Խ��з��ʣ�
 * @author DELL
 *
 */
public class Page extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		//req�����������//�����Ż���
		String str=(String) req.getAttribute("str")==null?"":(String) req.getAttribute("str");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<font color='red' size='10px'>"+str+"</font>");
		resp.getWriter().write("<form action='login'  method='get'>");
		resp.getWriter().write("�û�����<input type='text' name='uname' value=''/><br/>");
		resp.getWriter().write("���룺<input type='password' name='pwd' value=''/><br/>");
		resp.getWriter().write("<input type='submit'  value='��¼'/><br/>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		
		/*if(str!=null){
			resp.getWriter().write("<html>");
			resp.getWriter().write("<head>");
			resp.getWriter().write("</head>");
			resp.getWriter().write("<body>");
			resp.getWriter().write("<font color='red' size='10px'>"+str+"</font>");
			resp.getWriter().write("<form action='login'  method='get'>");
			resp.getWriter().write("�û�����<input type='text' name='uname' value=''/><br/>");
			resp.getWriter().write("���룺<input type='password' name='pwd' value=''/><br/>");
			resp.getWriter().write("<input type='submit'  value='��¼'/><br/>");
			resp.getWriter().write("</form>");
			resp.getWriter().write("</body>");
			resp.getWriter().write("</html>");
		}else{
			resp.getWriter().write("<html>");
			resp.getWriter().write("<head>");
			resp.getWriter().write("</head>");
			resp.getWriter().write("<body>");
			//resp.getWriter().write("<font color='red' size='20px'>"+str+"</font>");
			resp.getWriter().write("<form action='login'  method='get'>");
			resp.getWriter().write("�û�����<input type='text' name='uname' value=''/><br/>");
			resp.getWriter().write("���룺<input type='password' name='pwd' value=''/><br/>");
			resp.getWriter().write("<input type='submit'  value='��¼'/><br/>");
			resp.getWriter().write("</form>");
			resp.getWriter().write("</body>");
			resp.getWriter().write("</html>");
		}*/
		
		
	}

}
