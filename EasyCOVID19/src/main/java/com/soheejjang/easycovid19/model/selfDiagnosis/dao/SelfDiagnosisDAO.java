package com.soheejjang.easycovid19.model.selfDiagnosis.dao;

import java.util.List;

import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;

public interface SelfDiagnosisDAO {  
	public List<SelfDiagnosisDTO> listAll(int start, String writer) throws Exception;  //목록
	
	public int countArticle(String writer) throws Exception; //레코드 갯수 계산
	
	public void create(SelfDiagnosisDTO dto) throws Exception; //글 쓰기
}