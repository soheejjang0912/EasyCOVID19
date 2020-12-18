package com.soheejjang.easycovid19.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.soheejjang.easycovid19.model.dao.MemberDAO;
import com.soheejjang.easycovid19.model.dto.MemberDTO;

@Service // dao 호출위해
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	
	@Override
	public String loginCheck(MemberDTO dto, HttpSession session) {
		//맞으면 이름이 넘어오고 틀리면 null이 넘어온다.
		String name=memberDao.loginCheck(dto);
		
		if(name != null) {//맞으면
			//세션변수 등록
			session.setAttribute("userId", dto.getUserId());
			session.setAttribute("name", name);
		}
		return name;
	} 
	
	@Override
	public void logout(HttpSession session) {
		//세션 전부 초기화
		session.invalidate();
	}

}
