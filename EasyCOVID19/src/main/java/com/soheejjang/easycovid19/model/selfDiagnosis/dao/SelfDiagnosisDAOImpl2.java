package com.soheejjang.easycovid19.model.selfDiagnosis.dao;
/*
 * package com.soheejjang.easycovid19.model.selfDiagnosis.dao;
 * 
 * import java.util.HashMap; import java.util.List; import java.util.Map;
 * 
 * import javax.inject.Inject;
 * 
 * import org.apache.ibatis.session.SqlSession;
 * 
 * import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;
 * 
 * public class SelfDiagnosisDAOImpl implements SelfDiagnosisDAO {
 * 
 * @Inject // 의존관계 주입 SqlSession sqlSession; //myBatis도 직접 관리안하고 스프링이 관리!
 * 
 * @Override public void create(SelfDiagnosisDTO dto) throws Exception {
 * sqlSession.insert("selfDiagnosis.insert", dto); }
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
 * searchOption, String keyword) throws Exception { // TODO Auto-generated
 * method stub Map<String,Object> map = new HashMap<String, Object>();
 * map.put("searchOption", searchOption); map.put("keyword", keyword);
 * map.put("start", start); map.put("end", start);
 * 
 * return sqlSession.selectList("selfDiagnosis.listAll", map); }
 * 
 * @Override public int countArticle(String searchOption, String keyword) throws
 * Exception { // TODO Auto-generated method stub return 0; }
 * 
 * }
 */