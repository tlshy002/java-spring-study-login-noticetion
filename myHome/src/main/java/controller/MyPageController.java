package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MyInformationDao;
import model.LoginUser;
import model.User_info;

@Controller
public class MyPageController {
	@Autowired
	private MyInformationDao myInformationDao;
	
	
	@RequestMapping(value="/mypage/myinformation.html")
	public ModelAndView mypage(HttpSession session) {
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("index");
		User_info mypage = this.myInformationDao.getUser(loginUser.getId());
		
		mav.addObject("BODY", "myInfo.jsp");
		mav.addObject(mypage);
		return mav;
	} //정보 수정하기를 클릭한 경우
	
	@RequestMapping(value="/mypage/index.html")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("BODY", "mypage.jsp");
		return mav;
	}
}
