package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImageController {
	
	@RequestMapping(value="/image/imageWrite.html")
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView("index");
		
		mav.addObject("BODY","imageWriteForm.jsp"); //include페이지에 들어감
		return mav;
	}
}
