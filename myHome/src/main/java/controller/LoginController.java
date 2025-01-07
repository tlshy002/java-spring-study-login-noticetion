package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import model.LoginUser;

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/login/loginDo.html", method=RequestMethod.POST)
	public ModelAndView loginDo(@Valid LoginUser loginUser, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		} //어노테이션을 이용한 폼체크
		
		LoginUser user = this.userDao.getLoginUser(loginUser);
		mav.addObject("BODY", "loginResult.jsp");
		if(user == null) { //로그인 실패
			mav.addObject("FAIL", "YES");
		} else { //로그인 성공
			session.setAttribute("loginUser", user);
		}
		return mav;
	}

	@RequestMapping(value="/login/login.html")
	public ModelAndView loginForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		request.setAttribute("loginUser", new LoginUser()); //login.jsp에 객체를 주입함(form:form이기 때문에)
		//mav.addObject(new LoginUser()); 
		return mav;
	} 
}
