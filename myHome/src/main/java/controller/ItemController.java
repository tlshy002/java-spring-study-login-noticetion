package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.LoginUser;
import model.Nation;
import model.StartEnd;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	
	@RequestMapping(value="/item/modifyff.html")
	public ModelAndView modifyff(@Valid Item item, BindingResult br, String BTN) {
		ModelAndView mav = new ModelAndView("index");
		if(br.hasErrors()) {
			mav.addObject("BODY", "itemDetailAdminFF.jsp");
			List<Nation> nationList = this.itemDao.getNation(); //원산지 목록을 검색
			mav.addObject("NATIONS", nationList);
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		if(BTN.equals("삭제")) {
			this.itemDao.deleteItem(item.getItem_code());
			mav.addObject("BODY", "itemDeleteResult.jsp");
		} else if(BTN.equals("수정")) {
			this.itemDao.updateItem(item);
			mav.addObject("BODY", "itemUpdateResult.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/item/modify.html")
	public ModelAndView modify(String CODE, String NAME, Integer PRICE, String NATION, String SPEC ,String BTN) {
		ModelAndView mav = new ModelAndView("index");
		
		if(BTN.equals("삭제")) {
			this.itemDao.deleteItem(CODE);
			mav.addObject("BODY", "itemDeleteResult.jsp");
		} else if(BTN.equals("수정")) {
			Item item = new Item();
			item.setItem_code(CODE);
			item.setItem_title(NAME);
			item.setPrice(PRICE);
			item.setMadein(NATION);
			item.setItem_spec(SPEC);
			
			this.itemDao.updateItem(item);
			mav.addObject("BODY", "itemUpdateResult.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/item/detail.html") //관리자(admin)로 로그인한 경우에는 상품상세정보 화면에 수정,삭제 버튼이 있어야함
	public ModelAndView detail(String CODE, HttpSession session) { //세션에서 계정을 찾아봐야하기 때문에 session필요
		ModelAndView mav = new ModelAndView("index");
		Item item = this.itemDao.getItem(CODE); //CODE에 있는 상품코드로 상품을 검색한다
		
		
		//둘의 차이는
		//mav.addObject("ITEM", item); //==> form일때는 파라미터 타입이라 이름이 필요함
		mav.addObject(item); // ==> form:form은 객체 주입이라 이름이 필요없음 //mav에 Item인스턴스 주입
		
		LoginUser user = (LoginUser)session.getAttribute("loginUser");
		if(user != null && user.getId().equals("admin")) { //관리자인 경우
			List<Nation> nationList = this.itemDao.getNation(); //원산지 목록을 검색
			mav.addObject("NATIONS", nationList);
			//mav.addObject("BODY", "itemDetailAdmin.jsp"); //상품 상세보기(form)
			mav.addObject("BODY", "itemDetailAdminFF.jsp"); //상품 상세보기(form:form)
			
		} else { //관리자가 아닌 경우
			//mav.addObject("BODY", "itemDetail.jsp"); //상품 상세보기(form)
			mav.addObject("BODY", "itemDetailFF.jsp"); //상품 상세보기(form:from)
		}
		return mav;
	} 
	
	@RequestMapping(value="/item/itemList.html")
	public ModelAndView itemList(Integer PAGE_NUM) { //itemList.jsp에서 페이지번호를 클릭했을때 넘어오는 값을 매개변수로 받음
		int currentPage = 1;
		if(PAGE_NUM != null) currentPage = PAGE_NUM;
		
		int start = (currentPage - 1) * 5;
		int end = ((currentPage - 1) * 5) + 6;
		
		StartEnd se = new StartEnd();
		se.setStart(start);
		se.setEnd(end);
		
		List<Item> itemList = this.itemDao.getItems(se); //5개의 상품목록 검색
		Integer totalCount = this.itemDao.getTotalItems(); //전체 상품 개수 검색
		
		int pageCount = totalCount / 5;
		if(totalCount % 5 != 0) pageCount++;
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("startRow", start);
		mav.addObject("endRow", end);
		mav.addObject("total", totalCount);
		mav.addObject("ITEMS", itemList);
		mav.addObject("pageCount", pageCount);
		mav.addObject("currentPage", currentPage);
		mav.addObject("BODY", "itemsList.jsp");
		return mav;
	}
	
	@RequestMapping(value="/item/register.html")
	public ModelAndView register(@Valid Item item, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		if(br.hasErrors()) {
			mav.addObject("BODY", "input_item.jsp");
			List<Nation> nationList = this.itemDao.getNation(); //원산지 목록을 검색
			mav.addObject("NATIONS", nationList);
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		this.itemDao.putItem(item); //상품테이블에 insert
		mav.addObject("BODY","putItemsResult.jsp");
		return mav;
	}
	
	@RequestMapping(value="/item/codecheck.html")
	public ModelAndView codecheck(String CODE) {
		ModelAndView mav = new ModelAndView("codeCheckResult");
		Integer count = this.itemDao.getCodeDup(CODE); 
		if(count > 0) { //이미 동일한 코드의 상품이 존재함
			mav.addObject("DUP","YES");
		} else { //동일한 코드의 상품이 없음
			mav.addObject("DUP","NO");
		}
		mav.addObject("CODE",CODE);
		return mav;
	}
	
	@RequestMapping(value="/item/entry.html")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("index");
		List<Nation> nationList = this.itemDao.getNation(); //원산지 목록을 검색
		mav.addObject(new Item()); //Item 인스턴스 주입
		mav.addObject("BODY", "input_item.jsp");
		mav.addObject("NATIONS", nationList);
		return mav;
	}
}
