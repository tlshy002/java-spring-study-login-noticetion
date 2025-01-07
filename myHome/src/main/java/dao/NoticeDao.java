package dao;

import model.Notice;

public interface NoticeDao {
	Integer getMaxNum();
	void putNotice(Notice notice);
}
