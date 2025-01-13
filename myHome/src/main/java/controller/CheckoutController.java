package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import model.Cart;
import model.CartItem;
import model.LoginUser;
import model.User;

@Controller
public class CheckoutController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value="/checkout/checkout.html") //cartList.jsp에서 매핑
	public ModelAndView checkout(User user, Integer TOTAL, HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		Cart cart = (Cart)session.getAttribute("CART"); //세션에서 장바구니를 찾음
		User userInfo = this.userDao.getUserInfo(loginUser.getId());
		
		ArrayList<CartItem> cartList = (ArrayList<CartItem>)session.getAttribute("CARTLIST");
		mav.addObject("CARTLIST", cartList); //장바구니목록
		mav.addObject("User", userInfo); //계정정보
		mav.addObject("TOTAL", TOTAL); //물건총합
		mav.addObject("BODY", "checkout.jsp");
		return mav;
	}
	
	@RequestMapping(value="/checkout/end.html")
	public ModelAndView end() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("BODY", "end.jsp");
		return mav;
	}
}
