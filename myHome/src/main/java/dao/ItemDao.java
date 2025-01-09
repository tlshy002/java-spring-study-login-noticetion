package dao;

import java.util.List;

import model.Item;
import model.Nation;


public interface ItemDao {
	List<Nation> getNation(); //상품 원산지 콤보박스용
	Integer getCodeDup(String code); //상품코드 중복 검사용
	void putItem(Item item); //상품 등록용
}
