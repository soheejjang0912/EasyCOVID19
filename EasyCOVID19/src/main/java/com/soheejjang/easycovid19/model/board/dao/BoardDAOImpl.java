package com.soheejjang.easycovid19.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession; 
import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.board.dto.BoardDTO;

@Repository // dao bean으로 등록 -> dao는 직접 관리안하고 스프링이 관리!
public class BoardDAOImpl implements BoardDAO {

	@Inject // 의존관계 주입
	SqlSession sqlSession; // myBatis도 직접 관리안하고 스프링이 관리!

	//! 자동완성 @Autowired 로 작성했다가 에러났었음... 잘 확인할것 ! 
	
	// 게시물 목록
	@Override
	public List<BoardDTO> listAll(int start) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start); 
		return sqlSession.selectList("board.listAll", map);
	}

	@Override
	public int countArticle() throws Exception { 
		return sqlSession.selectOne("board.countArticle"); 
	}
	
	@Override
	public void create(BoardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("board.view", bno);
	}
	 
	@Override
	public void update(BoardDTO dto) throws Exception {
		sqlSession.update("board.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.delete", bno);
	}
 
}
