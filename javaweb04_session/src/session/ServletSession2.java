package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSession2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession hs=req.getSession();
		System.out.println("ServletSession2.service()"+hs.getId());
		//���뱣֤ȡ������ͬһ��session��sessionû��ʧЧ����û�йر������
		System.out.println("ServletSession2.service()"+":"+hs.getAttribute("name"));
	}

}
