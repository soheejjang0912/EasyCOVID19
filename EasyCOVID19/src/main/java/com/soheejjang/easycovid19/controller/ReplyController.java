package com.soheejjang.easycovid19.controller;
 
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soheejjang.easycovid19.model.board.dto.ReplyDTO; 
import com.soheejjang.easycovid19.service.board.ReplyService;
import com.soheejjang.easycovid19.service.selfDiagnosis.Pager;

@Controller // controller bean 
public class ReplyController {

	@Inject // 서비스 객체 주입
	ReplyService replyService; 
	
	@RequestMapping("/replyInsert.do")  
	public void insert(ReplyDTO dto, HttpSession session) {
		String writer = (String)session.getAttribute("userId"); //("userid")로 했어서 값을 못불러왔었음... 확인 잘 할것!! 
		dto.setReplyer(writer);  
		System.out.println("??????????????????"+dto.getReplytext());
		
		replyService.create(dto);
		System.out.println("??????????????????"+dto);  
	}
	
	@RequestMapping("/replyList.do")
	public ModelAndView list(int bno,
			@RequestParam(defaultValue = "1")int curPage,
			ModelAndView mav, 
			HttpSession session) {
		int count=replyService.count(bno); //댓글 수
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		List<ReplyDTO> list=
			replyService.list(bno, start, end, session);
		mav.setViewName("replyList");
		mav.addObject("list", list);
		mav.addObject("pager", pager);
		return mav;
	}
	
	
	
}
