package com.soheejjang.easycovid19.service.member;

import javax.servlet.http.HttpSession;

import com.soheejjang.easycovid19.model.dto.MemberDTO;

public interface MemberService {
	public String loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
}
