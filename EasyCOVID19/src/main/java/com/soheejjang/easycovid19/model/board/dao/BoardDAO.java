package com.soheejjang.easycovid19.model.board.dao;

import java.util.List;

import com.soheejjang.easycovid19.model.board.dto.BoardDTO;

public interface BoardDAO {

	public void create(BoardDTO dto) throws Exception; // 글 쓰기

	public BoardDTO read(int bno) throws Exception; // 글 읽기

	public void update(BoardDTO dto) throws Exception; // 글 수정

	public void delete(int bno) throws Exception; // 글 삭제

	public List<BoardDTO> listAll(int start) throws Exception; // 목록

	public void increaseViewcnt(int bno) throws Exception; // 조회수 증가 처리

	public int countArticle() throws Exception; // 레코드 갯수 계산
	
}
