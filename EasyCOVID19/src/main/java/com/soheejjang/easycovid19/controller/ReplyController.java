package com.soheejjang.easycovid19.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soheejjang.easycovid19.model.board.dto.ReplyDTO;
import com.soheejjang.easycovid19.service.board.ReplyService;
import com.soheejjang.easycovid19.service.selfDiagnosis.Pager;

@Controller // controller bean 
public class ReplyController {

	@Inject // 서비스 객체 주입
	ReplyService replyService; 
	
	@ResponseBody
	
	@RequestMapping("/replyInsert.do")  
	public void insert(ReplyDTO dto, HttpSession session) {
		String writer = (String)session.getAttribute("userId"); //("userid")로 했어서 값을 못불러왔었음... 대소문자 확인 잘 할것!! 
		dto.setReplyer(writer);   
		replyService.create(dto); 
	} 
	
	@RequestMapping("/replyList.do")
	public ModelAndView list(int bno,
			@RequestParam(defaultValue = "1")int curPage,
			ModelAndView mav, 
			HttpSession session) { 
		List<ReplyDTO> list=
			replyService.list(bno, session); 
		mav.setViewName("replyList");
		mav.addObject("list", list);
		return mav;
	}
	
}
