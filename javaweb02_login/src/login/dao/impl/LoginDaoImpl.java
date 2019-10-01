package login.dao.impl;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.dao.LoginDao;
import login.pojo.User;
/**
 * 1.处理数据库的数据，使用User去接收获得的数据；
 * @author DELL
 */
public class LoginDaoImpl implements LoginDao{
	//根据用户名和密码获取用户信息；
	@Override
	public User checkLoginDao(String uname, String pwd) {
		Connection conn=null;//声明JDBC对象
		PreparedStatement ps=null;
		ResultSet rs=null;		
		User u=null;//声明数据存储对象
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="select * from t_user where uname=? and pwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("uid"));
				u.setName(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	//根据用户UID获取用户信息；
	@Override
	public User checkUidDao(String uid) {
		Connection conn=null;//声明JDBC对象
		PreparedStatement ps=null;
		ResultSet rs=null;		
		User u=null;//声明数据存储对象
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="select * from t_user where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("uid"));
				u.setName(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}

}
