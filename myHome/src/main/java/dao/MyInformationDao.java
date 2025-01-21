package dao;

import model.User_info;

public interface MyInformationDao {
	User_info getUser(String id); //계정으로 정보조회
	void updateMyInformation(User_info user); //정보수정
}
