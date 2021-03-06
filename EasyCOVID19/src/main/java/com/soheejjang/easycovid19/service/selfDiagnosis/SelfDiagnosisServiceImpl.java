
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
	public List<SelfDiagnosisDTO> listAll(int start, String writer) throws Exception {
		return selfDiagnosisDao.listAll(start, writer);
	}
	
	@Override
	public void create(SelfDiagnosisDTO dto) throws Exception {
		selfDiagnosisDao.create(dto);
	}
 
	@Override
	public int countArticle(String writer) throws Exception { 
		return selfDiagnosisDao.countArticle(writer);
	}

}
