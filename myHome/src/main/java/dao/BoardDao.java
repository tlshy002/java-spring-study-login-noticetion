package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	Integer totalCount(); //전체 게시글 개수를 리턴하는 메서드
	
	void deleteBoard(Integer seq); //게시글 삭제 메서드
	void updateBoart(Board board); //게시글 변경(제목,내용)메서드
	
	Integer getMaxSeq(); //가장 큰 글번호 검색 메서드
	void putBoard(Board bbs); //게시글 삽입 메서드
	List<Board> readBoard(Integer pageNo); //게시글 목록 검색 메서드
	Board readDetail(Integer seq); //글번호로 게시글 검색 메서드
}
