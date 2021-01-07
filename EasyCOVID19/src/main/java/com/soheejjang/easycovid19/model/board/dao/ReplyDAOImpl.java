package com.soheejjang.easycovid19.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.board.dto.BoardDTO;
import com.soheejjang.easycovid19.model.board.dto.ReplyDTO;

@Repository // dao bean으로 등록 -> dao는 직접 관리안하고 스프링이 관리!
public class ReplyDAOImpl implements ReplyDAO {

	@Inject // 의존관계 주입
	SqlSession sqlSession; //myBatis도 직접 관리안하고 스프링이 관리!

	@Override
	public List<ReplyDTO> list(Integer bno, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(ReplyDTO dto) { 
		sqlSession.insert("reply.insertReply", dto);
	}

	@Override
	public void update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReplyDTO detail(int rno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 
}
