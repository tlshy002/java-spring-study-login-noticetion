package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Nation;

@Controller
public class NationController {
	
	
	
	@RequestMapping(value="/nation/codeCheck.html") //국가코드 중복검사
	public ModelAndView codeCheck(String CODE) {
		System.out.println("컨트롤러로 전달된 국가코드: " + CODE);
		return null;
	}
	
	@RequestMapping(value="/nation/inputNation.html")
	public ModelAndView inputNation() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject(new Nation()); //인스턴스 주입
		mav.addObject("BODY", "inputNation.jsp");
		return mav;
	}
}
