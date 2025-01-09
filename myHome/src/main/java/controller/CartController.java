package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Cart;
import model.LoginUser;

@Controller
public class CartController {

	
	@RequestMapping(value="/cart/addCart.html")
	public ModelAndView addCart(String CODE, HttpSession session) {
		LoginUser user = (LoginUser)session.getAttribute("loginUser");
		if(user == null) { //로그인 안한 경우 => 로그인 창 띄우기
			ModelAndView mav = new ModelAndView("login");
			return mav;
			
		} else { //로그인 한 경우
			ModelAndView mav = new ModelAndView("addCartResult");
			Cart cart = (Cart)session.getAttribute("CART"); //세션에서 장바구니(Cart)를 찾음
			
			if(cart == null) cart = new Cart(); //세션에 장바구니가 없으면 생성함
			cart.setId(user.getId()); //장바구니에 계정을 설정
			cart.addCart(CODE, 1); //장바구니에 상품번호를  codeList에, 1을 numList에 저장하기
			mav.addObject("CODE", CODE);
			mav.addObject("NUM", 1);
			session.setAttribute("CART", cart); //세션에 장바구니(Cart)를 저장함
		}
		return null;
	}
}
