package com.oguzkurtcebe.organization.web;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oguzkurtcebe.organization.dao.RoleAndUserRepository;

@Controller
@Transactional
public class HomeController {
public static String url="http://localhost:8080/register/verify";
	@Autowired
	private RoleAndUserRepository roleAndUserRepository;
	

	
	@RequestMapping(value = { "/", "/index.html" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

}
