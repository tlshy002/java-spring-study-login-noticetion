package controller;

import java.util.List;

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
	
	@RequestMapping(value="/write/modify/html") //boardDetail.jsp로부터 4개의 파라미터를 받음
	public ModelAndView modify(Integer SEQ, String TITLE, String CONTENT, String BTN) {
		if(BTN.equals("수정")) {
			
		} else if(BTN.equals("삭제")) {
			
		}
 		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/write/detail.html")
	public ModelAndView detail(Integer SEQ) {
		Board bbs = this.boardDao.readDetail(SEQ); //글번호로 게시글 검색
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("BODY", "boardDetail.jsp"); //검색된 게시글을 출력하는
		mav.addObject("BOARD", bbs); //jsp에서 검색된 게시글을 
		return mav;
	}
	
	@RequestMapping(value="/write/read.html")
	public ModelAndView read(Integer pageNo) {
		List<Board> bbsList = this.boardDao.readBoard(pageNo);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("BODY", "boardList.jsp");
		mav.addObject("BOARD",bbsList); //게시글 조회결과 bbsList를 "BOARD"라는 이름으로 저장해서 boardList.jsp에서 사용할 수 있도록함
		return mav;
	}
	
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
