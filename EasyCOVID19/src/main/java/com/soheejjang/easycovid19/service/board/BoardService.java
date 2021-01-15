package com.soheejjang.easycovid19.service.board;

import java.util.List;

import com.soheejjang.easycovid19.model.board.dto.BoardDTO;

public interface BoardService {
 
	public void create(BoardDTO dto) throws Exception; //글 쓰기
	public BoardDTO read(int bno) throws Exception; //글 읽기
	public void update(BoardDTO dto) throws Exception; //글 수정
	public void delete(int bno) throws Exception; //글 삭제
	
	//목록(페이지 나누기, 검색기능 포함)
	public List<BoardDTO> listAll(int start) throws Exception;
	
	//조회수 증가처리
	public void increaseViewCnt(int bno) throws Exception;
	//레코드 갯수 계산
	public int countArticle(String searchOption, String keyword) throws Exception;
	
}
