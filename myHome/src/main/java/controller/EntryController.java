package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.CheckDao;
import model.User;

@Controller
public class EntryController {
	@Autowired
	private CheckDao checkDao;
	
	
	@RequestMapping(value="/entry/idcheck.html") //계정 중복검사 매핑,메서드
	public ModelAndView idcheck(String USER_ID) {
		System.out.println("컨트롤러로 전달된 계정: "+ USER_ID);
		ModelAndView mav = new ModelAndView("idCheckResult");
		Integer count = this.checkDao.checkDupId(USER_ID);
		
		if(count > 0) { //이미 계정이 존재하는 경우 => 계정중복
			mav.addObject("DUP", "YES");
		} else { //계정이 존재하지 않는 경우 => 사용가능
			mav.addObject("DUP","NO");
		}
		mav.addObject("ID",USER_ID);
		return mav;
	}
	
	
	@RequestMapping(value="/entry/userEntry.html")
	public ModelAndView userEntry() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject(new User()); //인스턴스 주입
		mav.addObject("BODY", "userEntry.jsp");
		return mav;
	}
}
