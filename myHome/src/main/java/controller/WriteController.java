package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;
import model.Board;

@Controller
public class WriteController {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value="/write/entryBoard.html")
	public ModelAndView entryBoard(Board board) {
		this.boardDao.putBoard(board);
		ModelAndView mav = new ModelAndView("index");
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
