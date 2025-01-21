package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MyInformationDao;
import dao.SalesDao;
import model.LoginUser;
import model.User_info;

@Controller
public class MyPageController {
	@Autowired
	private MyInformationDao myInformationDao;
	@Autowired
	private SalesDao salesDao;
	
	
	
	@RequestMapping(value="/mypage/history.html")
	public ModelAndView history(HttpSession session) { //계정을 가져와야하니까 session필요
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		String id = loginUser.getId(); //계정을 찾음
		
		ModelAndView mav = new ModelAndView("index");
		List<Object[]> salesList = this.salesDao.getSales(id); //계정으로 매출정보 검색
		mav.addObject("BODY", "salesHistory.jsp");
		mav.addObject("sales", salesList);
		return mav;
	}
	
	@RequestMapping(value="/mypage/modify.html")
	public ModelAndView modify(@Valid User_info user_info, BindingResult br) {
		ModelAndView mav = new ModelAndView("index");
		System.out.println("계정: "+ user_info.getUser_id());
		System.out.println("암호: "+ user_info.getUser_pw());
		System.out.println("주소: "+ user_info.getAddr());
		System.out.println("이름: "+ user_info.getName());
		System.out.println("전화번호: "+ user_info.getPhone());
		System.out.println("성별: "+ user_info.getGender());
		System.out.println("등급: "+ user_info.getGrade());
		System.out.println("이메일: "+ user_info.getEmail());
		System.out.println("생일: "+ user_info.getBirth());
		System.out.println("직원: "+ user_info.getJob());
		
		if(br.hasErrors()) {
			mav.addObject("BODY", "myInfo.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		
		this.myInformationDao.updateMyInformation(user_info); //가입자 정보수정
		User_info userInfo = this.myInformationDao.getUser(user_info.getUser_id());
		//변경된 가입자 정보를 검색함
		mav.addObject("BODY", "myInfoUpdateResult.jsp");
		mav.addObject(userInfo);
		return mav;
	}
	
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
