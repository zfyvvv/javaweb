package login.dao;

import login.pojo.User;

public interface LoginDao {
	//�����û����������ȡ�û���Ϣ��
	User checkLoginDao(String name,String pwd);
	//�����û�id��ȡ�û���Ϣ��
	User checkUidDao(String uid);
}
