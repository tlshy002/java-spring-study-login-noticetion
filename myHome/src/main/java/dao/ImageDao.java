package dao;

import model.Imagebbs;

public interface ImageDao {
	Integer getMaxWid(); //가장 큰 이미지 게시글 번호 검색
	void putImagebbs(Imagebbs bbs); //이미지 게시글 insert
}
