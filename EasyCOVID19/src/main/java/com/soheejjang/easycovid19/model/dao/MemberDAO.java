package com.soheejjang.easycovid19.model.dao;

import java.util.List;

import com.soheejjang.easycovid19.model.dto.MemberDTO;

public interface MemberDAO {
	public List<MemberDTO> list();
	public void joinAction(MemberDTO dto);
	public String loginCheck(MemberDTO dto);
	
	public MemberDTO detail(String userId);
	public void delete(String userId);
	public void update(MemberDTO dto);
	public boolean checkPassword(String userId, String userPw);
}
