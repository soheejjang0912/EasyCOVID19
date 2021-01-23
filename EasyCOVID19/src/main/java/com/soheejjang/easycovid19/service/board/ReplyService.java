package com.soheejjang.easycovid19.service.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.soheejjang.easycovid19.model.board.dto.ReplyDTO;

public interface ReplyService {
	public List<ReplyDTO> list
		(Integer bno, HttpSession session);
	public void create(ReplyDTO dto);
}
