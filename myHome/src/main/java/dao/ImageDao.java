package dao;

import java.util.List;

import model.Imagebbs;
import model.StartEnd;

public interface ImageDao {
	Integer getMaxWid(); //가장 큰 이미지 게시글 번호 검색
	void putImagebbs(Imagebbs bbs); //이미지 게시글 insert
	List<Imagebbs> imageList(StartEnd st); //이미지 게시글의 목록을 검색
	Integer getTotal(); //이미지 게시글의 개수 검색
}