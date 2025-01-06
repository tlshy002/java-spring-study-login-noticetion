package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	void putBoard(Board bbs); //게시글 삽입 메서드
	List<Board> readBoard(Integer pageNo); //게시글 목록 검색 메서드
}
