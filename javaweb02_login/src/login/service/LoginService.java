package login.service;

import login.pojo.User;

public interface LoginService {
	//Ч���û���¼��Ϣ��
	User checkLoginService(String name,String pwd);
	//Ч���û�cookie��Ϣ��
	User checkUidService(String uid);

}
