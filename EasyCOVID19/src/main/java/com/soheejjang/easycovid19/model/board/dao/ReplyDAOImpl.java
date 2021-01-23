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
	public List<ReplyDTO> list(Integer bno) { 
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("bno", bno);
		return sqlSession.selectList("reply.listReply", map);
	}

	@Override
	public void create(ReplyDTO dto) { 
		sqlSession.insert("reply.insertReply", dto);
	}
	
}
