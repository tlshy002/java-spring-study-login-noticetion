package controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

class BeerExpert {
	public ArrayList<String> getBrands(String color) {
		ArrayList<String> result = new ArrayList<String>();
		switch(color) {
		case "red": result.add("Red Wind"); result.add("Red Sun"); break;
		case "dark": result.add("Dark Night"); result.add("Night Shark"); result.add("Real Darkness"); break;
		case "brown": result.add("Kirin"); result.add("TshingTao"); break;
		case "black": result.add("Black Jack"); result.add("Black Smith"); result.add("Black One"); break;
		}
		return result;
	}
}

@Controller
public class BeerController { //여기까지만 요청이오고 어디 메서드로 매핑해야할지 구분을 못함 => value를 사용해서 요청을 나눠주기
	
	@RequestMapping(value="/beer/beer.html") //메뉴를 눌렀을때 바뀐 url
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/beer/result.html") //맥주를 선택했을때 바뀐 url로 매핑
	public ModelAndView makeResult(String COLOR) {
		ModelAndView mav = new ModelAndView(); //mav 파라미터에 값이 없기에 value=url에 따라 jsp를 찾음
		BeerExpert be = new BeerExpert();
		ArrayList<String> result = be.getBrands(COLOR);
		mav.addObject("BRANDS", result);
		return mav;
	}
}
