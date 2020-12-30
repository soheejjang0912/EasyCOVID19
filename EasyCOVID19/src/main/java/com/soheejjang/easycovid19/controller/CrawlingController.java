package com.soheejjang.easycovid19.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller 
public class CrawlingController {  
	
	@RequestMapping("/aboutCovid.do") public String aboutCovid(Model model) throws IOException {
		  
        String URL = "http://ncov.mohw.go.kr/baroView.do";
        Document doc = Jsoup.connect(URL).get();
        
        Elements elem = doc.select("div.data_table");
        String[] str = elem.text().split(" ");
        Elements elem2=doc.select("div.content div p.ta_r.mgt36");
          
        model.addAttribute("about", elem);
        model.addAttribute("update", elem2);

		 
        return "aboutCovid"; //main.jsp -> servlet-context.xml에서 접미사,접두사 설정을 했기 때문에 main만 쳐도 이동 가능 
	}
	
	@RequestMapping("/aboutCovid.do") public String main2(Model model) throws IOException {
		  
        String URL = "http://ncov.mohw.go.kr/baroView.do";
        Document doc = Jsoup.connect(URL).get();
        
        Elements elem = doc.select("div.data_table");
        String[] str = elem.text().split(" ");
        Elements elem2=doc.select("div.content div p.ta_r.mgt36");
        
		/* System.out.println(doc); */
        System.out.println("elem==============================" + elem); 
        System.out.println("elem222==============================" +elem2);
        
        model.addAttribute("name", elem);
        model.addAttribute("message", elem2);

		 
        return "aboutCovid"; //main.jsp -> servlet-context.xml에서 접미사,접두사 설정을 했기 때문에 main만 쳐도 이동 가능 
	}
	 
}