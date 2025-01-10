package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Imagebbs;

@Repository
public class ImageDaoImpl implements ImageDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public Integer getMaxWid() {
		return this.sqlSession.selectOne("imageMapper.getMaxWid");
	}

	@Override
	public void putImagebbs(Imagebbs bbs) {
		this.sqlSession.insert("imageMapper.putImagebbs", bbs);
	}

}
