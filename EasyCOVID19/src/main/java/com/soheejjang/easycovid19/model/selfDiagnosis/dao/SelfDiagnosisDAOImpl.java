package com.soheejjang.easycovid19.model.selfDiagnosis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;

@Repository //dao bean으로 등록
public class SelfDiagnosisDAOImpl implements SelfDiagnosisDAO {

	@Inject //의존관계 주입
	SqlSession sqlSession;
	
	@Override
	public List<SelfDiagnosisDTO> listAll(int start, String writer) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();  
		map.put("start", start); 
		map.put("writer", writer); 
		return sqlSession.selectList("selfDiagnosis.listAll", map);
	}
	
	@Override
	public int countArticle(String writer) throws Exception { 
		return sqlSession.selectOne("selfDiagnosis.countArticle", writer);
	}
	
	@Override
	public void create(SelfDiagnosisDTO dto) throws Exception {
		sqlSession.insert("selfDiagnosis.insert", dto); 
	}

}
