package com.soheejjang.easycovid19.model.board.dao;

import java.util.List;

import com.soheejjang.easycovid19.model.board.dto.BoardDTO;
import com.soheejjang.easycovid19.model.board.dto.ReplyDTO;

public interface ReplyDAO {
	public List<ReplyDTO> list(Integer bno); 
	public void create(ReplyDTO dto);
}
