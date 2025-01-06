package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;
import model.Board;

@Controller
public class WriteController {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value="/write/entryBoard.html")
	public ModelAndView entryBoard(@Valid Board board, BindingResult br) {
		ModelAndView mav = new ModelAndView("index");
		if(br.hasErrors()) {
			mav.addObject("BODY", "write_board.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
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
