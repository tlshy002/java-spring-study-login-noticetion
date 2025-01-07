package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Notice;
import model.StartEnd;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public Integer getCount() {
		return this.sqlSession.selectOne("noticeMapper.getNoticeCount");
	}

	@Override
	public List<Notice> getNoticeList(StartEnd st) {
		return this.sqlSession.selectList("noticeMapper.getNoticeList", st);
	}

	@Override
	public Integer getMaxNum() {
		return this.sqlSession.selectOne("noticeMapper.getMaxNum");
	}

	@Override
	public void putNotice(Notice notice) {
		this.sqlSession.insert("noticeMapper.putNotice", notice);
	}

}
