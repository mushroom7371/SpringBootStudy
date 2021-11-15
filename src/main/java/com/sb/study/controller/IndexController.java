package com.sb.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sb.study.vo.PagingVo;
import com.sb.study.vo.StudyAttVo;
import com.sb.study.vo.StudyVo;
import com.sb.study.dao.StudyDao;
import com.sb.study.service.StudyService;

//@Controller					//MVC 패턴중 C, 사용자 요청을 처리한 후 지정된 뷰에 모델을 넘겨주는 역할을 함. 어노테이션을 통하여 해당클래스를 controller로 사용한다고 명시
//@EnableAutoConfiguration	// @EnableAutoConfiguration 어노테이션을 통해서 스프링부트(SpringBoot)의 설정을 자동으로 잡아준다.
//@RestController를 사용하면 json으로 반환하기 때문에 jsp 화면이 호출되지 않음, Controller를 사용해야됨
@Controller
public class IndexController {
	
	//각 상황의 타입에 맞는 loC컨테이너 안에 존재하는 Bean을 자동으로 주입함. new 로 객체를 만들 필요가 없다.
	@Autowired
	StudyDao dao;
	
	@Autowired
	FileUploadController fileUpload;
	
	List<StudyAttVo> attList;
	
	//매핑을 통하여 url이 /로 들어오면 실행되는 메서드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){

		return "index";	//localhost로 들어오면 바로 jsp를 띄우도록 하였음. properties의 pre,suf fix로 경로를 지정한 index파일을 띄울수 있도록 함
		//jsp 호출은 Contorller임...
	}
	
	@RequestMapping(value = "/search.springboot", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView search(){
		//Model은 데이터만 저장하지만 ModelAndView는 데이터와 이동하고자 하는 View Page를 같이 저장한다.
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("search");
		//참조변수 mav는 ModelAndView 타입의 인스턴스를 가리키고, 해당 인스턴스의 setViewName()을 통하여 View의 이름을 지정한다.
		//데이터를 보낼때는 addObject()를 통하여 '변수이름'과 '해당 데이터 값'을 설정할 수 있다.
		
		return mav;
	}
	
	@RequestMapping(value = "/searchR.springboot", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView searchR(PagingVo vo, ModelAndView mav
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage){
		
		int total = dao.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		vo = new PagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		System.out.println(vo.toString());
		
		//데이터를 내보내기 위해 addObject()메서드를 이용
		mav.addObject("paging", vo);
		mav.addObject("viewAll", dao.selectPaging(vo));
		mav.setViewName("search");
		
		return mav;
	}
	
	@RequestMapping(value="/view.springboot", method= {RequestMethod.POST})
	public ModelAndView view(StudyVo vo) {
		ModelAndView mv = new ModelAndView();
		StudyVo v = dao.viewStudyMember(vo.getsPhone());
		
		mv.addObject("list", v);
		mv.setViewName("view");	
		
		return mv;
	}
	
	@RequestMapping(value = "/insert.springboot", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView insert(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("insert");
		
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
 	@RequestMapping(value = "/insertR.springboot", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView insertR(StudyVo vo, HttpServletRequest req, HttpServletRequest resp){
		ModelAndView mav = new ModelAndView();
		
		dao.insertStudyMember(vo);
		mav.setViewName("search");

		return mav;
	}
	
	@RequestMapping(value = "/modify.springboot", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView modify(StudyVo vo, HttpServletRequest req, HttpServletRequest resp){
		ModelAndView mav = new ModelAndView();
		
		dao.modifyStudyMember(vo);
		mav.setViewName("search");
		
		return mav;
	}
	
	@RequestMapping(value = "/delete.springboot", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView delete(StudyVo vo, HttpServletRequest req, HttpServletRequest resp){
		ModelAndView mav = new ModelAndView();
		
		dao.deleteStudyMember(vo.getsPhone());
		mav.setViewName("search");
		
		return mav;
	}
	
	@RequestMapping(value="/fup.springboot", method= RequestMethod.POST)
	public void  upload(HttpServletRequest req, HttpServletResponse resp){
		attList = fileUpload.upload(req);
		
		if(attList.size() != 0) {	//첨부파일이 있으면 파일 업로드, 없으면 아무것도 안하고 넘어간다.
			dao.fileUpload(attList);			

			PrintWriter pw;
			//Stream 클래스는 입,출력을 쌍으로 제공하고있으나 PrintStream, PrintWriter 클래스는 출력만 제공함.
			//System.out 에서 사용하는 print(), println() 메서드 등이 PinrtStream 이다.
			//클라이언트로 부터 servlet으로 요청이 들어오면 요청 파라메터가 같이 오게되며 이를 req.getParameter("")등으로 파악함.
			//요청이 왔으므로 클라이언트로 응답을 하게 되는데 통상적으로 웹프로그래밍에서는 응답을 텍스트로 하게된다. 이때 스트림이라는 개념을 활용함
			//응답 스트림에 텍스트를 기록하는것이 가능한데 이때 .getWriter()등을 호출한다.
			
			try {
				pw = resp.getWriter();
				pw.print("ok...");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	

//	@Autowired
//	StudyService StudyService; 
//	
//	@RequestMapping(value="/")	//들어온 요청을 특정 메서드와 매핑하기 위해서 사용
// 	@ResponseBody //java 객체를 HTTP 요청의 body 내용으로 매핑하는 역할. VO 객체를 JSON으로 바꿔서 HTTP body에 담는 스프링 어노테이션
//    public List<StudyVo> sampleHome(@ModelAttribute("searchVO") StudyVo Vo, ModelMap model) throws Exception {
//		
//		List<StudyVo> eList = StudyService.selectStudyMember(Vo);
//
//		return eList;    
//    }
}
