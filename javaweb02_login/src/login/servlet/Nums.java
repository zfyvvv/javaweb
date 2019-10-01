package login.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 * ����������ر�ʱ����ҳ����������������
 * �ڹرյ�ʱ��ʹ��IO���洢�ļ���
 * 
 * @author DELL
 *
 */
public class Nums extends HttpServlet {
	
	//��дinit()�����������ݶ�ȡ��servletContext������ȥ��
	@Override
	public void init() throws ServletException {
		
		//��ȡ�ļ��еļ��������ݣ�
			//��ȡ�ļ�·��
			String path=this.getServletContext().getRealPath("/nums/nums.txt");
			//����������
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(path);
				br=new BufferedReader(fr);
				String nums=br.readLine();
				System.out.println("�����������ˣ���");
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
	
	//���������ٵ�ʱ��д��nums.txt�ļ��У�
	//��д���ٷ�����������������ļ��У�
	@Override
	public void destroy() {
		//��ȡ����������
		int nums=(int) this.getServletContext().getAttribute("nums");
		System.out.println(nums);
		//��ȡ�ļ�·��
		String path=this.getServletContext().getRealPath("/nums/nums.txt");
		//����������
		BufferedWriter bw=null;
		FileWriter fw=null;
		try {
			fw=new FileWriter(path);
			bw=new BufferedWriter(fw);
			bw.write(nums+"");//�洢��ʱ����ת����String���ͣ�
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
