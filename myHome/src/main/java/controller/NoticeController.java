package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import model.LoginUser;
import model.Notice;

@Controller
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping(value="/notice/inputForm.html")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("BODY", "notice_input.jsp");
		return mav;
	}

	@RequestMapping(value="/notice/input.html")
	public ModelAndView input(String TITLE, String CONTENT, HttpSession session) {
		Notice notice = new Notice();
		int num = this.noticeDao.getMaxNum() + 1;
		
		notice.setNum(num); //공지글 설정
		LoginUser user = (LoginUser)session.getAttribute("loginUser");
		notice.setWriter(user.getId()); //작성자 설정
		notice.setTitle(TITLE); 
		notice.setContent(CONTENT);
		this.noticeDao.putNotice(notice);//공지글을 DB에 삽입
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("BODY","noticeInputResult.jsp");
		return mav;
	}
	
}
