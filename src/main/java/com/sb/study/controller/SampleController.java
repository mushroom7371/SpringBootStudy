package com.sb.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.study.vo.StudyVo;
import com.sb.study.service.StudyService;

//@Controller					//MVC 패턴중 C, 사용자 요청을 처리한 후 지정된 뷰에 모델을 넘겨주는 역할을 함. 어노테이션을 통하여 해당클래스를 controller로 사용한다고 명시
//@EnableAutoConfiguration	// @EnableAutoConfiguration 어노테이션을 통해서 스프링부트(SpringBoot)의 설정을 자동으로 잡아준다.
@RestController
public class SampleController {
	
	@Autowired
	StudyService StudyService; 
	
	@RequestMapping(value="/")	//들어온 요청을 특정 메서드와 매핑하기 위해서 사용
	@ResponseBody				//java 객체를 HTTP 요청의 body 내용으로 매핑하는 역할. VO 객체를 JSON으로 바꿔서 HTTP body에 담는 스프링 어노테이션
    public List<StudyVo> sampleHome(@ModelAttribute("searchVO") StudyVo Vo, ModelMap model) throws Exception {
		
		List<StudyVo> eList = StudyService.selectStudyMember(Vo);
		
		return eList;    
    }
}
