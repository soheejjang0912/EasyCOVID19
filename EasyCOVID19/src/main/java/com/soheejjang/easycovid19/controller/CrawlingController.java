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
	
	
	@RequestMapping("/aboutCovid2.do") 
	public ModelAndView aboutCovid2(Model model) 
			throws IOException {
		  
        String URL = "http://ncov.mohw.go.kr/baroView.do";
        Document doc = Jsoup.connect(URL).get();
        Elements e = doc.select("div.data_table table tbody tr");
        Elements elems = doc.select("table tbody tr th");
        Elements elemss = doc.select("table tbody tr td");
        //System.out.println(elems);
        //System.out.println(elemss);
        ArrayList<Elements> listaa;
        Elements b;
        Element a; 
        
        List<Elements> listA = new ArrayList<Elements>();
        List<Elements> listB = new ArrayList<Elements>();
        
        Map<String, Object>map = new HashMap<String, Object>();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("aboutCovid");
        for(Element test:e) {
        	model.addAttribute("aa", test.selectFirst("th")); 
        	model.addAttribute("bb", test.selectFirst("td")); 
        	map.put("bb", test.selectFirst("td"));  
        	
        	mav.addObject("map", map);
        }

    	System.out.println("map==="+map);
        
//        for(Element el: elems) {
//        	System.out.println("for================================="+el.text());
//        	model.addAttribute("el", el);
//        }
//        for(Element el: elemss) {
//        	System.out.println("for22================================="+el.text());
//        }
//        for(Element elem : elems) {
//        	 Elements tdElems = elem.select("td");
//        	 model.addAttribute("about", tdElems);
//        	 System.out.println("for222================================="+tdElems.text());
//        } 
        
//        String[] str = elems.text().split(" ");
//        Elements elem2=doc.select("div.content div p.ta_r.mgt36");
//        
//        
//        //model.addAttribute("about", elems);
//        model.addAttribute("update", elem2);

		 
        return mav;  
	}
	
	
	 
}