package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.Nation;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/item/entry.html")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("index");
		List<Nation> nationList = this.itemDao.getNation(); //원산지 목록을 검색
		mav.addObject(new Item()); //Item 인스턴스 주입
		mav.addObject("BODY", "input_item.jsp");
		mav.addObject("NATIONS", nationList);
		return mav;
	}
}
