package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;
import model.Nation;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Nation> getNation() {
		return this.sqlSession.selectList("itemMapper.getNations");
	}

	@Override
	public Integer getCodeDup(String code) {
		return this.sqlSession.selectOne("itemMapper.getCodeDup",code);
	}

	@Override
	public void putItem(Item item) {
		this.sqlSession.insert("itemMapper.putItems", item);
	}

}
