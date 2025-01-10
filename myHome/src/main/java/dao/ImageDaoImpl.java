package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Imagebbs;
import model.StartEnd;

@Repository
public class ImageDaoImpl implements ImageDao {
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public Integer getTotal() {
		return this.sqlSession.selectOne("imageMapper.getTotal");
	}

	@Override
	public List<Imagebbs> imageList(StartEnd st) {
		return this.sqlSession.selectList("imageMapper.imageList", st);
	}

	@Override
	public Integer getMaxWid() {
		return this.sqlSession.selectOne("imageMapper.getMaxWid");
	}

	@Override
	public void putImagebbs(Imagebbs bbs) {
		this.sqlSession.insert("imageMapper.putImagebbs", bbs);
	}

}
