package dao;

import model.LoginUser;

public interface UserDao {
	LoginUser getLoginUser(LoginUser user); //로그인에 사용
}
