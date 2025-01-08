package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.LoginUser;
import model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public LoginUser getLoginUser(LoginUser user) {
		return this.sqlSession.selectOne("loginMapper.getUser", user);
	}

	@Override
	public void putUser(User user) {
		this.sqlSession.insert("loginMapper.putUser", user);
	}
}
