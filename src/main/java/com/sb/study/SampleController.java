package com.sb.study;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller					//MVC 패턴중 C, 사용자 요청을 처리한 후 지정된 뷰에 모델을 넘겨주는 역할을 함. 어노테이션을 통하여 해당클래스를 controller로 사용한다고 명시
@EnableAutoConfiguration	// @EnableAutoConfiguration 어노테이션을 통해서 스프링부트(SpringBoot)의 설정을 자동으로 잡아준다.
public class SampleController {
	
	@RequestMapping(value="/")	//들어온 요청을 특정 메서드와 매핑하기 위해서 사용
	@ResponseBody				//java 객체를 HTTP 요청의 body 내용으로 매핑하는 역할. VO 객체를 JSON으로 바꿔서 HTTP body에 담는 스프링 어노테이션
    public String sampleHome() {
		
        return "Hello Spring Boot!";	//메서드 선언시 String 타입을 반환하도록 명시하였기에 return 또한 문자열이 된다.
        
    }
}
