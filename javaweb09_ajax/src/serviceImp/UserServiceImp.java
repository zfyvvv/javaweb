package serviceImp;



import po.User;
import dao.UserDao;
import daoImp.UserDaoImp;
import service.UserService;

public class UserServiceImp implements UserService{
	//获取Dao层对象
	UserDao ud=new UserDaoImp();
	@Override
	public User getUserInfoService(String name) {
		return ud.getUserInfo(name);
	}

}
