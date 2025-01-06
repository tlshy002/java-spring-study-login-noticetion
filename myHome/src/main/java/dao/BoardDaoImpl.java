package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public void putBoard(Board bbs) {
		this.session.insert("boardMapper.putBoard", bbs);
	}

	@Override
	public List<Board> readBoard(Integer pageNo) {
		return null;
	}

}
