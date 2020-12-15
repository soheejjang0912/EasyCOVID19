package com.soheejjang.easycovid19.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soheejjang.easycovid19.model.dao.MemberDAO;
import com.soheejjang.easycovid19.model.dto.MemberDTO;

@Controller //현재클래스가 스프링에서 관리하는 컨트롤러라고 등록한 것 
public class MemberController {

	@Inject //객체관리를 직접 안하고 스프링에서 해주게 하는것 
	MemberDAO memberDao;
	
	@RequestMapping("member/list.do") //이주소로 들어온다.
	public String memberList(Model model) {
		List<MemberDTO> list = memberDao.list(); 
		model.addAttribute("items", list);
		return "member/list";
	}
	
	//회원 등록폼으로 이동
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}
	
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		memberDao.insert(dto);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userId, Model model) {
		//회원 정보를 모델에 저장
		model.addAttribute("dto", memberDao.detail(userId));
		//detail.jsp로 포워딩
		return "member/detail";
	}
	
}
