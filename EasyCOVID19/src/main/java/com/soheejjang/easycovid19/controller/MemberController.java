package com.soheejjang.easycovid19.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soheejjang.easycovid19.model.dao.MemberDAO;
import com.soheejjang.easycovid19.model.dto.MemberDTO;

@Controller //현재클래스가 스프링에서 관리하는 컨트롤러라고 등록한 것 
public class MemberController {

	@Inject //객체관리를 직접 안하고 스프링에서 해주게 하는것 
	MemberDAO memberDao;
	 
}
