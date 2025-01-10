package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Imagebbs;
import utils.FileValidator;

@Controller
public class ImageController {
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping(value="/image/write.html") //@Valid를 통해 어노테이션 폼체크를 함
	public ModelAndView write(@Valid @ModelAttribute("bbsimage") Imagebbs imagebbs,
								BindingResult br) {
		this.fileValidator.validate(imagebbs, br); //파일선택 유무를 검사함
		ModelAndView mav = new ModelAndView("index");
		if(br.hasErrors()) {
			mav.addObject("BODY", "imageWriteForm.jsp");
			mav.getModel().putAll(br.getModel());
		}
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
