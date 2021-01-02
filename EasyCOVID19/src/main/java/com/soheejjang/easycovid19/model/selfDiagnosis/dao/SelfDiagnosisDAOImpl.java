package com.soheejjang.easycovid19.model.selfDiagnosis.dao;

import java.util.List;

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
		// TODO Auto-generated method stub
		return sqlSession.selectList("selfDiagnosis.listAll");
	}

	@Override
	public int countArticle() throws Exception { 
		return 0;
	}

}
