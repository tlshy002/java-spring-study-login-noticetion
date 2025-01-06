package controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.LoginUser;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login/loginDo.html", method=RequestMethod.POST)
	public ModelAndView loginDo(@Valid LoginUser loginUser, BindingResult br) {
		ModelAndView mav = new ModelAndView("index");
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
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
