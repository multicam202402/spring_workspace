package com.sds.mall.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sds.mall.domain.Member;

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
	
	//회원가입 요청 처리 
	@PostMapping("/member/regist")
	@ResponseBody //이 어노테이션을 명시하면, 아래의 return 에 의한 문자열은 ViewResolver에 의해 jsp로 조합되지 않고 순수 데이터로 전송이 된다..
	public String regist(Member member) {
		//스프링은 클라이언트의 파라미터명과 서버측의 DTO의 멤버변수 명이 일치할 경우 자동 매핑을 처리
		System.out.println("uid = "+member.getUid());
		System.out.println("pass = "+member.getMemberDetail().getPassword());
		System.out.println("nickname = "+member.getNickname());
		System.out.println("email = "+member.getEmail());
		System.out.println("phone = "+member.getMemberDetail().getPhone());
		System.out.println("addr = "+member.getMemberDetail().getAddr());
		//클라이언트가 비동기방식으로 요청을 햇으므로, 응답 데이터는 jsp가 아니다 
		
		return "ok"; //ViewResolver에 의해 jsp로 해석하지마!!
	}
}









