package dao;

import model.LoginUser;
import model.User;

public interface UserDao {
	User getUserInfo(String user); //계산전 정보확인에 사용
	
	LoginUser getLoginUser(LoginUser user); //로그인에 사용
	void putUser(User user); //가입자 삽입
}
