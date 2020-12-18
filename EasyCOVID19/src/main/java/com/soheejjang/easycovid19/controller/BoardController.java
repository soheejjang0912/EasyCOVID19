package com.soheejjang.easycovid19.controller;

 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;import com.soheejjang.easycovid19.model.board.dao.BoardDAO;
import com.soheejjang.easycovid19.model.board.dto.BoardDTO;
import com.soheejjang.easycovid19.service.board.BoardService;
import com.soheejjang.easycovid19.service.board.Pager;

@Controller // controller bean
//@RequestMapping("/board/*") // packege 만들면 공통적인 mapping위해 사용해야함
public class BoardController {

	@Inject // 서비스 객체 주입
	BoardService boardService;
	
	@RequestMapping("/write.do")
	public String write() {
		return "write";
	}
 
	@RequestMapping("/board.do") // 세부적인 mapping
	public ModelAndView list(			//defulatValue안하면 null때문에 400에러 날 수도있따. 
			@RequestParam(defaultValue = "1") int curPage, // 원하는 페이지 (시작은 기본 1) 
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String keyword 
			) throws Exception{
		int count = 1000; // 레코드 갯수
		Pager pager = new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<BoardDTO> list = boardService.listAll(start, end, searchOption, keyword); //목록
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board");// 이동할 페이지 지정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // 맵에 자료 저장
		map.put("searchOption", searchOption);
		map.put("keyword", keyword); 
		map.put("pager", pager);
		map.put("count", count);
		
		mav.addObject("map", map); // 데이터 저장
		return mav; // 페이지 이동(출력) 
	}  
	
	/*
	@RequestMapping("/board.do") // 세부적인 mapping
	public ModelAndView list() throws Exception{
		List<BoardDTO> list = boardService.listAll(0, 0, "", ""); //목록 (start, end, searchOption, keyword)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board");// 이동할 페이지 지정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // 맵에 자료 저장
		mav.addObject("map", map); // 데이터 저장
		return mav; // 페이지 이동(출력) 
	}
	*/
	
	@RequestMapping("/insert.do")
	public String insert(@ModelAttribute BoardDTO dto, 
			HttpSession session) throws Exception{
		// 로그인한 사용자의 아이디
		String writer = (String)session.getAttribute("userId");
		dto.setWriter(writer);
		//레코드가 저장됨
		boardService.create(dto);
		//목록갱신
		return "redirect:/board.do";
	}
}
