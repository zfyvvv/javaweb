package login.dao;

import login.pojo.User;

public interface LoginDao {
	//根据用户名和密码获取用户信息；
	User checkLoginDao(String name,String pwd);
	//根据用户id获取用户信息；
	User checkUidDao(String uid);
}
