package login.service;


import login.dao.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.pojo.User;
/**
 * 1.通过LoginDao类获得User对象，
 * @author DELL
 *
 */
public class LoginServiceImpl implements LoginService{
	//创建DAO层过度对象
	LoginDao lsd=new LoginDaoImpl();
	//效验用户登录信息
	@Override
	public User checkLoginService(String name, String pwd) {
		
		return lsd.checkLoginDao(name, pwd);
	}
	//效验用户cookie信息
	@Override
	public User checkUidService(String uid) {
		// TODO Auto-generated method stub
		return lsd.checkUidDao(uid);
	}

}
