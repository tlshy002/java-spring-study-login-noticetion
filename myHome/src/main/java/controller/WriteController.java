package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;
import model.Board;
import model.LoginUser;

@Controller
public class WriteController {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value="/write/entryBoard.html")
	public ModelAndView entryBoard(@Valid Board board, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		if(br.hasErrors()) {
			mav.addObject("BODY", "write_board.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		//글번호(자동증가), 작성자(HttpSession에서 가져온다)를 설정한다
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		board.setId(loginUser.getId()); //계정설정
		this.boardDao.putBoard(board);
		mav.addObject("BODY", "writeBoardResult.jsp");
		return mav;
	}

	@RequestMapping(value="/write/write.html")
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject(new Board());
		mav.addObject("BODY" ,"write_board.jsp");
		return mav;
	}
}
