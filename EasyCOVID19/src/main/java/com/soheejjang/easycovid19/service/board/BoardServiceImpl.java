package com.soheejjang.easycovid19.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soheejjang.easycovid19.model.board.dao.BoardDAO;
import com.soheejjang.easycovid19.model.board.dto.BoardDTO;

@Service // service bean
public class BoardServiceImpl implements BoardService {

	@Inject // dao의존관계 주입 
	BoardDAO boardDao;

	@Override
	public void create(BoardDTO dto) throws Exception {
		boardDao.create(dto); 
	}

	@Override
	public BoardDTO read(int bno) throws Exception { 
		return boardDao.read(bno);
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> listAll(int start) throws Exception {
		return boardDao.listAll(start);
	}

	@Override
	public void increaseViewCnt(int bno) throws Exception {
		boardDao.increaseViewcnt(bno);
	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception { 
		return boardDao.countArticle(searchOption, keyword);
	}

}
