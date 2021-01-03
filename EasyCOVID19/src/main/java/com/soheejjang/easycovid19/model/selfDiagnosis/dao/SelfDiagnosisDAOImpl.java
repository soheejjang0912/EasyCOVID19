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
	public void create(SelfDiagnosisDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public SelfDiagnosisDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SelfDiagnosisDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SelfDiagnosisDTO> listAll(int start, int end) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();  
		map.put("start", start);
		map.put("end", start); 
		return sqlSession.selectList("selfDiagnosis.listAll", map);
	}

	@Override
	public int countArticle() throws Exception { 
		return 0;
	}

}
