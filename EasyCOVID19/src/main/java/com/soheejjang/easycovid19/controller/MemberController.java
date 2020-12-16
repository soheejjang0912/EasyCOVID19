package com.soheejjang.easycovid19.controller;

 
import java.io.PrintWriter;
import java.util.List; 

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soheejjang.easycovid19.model.dao.MemberDAO;
import com.soheejjang.easycovid19.model.dto.MemberDTO;
import com.soheejjang.easycovid19.service.member.MemberService;

@Controller //현재클래스가 스프링에서 관리하는 컨트롤러라고 등록한 것 
public class MemberController {
 
	private static final Logger logger =
			LoggerFactory.getLogger(MemberController.class);
	   
	@Inject //객체관리를 직접 안하고 스프링에서 해주게 하는것 
	MemberService memberService;
	
	@Inject
	MemberDAO memberDao;
	
	//회원 등록폼으로 이동
	@RequestMapping("login.do")
	public String write() {
		return "login";
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberDTO dto,
			HttpSession session) {
		//로그인 성공 => 이름이 넘어옴, 실패=> null이 넘어옴
		String name = memberService.loginCheck(dto, session);
		logger.info("name:"+name);
		ModelAndView mav = new ModelAndView();
		if(name != null) { //로그인 성공하면 시작페이지로 이동 
			mav.setViewName("index");
		}else { //로그인 실패하면 login페이지로 다시 돌아감
			mav.addObject("message","error");
			mav.setViewName("login"); 
		}
		return mav;
	}
	
	
	@RequestMapping("join.do")
	public String join() {
		return "join";
	}
	
	@RequestMapping("joinAction.do")
	public String joinAction(@ModelAttribute MemberDTO dto) {
		memberDao.joinAction(dto);
		return "redirect:/login.do";
	}
	
}
