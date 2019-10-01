package zfy.servlet;


import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zfy.po.Address;
import zfy.po.User;


public class ElServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println(name+":"+pwd);
		//���ݴ��ݸ�jsp���Դ���ȡ��
			//�����ַ�����
			req.setAttribute("str", "zfy");
			//���ݶ���
			User u=new User("���",18,new Address("����","Т��","����"));
			req.setAttribute("user", u);
			//���ݼ���
				//List
					//������ͨ�ַ���
					List<String> list=new ArrayList<String>();
					list.add("�ܷ���");
					list.add("������");
					req.setAttribute("list", list);
					//�������
					User u2=new User("����",20,new Address("����","����","��Ϫ"));
					List list2=new ArrayList();
					list2.add(u2);
					req.setAttribute("list2", list2);
				//Map
					Map map=new HashMap();
					map.put("name", "zfy");
					map.put("age", 18);
					req.setAttribute("map", map);
		req.getRequestDispatcher("el.jsp").forward(req, resp);
		return;
	}

}
