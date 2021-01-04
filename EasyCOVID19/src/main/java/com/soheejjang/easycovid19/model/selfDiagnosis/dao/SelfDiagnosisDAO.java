package com.soheejjang.easycovid19.model.selfDiagnosis.dao;

import java.util.List;

import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;

public interface SelfDiagnosisDAO {

	public void create(SelfDiagnosisDTO dto) throws Exception; //글 쓰기
	public SelfDiagnosisDTO read(int bno) throws Exception; //글 읽기
	public void update(SelfDiagnosisDTO dto) throws Exception; //글 수정
	public void delete(int bno) throws Exception; //글 삭제

	//목록(페이지 나누기, 검색 기능 포함)
	public List<SelfDiagnosisDTO> listAll(int start, int end, String writer)
			throws Exception; 
	
	//레코드 갯수 계산
	public int countArticle(String writer)
		throws Exception;
}