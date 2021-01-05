package com.soheejjang.easycovid19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller
public class MainController {
	
	//http://localhost:8080  
	@RequestMapping("/")
	public String main() {
		return "index"; //main.jsp -> servlet-context.xml에서 접미사, 접두사 설정을 했기 때문에 main만 쳐도 이동 가능
	}
	
	@RequestMapping("/aboutSite.do")
	public String aboueSite() {
		return "aboutSite";
	}
	 
}