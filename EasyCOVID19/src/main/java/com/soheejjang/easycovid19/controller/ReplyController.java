package com.soheejjang.easycovid19.controller;
 
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import com.soheejjang.easycovid19.model.board.dto.ReplyDTO; 
import com.soheejjang.easycovid19.service.board.ReplyService;

@Controller // controller bean 
public class ReplyController {

	@Inject // 서비스 객체 주입
	ReplyService replyService; 
	
	@RequestMapping("replyinsert.do") // 세부적인 mapping
	public void insert(ReplyDTO dto, 
			HttpSession session) {
		String writer = (String)session.getAttribute("userId"); //("userid")로 했어서 값을 못불러왔었음... 확인 잘 할것!!
		System.out.println("????????"+writer);
		dto.setReplyer(writer);
		//String userid=(String)session.getAttribute("userid");
		//dto.setReplyer(userid);
		//System.out.println("---------------------------"+userid);

		System.out.println("-----dto"+dto);
		replyService.create(dto);
	}
}
