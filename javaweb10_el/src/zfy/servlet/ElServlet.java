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
		//数据传递给jsp，显存再取；
			//传递字符串；
			req.setAttribute("str", "zfy");
			//传递对象；
			User u=new User("李白",18,new Address("湖北","孝昌","莲花"));
			req.setAttribute("user", u);
			//传递集合
				//List
					//储存普通字符串
					List<String> list=new ArrayList<String>();
					list.add("周方杨");
					list.add("王明星");
					req.setAttribute("list", list);
					//储存对象
					User u2=new User("吕布",20,new Address("江西","上饶","金溪"));
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
