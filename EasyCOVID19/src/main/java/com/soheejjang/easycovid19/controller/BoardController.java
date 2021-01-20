package com.soheejjang.easycovid19.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.soheejjang.easycovid19.model.board.dao.BoardDAO;
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
	public ModelAndView list( // defulatValue안하면 null때문에 400에러 날 수도있따.
			@RequestParam(defaultValue = "1") int curPage, // 원하는 페이지 (시작은 기본 1)
			@RequestParam(defaultValue = "all") String searchOption, @RequestParam(defaultValue = "") String keyword)
			throws Exception {

		int count = boardService.countArticle(); // 레코드 갯수

		// 페이지 나누기 처리
		Pager pager = new Pager(count, curPage);
		System.out.println(curPage);

		int start = pager.getPageBegin() - 1; // 시작번호　　
		List<BoardDTO> list = boardService.listAll(start); // 목록

		ModelAndView mav = new ModelAndView();
		mav.setViewName("board");// 이동할 페이지 지정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // 맵에 자료 저장
		map.put("pager", pager);
		map.put("count", count); 
		mav.addObject("map", map); // 데이터 저장
		return mav; // 페이지 이동(출력)
	}

	@RequestMapping("/insert.do")
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session) throws Exception {
		// 로그인한 사용자의 아이디
		String writer = (String) session.getAttribute("userId");
		dto.setWriter(writer);
		// 레코드가 저장됨
		boardService.create(dto);
		// 목록갱신
		return "redirect:/board.do";
	}

	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, 
			@RequestParam(defaultValue = "1") int curPage, // 원하는 페이지 (시작은 기본 1),
			HttpSession session) throws Exception {
		boardService.increaseViewCnt(bno);
		System.out.println("카운트한다아아 ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("view");
		mav.addObject("dto", boardService.read(bno));
		mav.addObject("curPage", curPage); 
		return mav; //mav.setViewName("view"); view.jsp로 감
	}
	
	@RequestMapping("/viewEdit.do")
	public String viewEdit (@RequestParam int bno, Model model) throws Exception {
		model.addAttribute("dto", boardService.read(bno));
		return "viewEdit";
	}

	@RequestMapping("/viewUpdate.do")
	public String viewUpdate (@ModelAttribute BoardDTO dto, 
			Model model) throws Exception { 
		boardService.update(dto);
		return "redirect:/board.do"; 
		///view.do?bno=76
	}
	
	@RequestMapping("/viewDelete.do")
	public String delete(@RequestParam int bno, Model model) throws Exception {   
		System.out.println(bno);
		boardService.delete(bno);
		return "redirect:/board.do";  
	}
}
