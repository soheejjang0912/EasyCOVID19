package com.soheejjang.easycovid19.service.selfDiagnosis;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soheejjang.easycovid19.model.selfDiagnosis.dao.SelfDiagnosisDAO;
import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;

@Service // service bean
public class SelfDiagnosisServiceImpl implements SelfDiagnosisService {

	@Inject //dao의존관계 주입
	SelfDiagnosisDAO selfDiagnosisDao;
	
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
		return selfDiagnosisDao.listAll(start, end);
	}

	@Override
	public int countArticle() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
