package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public Integer getMaxNum() {
		return this.sqlSession.selectOne("noticeMapper.getMaxNum");
	}

	@Override
	public void putNotice(Notice notice) {
		this.sqlSession.insert("noticeMapper.putNotice", notice);
	}

}
