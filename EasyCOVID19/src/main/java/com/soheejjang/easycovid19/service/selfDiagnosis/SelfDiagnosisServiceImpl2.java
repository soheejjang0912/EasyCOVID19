/*
 * package com.soheejjang.easycovid19.service.selfDiagnosis;
 * 
 * package com.soheejjang.easycovid19.service.selfDiagnosis;
 * 
 * import java.util.List;
 * 
 * import javax.inject.Inject;
 * 
 * import org.springframework.stereotype.Service;
 * 
 * import com.soheejjang.easycovid19.model.selfDiagnosis.dao.SelfDiagnosisDAO;
 * import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;
 * 
 * @Service // service bean public class SelfDiagnosisServiceImpl implements
 * SelfDiagnosisService {
 * 
 * @Inject // dao의존관계 주입 SelfDiagnosisDAO selfDiagnosisDAO;
 * 
 * @Override public void deleteFile(String fullName) { // TODO Auto-generated
 * method stub }
 * 
 * @Override public List<String> getAttach(int bno) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public void addAttach(String fullName) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * @Override public void updateAttach(String fullName, int bno) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void create(SelfDiagnosisDTO dto) throws Exception {
 * selfDiagnosisDAO.create(dto); }
 * 
 * @Override public SelfDiagnosisDTO read(int bno) throws Exception { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public void update(SelfDiagnosisDTO dto) throws Exception { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void delete(int bno) throws Exception { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public List<SelfDiagnosisDTO> listAll(int start, int end, String
 * searchOption, String keyword) throws Exception { return
 * selfDiagnosisDAO.listAll(start, end, searchOption, keyword); }
 * 
 * @Override public void increaseViewCnt(int bno) throws Exception { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public int countArticle(String searchOption, String keyword) throws
 * Exception { return selfDiagnosisDAO.countArticle(searchOption, keyword); }
 * 
 * }
 */