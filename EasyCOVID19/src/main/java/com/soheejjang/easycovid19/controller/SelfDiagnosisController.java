package com.soheejjang.easycovid19.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soheejjang.easycovid19.model.selfDiagnosis.dto.SelfDiagnosisDTO;
import com.soheejjang.easycovid19.service.selfDiagnosis.Pager;
import com.soheejjang.easycovid19.service.selfDiagnosis.SelfDiagnosisService;

@Controller // controller bean
//@RequestMapping("/board/*") // packege 만들면 공통적인 mapping위해 사용해야함
public class SelfDiagnosisController {

	@Inject // 서비스 객체 주입
	SelfDiagnosisService selfDiagnosisService;
	
	@RequestMapping("/selfDiagnosisWrite.do")
	public String write() {
		return "selfDiagnosisWrite";
	}
 
	@RequestMapping("/selfDiagnosis.do") // 세부적인 mapping
	public ModelAndView list(	//defulatValue안하면 null때문에 400에러 날 수도있따. 
			@RequestParam(defaultValue = "1") int curPage, // 원하는 페이지 (시작은 기본 1) 
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String keyword ) throws Exception{
		
		int count = selfDiagnosisService.countArticle(searchOption, keyword); // 레코드 갯수
		
		//페이지 나누기 처리
		Pager pager = new Pager(count, curPage); 
		System.out.println(curPage);
		
		int start= pager.getPageBegin()-1; //시작번호
		int end= pager.getPageEnd();		//끝번호 
		
		
		System.out.println("--start----------------"+ start);
		System.out.println("---end---------------"+ end); 
		
		List<SelfDiagnosisDTO> list = selfDiagnosisService.listAll(
				start, end, searchOption, keyword); //목록
		

		System.out.println("-list-----------------"+ list);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selfDiagnosis");// 이동할 페이지 지정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // 맵에 자료 저장
		map.put("searchOption", searchOption);
		map.put("keyword", keyword); 
		map.put("pager", pager);
		map.put("count", count);
		
		mav.addObject("map", map); // 데이터 저장
		System.out.println("--map----------------"+ map);
		
		return mav; // 페이지 이동(출력) 
	}  
	
	  
	
	@RequestMapping("/insertSelfDiagnosis.do")
	public String insert(@ModelAttribute SelfDiagnosisDTO dto, 
			HttpSession session) throws Exception{
		// 로그인한 사용자의 아이디
		String writer = (String)session.getAttribute("userId"); 
		//레코드가 저장됨
		selfDiagnosisService.create(dto);
		//목록갱신
		return "redirect:/selfDiagnosis.do";
	}
}