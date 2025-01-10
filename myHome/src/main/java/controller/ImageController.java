package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Imagebbs;

@Controller
public class ImageController {
	
	@RequestMapping(value="/image/write.html")
	public ModelAndView write(@Valid @ModelAttribute("bbsimage") Imagebbs imagebbs,
								BindingResult br) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping(value="/image/imageWrite.html")
	public ModelAndView writeform() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("bbsimage", new Imagebbs());
		mav.addObject("BODY","imageWriteForm.jsp"); //include페이지에 들어감
		return mav;
	}
}
