package com.soheejjang.easycovid19.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; 
import com.soheejjang.easycovid19.model.member.dao.MemberDAO;
import com.soheejjang.easycovid19.model.member.dto.MemberDTO;
import com.soheejjang.easycovid19.service.member.MemberService;

@Controller // 현재클래스가 스프링에서 관리하는 컨트롤러라고 등록한 것
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject // 객체관리를 직접 안하고 스프링에서 해주게 하는것
	MemberService memberService;

	@Inject
	MemberDAO memberDao;

	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		memberService.logout(session); // 세션 초기화 작업 -> session.invalidate(); 이렇게만 해도 괜찮음
		mav.setViewName("index"); // 이동할 페이지
		return mav; // 페이지 이동
	}

	@RequestMapping("/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberDTO dto, HttpSession session) {
		// 로그인 성공 => 이름이 넘어옴, 실패=> null이 넘어옴
		String name = memberService.loginCheck(dto, session);
		//logger.info("name:" + name);
		ModelAndView mav = new ModelAndView();
		if (name != null) { // 로그인 성공하면 시작페이지로 이동
			mav.setViewName("index");
		} else { // 로그인 실패하면 login페이지로 다시 돌아감
			mav.addObject("message", "error");
			mav.setViewName("login");
		}
		return mav;
	}

	@RequestMapping("/join.do")
	public String join() {
		return "join";
	}

	@RequestMapping("/joinAction.do")
	public String joinAction(@ModelAttribute MemberDTO dto) {
		memberDao.joinAction(dto);
		return "redirect:/login.do";
	}

	@RequestMapping("/memberEdit.do")
	public String modification(@RequestParam String userId, Model model) { // memberEdit.do?userId=${sessionScope.userId}
		// 회원정보를 모델에 저장
		model.addAttribute("dto", memberDao.detail(userId));
		// 포워딩
		return "memberEdit"; // detail
	}

	@RequestMapping("/update.do")
	public String update(@ModelAttribute MemberDTO dto, Model model, HttpSession session) {
		// 비밀번호 체크
		boolean result = memberDao.checkPassword(dto.getUserId(), dto.getUserPw());
		if (result) {
			memberDao.update(dto);
			String user = (String) session.getAttribute("userId");
			return "redirect:/memberEdit.do?userId=" + user;
		} else {
			MemberDTO dto2 = memberDao.detail(dto.getUserId());
			model.addAttribute("dto", dto2);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "memberEdit";
		}
	}

	@RequestMapping("/delete.do")
	public String delete(@RequestParam String userId, @RequestParam String userPw, Model model) {
		// 비밀번호 체크
		boolean result = memberDao.checkPassword(userId, userPw);
		if (result) {
			// 삭제 처리
			memberDao.delete(userId);
			return "redirect:/logout.do";
		} else {
			// 비번이 틀렸을 때
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto", memberDao.detail(userId));
			return "memberEdit";
		}
	}

}