package login.service;


import login.dao.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.pojo.User;
/**
 * 1.ͨ��LoginDao����User����
 * @author DELL
 *
 */
public class LoginServiceImpl implements LoginService{
	//����DAO����ȶ���
	LoginDao lsd=new LoginDaoImpl();
	//Ч���û���¼��Ϣ
	@Override
	public User checkLoginService(String name, String pwd) {
		
		return lsd.checkLoginDao(name, pwd);
	}
	//Ч���û�cookie��Ϣ
	@Override
	public User checkUidService(String uid) {
		// TODO Auto-generated method stub
		return lsd.checkUidDao(uid);
	}

}
