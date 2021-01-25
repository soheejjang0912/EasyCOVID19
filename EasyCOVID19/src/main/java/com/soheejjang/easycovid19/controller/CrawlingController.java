package com.soheejjang.easycovid19.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 

@Controller 
public class CrawlingController {  

	@RequestMapping("/aboutCovid.do") public String aboutCovid(Model model) throws IOException {
		  
        String URL = "http://ncov.mohw.go.kr/baroView.do";
        Document doc = Jsoup.connect(URL).get();
        
        Elements about = doc.select("div.data_table");
        Elements update =doc.select("div.content div p.ta_r.mgt36");
          
        model.addAttribute("about", about);
        model.addAttribute("update", update);

        return "aboutCovid";  
	}
	
	@RequestMapping("/news.do") public String news(Model model) 
			throws IOException {
		  
		String URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=news&query=%EC%BD%94%EB%A1%9C%EB%82%98+%EB%89%B4%EC%8A%A4&oquery=%EC%BD%94%EB%A1%9C%EB%82%98+%EB%89%B4%EC%8A%A4&tqi=U%2BYBLwp0YihssfNaKUGssssss68-387464";
        Document doc = Jsoup.connect(URL).get();
        
        Elements elem = doc.select("div.group_news"); 
        
        model.addAttribute("about", elem); 
 
        return "news";  
	}
	
}