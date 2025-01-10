package utils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.Imagebbs;

//파일이 선택됐는지 안됐는지,를 검사함
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { //폼체크의 대상이 되는 클래스가 매개변수로 들어옴
		return Imagebbs.class.isAssignableFrom(clazz);
	} //Validator의 대상이 Imagebbs클래스인지 비교검사해서 같으면 true를 리턴함 => true일때 validate동작함

	@Override
	public void validate(Object target, Errors errors) {
		Imagebbs bbs = (Imagebbs)target;
		if(bbs.getImage() == null) { //파일이 없음 == 파일을 선택안한 경우
			
		}
	}

}
