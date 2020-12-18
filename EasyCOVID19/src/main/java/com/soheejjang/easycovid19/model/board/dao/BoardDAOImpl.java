package com.soheejjang.easycovid19.model.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.board.dto.BoardDTO;

@Repository // dao bean으로 등록 -> dao는 직접 관리안하고 스프링이 관리!
public class BoardDAOImpl implements BoardDAO {

	@Inject // 의존관계 주입
	SqlSession sqlSession; //myBatis도 직접 관리안하고 스프링이 관리!
	
	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub 
	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttach(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttach(String fullName, int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(BoardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub

	}
	
	//게시물 목록
	@Override
	public List<BoardDTO> listAll(int start, int end, String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.listAll");
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
