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
public class Study_MemberController {

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
	
	@RequestMapping("member/update.do")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		//비밀번호 체크
		boolean result = memberDao.checkPassword(dto.getUserId(), dto.getUserPw());
		if(result) {
			memberDao.update(dto);
			return "redirect:/member/list.do";
		} else {
			//가입일자가 지워지지 않도록 처리
			MemberDTO dto2 = memberDao.detail(dto.getUserId());
			dto.setJoinDate(dto2.getJoinDate());
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "member/detail";
		}
	}
	
	@RequestMapping("member/delete.do")
	public String delete(@RequestParam String userId, @RequestParam String userPw, Model model) {
		//비밀번호 체크
		boolean result = memberDao.checkPassword(userId, userPw);
		if(result) {
			//삭제처리
			memberDao.delete(userId);
			//회원 목록으로 이동
			return "redirect:/member/list.do";
		}else {
			//비번이 틀렸을 떄
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto", memberDao.detail(userId));
			//detail.jsp로 포워드
			return "member/detail";
		}
	}
}
