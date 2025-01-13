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
	public void updateOrderNo(Imagebbs bbs) {
		this.sqlSession.update("imageMapper.updateOrderNo", bbs);
	}

	@Override
	public void updateImageBBS(Imagebbs bbs) {
		this.sqlSession.update("imageMapper.updateImageBBS", bbs);
	}

	@Override
	public void deleteImageBBS(Integer id) {
		this.sqlSession.delete("imageMapper.deleteImageBBS", id);
	}

	@Override
	public Integer getReplyCount(Integer id) {
		return this.sqlSession.selectOne("imageMapper.getReplyCount", id);
	}

	@Override
	public Imagebbs getImageDetail(Integer id) {
		return this.sqlSession.selectOne("imageMapper.getImageDetail", id);
	}

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
