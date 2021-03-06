package com.soheejjang.easycovid19.model.member.dao;

 
import java.util.HashMap;
import java.util.Map;
import java.util.List; 

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.member.dto.MemberDTO;

@Repository //잊지않기!
public class MemberDAOImpl implements MemberDAO {

	@Inject //마이바티스 해야하니까!
	SqlSession sqlSession;

	@Override
	public List<MemberDTO> list() {
									//member = namespace // list = id
		return sqlSession.selectList("member.list");
	}

	@Override
	public void joinAction(MemberDTO dto) {
		sqlSession.insert("member.joinAction", dto); 
	}
	

	@Override
	public String loginCheck(MemberDTO dto) { 
		return sqlSession.selectOne("member.loginCheck", dto);
	}

	//selectOne() 레코드가 1개
	//selectList() 레코드가 2개이상
	@Override
	public MemberDTO detail(String userId) { 
		return sqlSession.selectOne("member.detail", userId); //이 userId는 member.xml의 userId에 들어간다.
	}

	@Override
	public void delete(String userId) { 
		sqlSession.delete("member.delete", userId);
	}

	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}

	@Override
	public boolean checkPassword(String userId, String userPw) {
		boolean result = false;
		//mybatis mapper에 전달할 값이 2개 이상인 경우
		//dto또는 맵으로 전달
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		int count = sqlSession.selectOne("member.checkPassword",map); //selectOne은 하나밖에 못보내서 map으로 묶어 전달해야함
		//레코드가 1개이면 true, 0개이면 false 리턴
		if(count==1)
			result = true; 
		return result;
	}


}
