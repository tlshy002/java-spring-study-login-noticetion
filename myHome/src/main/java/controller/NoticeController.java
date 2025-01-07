package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import model.LoginUser;
import model.Notice;
import model.StartEnd;

@Controller
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;
	
	
	@RequestMapping(value="/notice/list.html")
	public ModelAndView noticeList(Integer pageNo) {
		int currentPage = 1;
		if(pageNo != null) currentPage = pageNo;
		int start = (currentPage - 1) * 5;
		int end = ((currentPage - 1) * 5) + 6;
		StartEnd se = new StartEnd(); se.setStart(start); se.setEnd(end);
		List<Notice> noticeList = this.noticeDao.getNoticeList(se);
		int totalCount = this.noticeDao.getCount();
		int pageCount = totalCount / 5;
		if(totalCount % 5 != 0) pageCount++;
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("PAGES", pageCount);
		mav.addObject("BODY","noticeList.jsp");
		mav.addObject("NOTICES",noticeList);//검색 결과를 저장한다.
		return mav;
	}
	
	@RequestMapping(value="/notice/putForm.html")
	public ModelAndView inputform(@Valid Notice notice, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		
		if(br.hasErrors()) {
			mav.addObject("BODY","notice_inputForm.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		LoginUser user = (LoginUser)session.getAttribute("loginUser");
		String id = user.getId();
		int num = this.noticeDao.getMaxNum() + 1;
		notice.setNum(num);//글번호 설정
		notice.setWriter(id);//작성자 설정
		this.noticeDao.putNotice(notice);
		mav.addObject("BODY","noticeInputResult.jsp");
		return mav;
	}
	
	@RequestMapping(value="/notice/formform.html")
	public ModelAndView formform() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject(new Notice());//주입할 인스턴스 생성
		mav.addObject("BODY","notice_inputForm.jsp");
		return mav;
	}
	
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