package dao;

import java.util.List;

import model.Notice;
import model.StartEnd;

public interface NoticeDao {
	Integer getMaxNum(); //가장 큰 글번호 검색
	void putNotice(Notice notice); //게시글 삽입
	
	Integer getCount();//공지글 갯수 검색
	List<Notice> getNoticeList(StartEnd st);//공지글 목록 검색
}
