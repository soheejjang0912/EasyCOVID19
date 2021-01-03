package com.soheejjang.easycovid19.service.selfDiagnosis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;

 
public interface SelfDiagnosisService { 
	
	public void create(SelfDiagnosisDTO dto) throws Exception; //글 쓰기
	public SelfDiagnosisDTO read(int bno) throws Exception; //글 읽기
	public void update(SelfDiagnosisDTO dto) throws Exception; //글 수정
	public void delete(int bno) throws Exception; //글 삭제
	
	//목록(페이지 나누기, 검색기능 포함)
	public List<SelfDiagnosisDTO> listAll(int start, int end) 
			throws Exception;
	 
	//레코드 갯수 계산
	public int countArticle() throws Exception;
	
}
