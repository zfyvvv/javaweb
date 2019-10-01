package login.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 * 处理服务器关闭时，网页计数器归零的情况；
 * 在关闭的时候使用IO流存储文件；
 * 
 * @author DELL
 *
 */
public class Nums extends HttpServlet {
	
	//覆写init()方法，将数据读取到servletContext对象中去；
	@Override
	public void init() throws ServletException {
		
		//获取文件中的计数器数据；
			//获取文件路径
			String path=this.getServletContext().getRealPath("/nums/nums.txt");
			//声明流对象
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(path);
				br=new BufferedReader(fr);
				String nums=br.readLine();
				System.out.println("我重新启动了！！");
				System.out.println(nums);
				this.getServletContext().setAttribute("nums", nums);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	//服务器销毁的时候写到nums.txt文件中；
	//覆写销毁方法，储存计数器至文件中；
	@Override
	public void destroy() {
		//获取计数器对象
		int nums=(int) this.getServletContext().getAttribute("nums");
		System.out.println(nums);
		//获取文件路径
		String path=this.getServletContext().getRealPath("/nums/nums.txt");
		//声明流对象
		BufferedWriter bw=null;
		FileWriter fw=null;
		try {
			fw=new FileWriter(path);
			bw=new BufferedWriter(fw);
			bw.write(nums+"");//存储的时候还是转换成String类型；
			bw.flush();
		} catch (Exception e) {
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
