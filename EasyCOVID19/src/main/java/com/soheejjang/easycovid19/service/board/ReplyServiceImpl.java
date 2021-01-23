package com.soheejjang.easycovid19.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.soheejjang.easycovid19.model.board.dao.ReplyDAO;
import com.soheejjang.easycovid19.model.board.dto.ReplyDTO; 

@Service // service bean
public class ReplyServiceImpl implements ReplyService {

	@Inject // dao의존관계 주입 
	ReplyDAO replyDao;
	
	public void create(ReplyDTO dto) {
		replyDao.create(dto);
	}

	@Override
	public List<ReplyDTO> list(Integer bno, HttpSession session) {
		return replyDao.list(bno);
	}
	
}
