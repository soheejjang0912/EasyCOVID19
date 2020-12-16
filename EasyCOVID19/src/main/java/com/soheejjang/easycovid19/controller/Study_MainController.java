package com.soheejjang.easycovid19.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soheejjang.easycovid19.model.dto.PointDTO;
import com.soheejjang.easycovid19.model.dto.ProductDTO;

@Controller
public class Study_MainController {
	
	//http://localhost:8080
	@RequestMapping("/studyMain") public String main(Model model) {
	  model.addAttribute("name", "유재석"); model.addAttribute("message",
	  "홈페이지 방문을 환영합니다."); 
	  return "main"; //main.jsp -> servlet-context.xml에서 접미사,접두사 설정을 했기 때문에 main만 쳐도 이동 가능 
	}
	 
	
	@RequestMapping("gugu.do")
	public String write() {
		return "test/gugu";
	}
	
	@RequestMapping("gugu_result.do")
	//@RequestParam 은 값을 하나만 받을 때(개별변수로 전달) 
	//@ModelAttribute 은 값을 여러개 받을 때 (모델클래스로 한꺼번에 전달)
	public String gugu(@RequestParam(defaultValue = "3")int dan, Model model) {
		String result = "";
		for(int i=1; i<=9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu_result";
	} 
	
	@RequestMapping("point.do")
	public String poin() {
		return "test/point";
	}
	
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
	 
		String average = String.format("%.2f", dto.getTotal()/3.0);
		dto.setAverage(Double.parseDouble(average));
		 
		model.addAttribute("dto", dto);
		
		return "test/point_result";
	} 
	
	@RequestMapping("move.do")
	public String move() {
		//redirect 방식은 데이터의 전달이 안됨(파라미터만 전달) 주로 컨트롤러의 다른 method로 이동할 경우 주로 사용됨 ex)게시판에서 글을 작성 완료 후 목록으로 이동할 경우
		return "redirect:/result.do";
		//return "redirect:/result.do?name=kim&age=20";
	}
	
	@RequestMapping("result.do")
	public String result (Model model, 
			@RequestParam(defaultValue = "noname") String name,
			@RequestParam(defaultValue = "10") int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "test/result";
	}
	
	@RequestMapping("mav.do")
	public ModelAndView mav() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", new ProductDTO("샤프", 1000));
		//ModelAndView(url, key, value)
		return new ModelAndView("test/mav_result", "map", map);
	}
	
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax";
	}
	
	//{"key":"value"}
	//{"name":"냉장고", "price":"50000"}
	@RequestMapping("background.do")
	public @ResponseBody ProductDTO background() {
		ProductDTO dto = new ProductDTO("냉장고", 50000);
		//리턴을 페이지가 아닌 데이터 자체를 보내줌(비동기식 호출) @ResponseBody
		return dto;
	}
	
	@RequestMapping("login.do")
	public String login() {
		return "test/login";
	}
	
	
	@RequestMapping("login_result.do")
	public String login_result(@RequestParam String id, 
								@RequestParam String pw,
								Model model) {
		String result ="";
		if(id.equals("kim") && pw.equals("1234")) {
			result="환영합니다.";
		}else {
			result="아이디 또는 비밀번호가 틀렸습니다.";
		}
		model.addAttribute("result", result);
		return "test/login_result";
	}
	
	@RequestMapping("ajax_gugu.do")
	public String ajax_gugu() {
		return "test/ajax_gugu";
	}
	
	@RequestMapping("ajax_gugu_result")
	public String ajax_gugu_result(@RequestParam(defaultValue ="3") int dan,
			Model model) {
		String result = "";
		for(int i = 1; i <= 9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/ajax_gugu_result";
	}
}

 
 