package daoImp;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.User;
import dao.UserDao;

public class UserDaoImp implements UserDao{

	@Override
	public User getUserInfo(String name) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="select * from t_hero where uname=?";
			ps=conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setString(1, name);//外界传进来的参数；
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setName(rs.getString("uname"));
				u.setPrice(rs.getInt("price"));
				u.setLoc(rs.getString("loc"));
				u.setDesc(rs.getString("desc"));
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
