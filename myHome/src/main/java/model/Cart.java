package model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.CartDao;

@Service
@Scope("session")
public class Cart {
	@Autowired
	private CartDao cartDao;
	
	private String id; //장바구니의 주인 => 계정
	private String code; //상품 번호
	private Integer num; //상품 개수
	
	private ArrayList<String> codeList = new ArrayList<String>(); //상품번호 목록
	private ArrayList<Integer> numList = new ArrayList<Integer>(); //상품개수 목록
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public ArrayList<String> getCodeList() { 
		return codeList;
	}
	public void setCodeList(int index, String code) { //codeList에 상품번호를 넣는 메서드 (위치와 상품번호 두가지를 한번에 넣고 싶어서 세터 수정함)
		this.codeList.add(index, code); //자동으로 생성된 
	}
/*	자동으로 생성된 세터는 "new ArrayList<String>()"를 매개변수로 입력받아서 인스턴스를 생성하는 세터함수라면
 * 지금 우리가 원하는 세터함수는 저게 아님. 코드리스트의 인스턴스를 미리 생성해두고 상품의 index와 code 두가지를 한번에 매개변수로 받고자 함
 * public void setCodeList(ArrayList<String> codeList) { 
		this.codeList = codeList;
	}
*/	
	public ArrayList<Integer> getNumList() {
		return numList;
	}
	public void setNumList(int index, Integer num) {
		this.numList.add(index, num);
	}
	
	
	public void modifyItem(String code, String id, Integer num) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, num); //i번째 상품의 개수를 num으로 수정
				/// DB연동 시작 /// --> 장바구니에 담는족족 DB에 반영됨
				CartItem ci = new CartItem();
				ci.setId(id);
				ci.setItem_code(code);
				ci.setNum(num);
				this.cartDao.updateCart(ci); //update
				/// DB연동 끝 ///
				return; //메서드 종료
			}
		}
	}//장바구니에서 상품을 수정하는 메서드
	
	public void deleteItem(String code, String id) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {//입력된 상품코드와 i번째 상품코드가 같은경우
				codeList.remove(i); //i번째 상품코드를 삭제
				numList.remove(i); //i번째 상품의 개수를 삭제
				/// DB연동 시작 ///
				CartItem ci = new CartItem();
				ci.setId(id);
				ci.setItem_code(code);
				this.cartDao.deleteCart(ci); //delete
				/// DB연동 끝 ///
				return; //메서드 종료
			}
		}
	}//장바구니에서 상품을 삭제하는 메서드
	
	
	public void addCart(String code, Integer num) { //상품번호와 개수를 codeList와 numList에 저장하는 메서드
		//code를 codeList에 넣고, num을 numList에 넣는다. 
		//근데 넣기전에, 중복 검사하고 넣어야함
		
		for(int i=0; i<codeList.size(); i++) { //code가 이미 codeList에 존재하는지 반복으로 찾기
			if(codeList.get(i).equals(code)) { //codeList의 i번째의 상품번호와 입력받은 상품번호가 일치한 경우
				int number = numList.get(i); //i번째 상품의 개수를 찾음
				number = number + num; //상품개수 증가
				numList.set(i, number); //i번째 상품의 개수를 number의 개수로 변경함
				// 똑같은 상품이 있을때 개수를 바꿔주기 때문에 update
				/// DB연동 시작 ///
				CartItem ci = new CartItem();
				ci.setId(id);
				ci.setItem_code(code);
				ci.setNum(num);
				this.cartDao.updateCart(ci); //DB에 update
				/// DB연동 끝 ///
				return; //메서드 종료
			}
		}
		codeList.add(code); numList.add(num); //장바구니에 없는 상품이면 새로 추가하기
		// 새로운 상품 추가이므로 insert
		/// DB연동 시작 ///
		CartItem ci = new CartItem();
		ci.setId(id);
		ci.setItem_code(code);
		ci.setNum(num);
		if(this.cartDao == null) System.out.println("cartDao is null");
		else System.out.println("cartDao IS NOt Null");
		this.cartDao.insertCart(ci); //DB에 insert
		/// DB연동 끝 ///
	}
}
