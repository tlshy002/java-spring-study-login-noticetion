package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartItem;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertCart(CartItem ci) {
		this.sqlSession.insert("cartMapper.insertCart", ci);
	}

	@Override
	public void deleteCart(CartItem ci) {
		this.sqlSession.delete("cartMapper.deleteCart", ci);
	}

	@Override
	public void updateCart(CartItem ci) {
		this.sqlSession.delete("cartMapper.updateCart", ci);
	}

	@Override
	public List<CartItem> selectCart(String id) {
		return this.sqlSession.selectList("cartMapper.selectCart", id);
	}

}
