package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;
import model.Nation;
import model.StartEnd;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession sqlSession;

	
	
	@Override
	public void updateItem(Item item) {
		this.sqlSession.update("itemMapper.updateItem", item);
	}

	@Override
	public void deleteItem(String code) {
		this.sqlSession.delete("itemMapper.deleteItem", code);
	}

	@Override
	public Item getItem(String code) {
		return this.sqlSession.selectOne("itemMapper.getItem", code);
	}

	@Override
	public Integer getTotalItems() {
		return this.sqlSession.selectOne("itemMapper.getTotalItems");
	}

	@Override
	public List<Item> getItems(StartEnd se) {
		return this.sqlSession.selectList("itemMapper.getItems", se);
	}

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
