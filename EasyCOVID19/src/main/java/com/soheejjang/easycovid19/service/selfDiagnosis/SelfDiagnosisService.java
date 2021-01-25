package com.soheejjang.easycovid19.service.selfDiagnosis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;

 
public interface SelfDiagnosisService { 
	  
	public List<SelfDiagnosisDTO> listAll(int start, String writer) throws Exception; // 목록
	
	public void create(SelfDiagnosisDTO dto) throws Exception; // 글 쓰기
	  
	public int countArticle(String writer) throws Exception; // 레코드 갯수 계산
	
}
