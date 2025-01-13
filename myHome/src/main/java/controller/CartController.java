package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.CartDao;
import dao.ItemDao;
import model.Cart;
import model.CartItem;
import model.Item;
import model.LoginUser;

@Controller
@Scope("session")
public class CartController {
	@Autowired
	private ItemDao itemDao;

	@Autowired
	private Cart cart;

	
	
	@RequestMapping(value="/cart/modify.html") //세션에서 장바구니를 찾아야 하기 때문에 세션필요
	public ModelAndView modify(String CODE, Integer NUM, String BTN, HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART");
		LoginUser user = (LoginUser)session.getAttribute("loginUser");
		
		if(BTN.equals("삭제")) {
			cart.deleteItem(CODE, user.getId()); //장바구니에서 삭제
		} else if(BTN.equals("수정")) {
			cart.modifyItem(CODE, user.getId(), NUM); //장바구니에서 수정
		}
		return new ModelAndView("redirect:/cart/show.html");
	}
	
	@RequestMapping(value="/cart/show.html")
	public ModelAndView show(HttpSession session) {
		LoginUser user = (LoginUser)session.getAttribute("loginUser"); //세션에서 계정을 찾음
		Cart cart = (Cart)session.getAttribute("CART"); //세션에서 장바구니를 찾음
		ModelAndView mav = new ModelAndView("index"); 
		
		if(cart != null) { //장바구니가 세션에 존재하는 경우
			int totalAmount = 0; //장바구니가 세션에 존재하는 경우
			ArrayList<String> codeList = cart.getCodeList(); //장바구니에서 codeList를 가져옴
			ArrayList<Integer> numList = cart.getNumList(); //장바구니에서 numList를 가져옴
			ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();
			for(int i=0; i<codeList.size(); i++) {
				String code = codeList.get(i); //i번째 상품코드를 가져옴
				
				Item item = this.itemDao.getItem(code); //상품번호로 해당 상품을 DB조회 -> 조회결과를 CartItem에 저장
				CartItem ci = new CartItem(); //CartItem생성
				
				ci.setItem_code(item.getItem_code());
				ci.setItem_title(item.getItem_title());
				ci.setMadein(item.getMadein());
				ci.setPrice(item.getPrice()); //Item의 가격 -> CartItem의 가격으로 할당
				ci.setReg_date(item.getReg_date());
				
				ci.setNum(numList.get(i)); //i번째 상품의 개수를 CartItem에 설정
				ci.setSum(ci.getPrice() * ci.getNum()); //소계를 계산함
				totalAmount += (ci.getPrice() * ci.getNum()); //총액을 누적
				ci.setId(user.getId()); //계정을 cartItem에 설정
				
				cartItemList.add(ci); //CartItem을 ArrayList에 저장
			}
			mav.addObject("TOTAL", totalAmount); //주문총액을 ModelAndView에 저장
			mav.addObject("CARTLIST", cartItemList); //CartItem이 저장된 ArrayList를 mav에 저장
			
			
			//return mav;로 끝난후에는 저장되어있던 카트리스트가 없어지기 때문에
			//Checkout컨트롤러에서 사용하기위한 카트리스트를 세션에 저장함(장바구니 목록)
			session.setAttribute("CARTLIST", cartItemList); 
			
		} else { //장바구니가 세션에 없는 경우
			mav.addObject("CARTLIST", null);
		}
		mav.addObject("BODY", "cartList.jsp");
		return mav;
	}
	
	@RequestMapping(value="/cart/addCart.html")
	public ModelAndView addCart(String CODE, HttpSession session) {
		LoginUser user = (LoginUser)session.getAttribute("loginUser");
		if(user == null) { //로그인 안한 경우 => 로그인 창 띄우기
			ModelAndView mav = new ModelAndView("login");
			return mav;
			
		} else { //로그인 한 경우
			ModelAndView mav = new ModelAndView("addCartResult");
			Cart cart = (Cart)session.getAttribute("CART"); //세션에서 장바구니(Cart)를 찾음
			
			if(cart == null) cart = this.cart; //세션에 장바구니가 없으면, 생성된 장바구니를 주입함 (@Autowired한 Cart)
			cart.setId(user.getId()); //장바구니에 계정을 설정
			cart.addCart(CODE, 1); //장바구니에 상품번호를  codeList에, 1을 numList에 저장하기
			mav.addObject("CODE", CODE);
			mav.addObject("NUM", 1);
			session.setAttribute("CART", cart); //세션에 장바구니(Cart)를 저장함
			return mav;
		}
	}
}
