package login.service;

import login.pojo.User;

public interface LoginService {
	//效验用户登录信息；
	User checkLoginService(String name,String pwd);
	//效验用户cookie信息；
	User checkUidService(String uid);

}
