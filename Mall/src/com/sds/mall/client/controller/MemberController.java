package com.sds.mall.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//회원과 관련된 요청을 전담하는 하위 컨트롤러 
@Controller
public class MemberController {
	
	//로그인 폼 요청 처리 
	@GetMapping("/member/loginform")
	public ModelAndView getLoginForm() {
		ModelAndView mav = new ModelAndView("shop/member/login");
		
		return mav;
	}
	
	//회원가입 폼 요청 처리 
	@GetMapping("/member/registform")
	public ModelAndView getRegistForm() {
		ModelAndView mav = new ModelAndView("shop/member/regist");
		
		return mav;
	}
	
}
