package context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//����Context�������ַ�ʽ�õ�����ͬһ������
				ServletContext sc=this.getServletContext();
				//��ȡ����
				System.out.println("Context2.service()"+":"+sc.getAttribute("str"));
	}

}
