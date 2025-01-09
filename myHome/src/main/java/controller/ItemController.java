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
	
	@RequestMapping(value="/item/codecheck.html")
	public ModelAndView codecheck(String CODE) {
		ModelAndView mav = new ModelAndView("codeCheckResult");
		Integer count = this.itemDao.getCodeDup(CODE); 
		if(count > 0) { //이미 동일한 코드의 상품이 존재함
			mav.addObject("DUP","YES");
		} else { //동일한 코드의 상품이 없음
			mav.addObject("DUP","NO");
		}
		mav.addObject("CODE",CODE);
		return mav;
	}
	
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
