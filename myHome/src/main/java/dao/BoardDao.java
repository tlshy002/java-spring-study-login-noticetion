package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	Integer getMaxSeq(); //가장 큰 글번호 검색 메서드
	void putBoard(Board bbs); //게시글 삽입 메서드
	List<Board> readBoard(Integer pageNo); //게시글 목록 검색 메서드
	Board readDetail(Integer seq); //글번호로 게시글 검색 메서드
}
