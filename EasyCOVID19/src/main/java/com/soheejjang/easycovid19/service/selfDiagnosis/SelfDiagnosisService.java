package com.soheejjang.easycovid19.service.selfDiagnosis;

import java.util.List;
  
import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;

public interface SelfDiagnosisService {

	public void deleteFile(String fullName); //첨부파일 삭제
	public List<String> getAttach(int bno); //첨부파일 목록
	public void addAttach(String fullName); //첨부파일 저장
	public void updateAttach(String fullName, int bno); //첨부파일 수정
	public void create(SelfDiagnosisDTO dto) throws Exception; //글 쓰기
	public SelfDiagnosisDTO read(int bno) throws Exception; //글 읽기
	public void update(SelfDiagnosisDTO dto) throws Exception; //글 수정
	public void delete(int bno) throws Exception; //글 삭제
	
	//목록(페이지 나누기, 검색기능 포함)
	public List<SelfDiagnosisDTO> listAll(int start, int end,
			String searchOption, String keyword) throws Exception;
	
	//조회수 증가처리
	public void increaseViewCnt(int bno) throws Exception;
	//레코드 갯수 계산
	public int countArticle(String searchOption, String keyword) throws Exception;
	
}
