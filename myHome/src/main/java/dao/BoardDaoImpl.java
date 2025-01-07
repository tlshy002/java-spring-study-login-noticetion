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
	public Integer getMaxSeq() {
		Integer maxSeq = this.session.selectOne("boardMapper.getMaxSeq");
		if(maxSeq == null) return 0;
		else return maxSeq;
	}

	@Override
	public void putBoard(Board bbs) {
		bbs.setSeq(this.getMaxSeq() + 1); //글번호 설정
		this.session.insert("boardMapper.putBoard", bbs);
	}

	@Override
	public List<Board> readBoard(Integer pageNo) {
		return null;
	}

}
