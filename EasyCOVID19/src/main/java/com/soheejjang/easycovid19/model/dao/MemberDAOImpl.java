package com.soheejjang.easycovid19.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public List<MemberDTO> list() {
									//member = namespace // list = id
		return sqlSession.selectList("member.list");
	}

	@Override
	public void insert(MemberDTO dto) {
		sqlSession.insert("member.insert", dto);
		
	}

	//selectOne() 레코드가 1개
	//selectList() 레코드가 2개이상
	@Override
	public MemberDTO detail(String userId) { 
		return sqlSession.selectOne("member.detail", userId); //이 userId는 member.xml의 userId에 들어간다.
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean check_password(String userId, String userPw) {
		// TODO Auto-generated method stub
		return false;
	}

}
