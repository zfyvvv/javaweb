package ajaxservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.User;
import service.UserService;
import serviceImp.UserServiceImp;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//��ȡ������Ϣ
		String name=req.getParameter("name");
		//System.out.println("�û�������ϢΪ��"+name);
		//����������Ϣ
			//��ȡҵ������
			UserService us=new UserServiceImp();
			User u=us.getUserInfoService(name);
			System.out.println("�ɹ���");
		//��Ӧ������
			//��javav����ת����js����
		resp.getWriter().write("{name:'����',pwd:333}");
		
	}

}
