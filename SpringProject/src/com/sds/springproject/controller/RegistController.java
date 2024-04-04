package com.sds.springproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sds.springproject.domain.Member;
import com.sds.springproject.model.member.MemberDAO;

//회원등록 요청을 처리하는 하위 컨트롤러 (3단계,4단계(선택) 수행함 )
public class RegistController implements Controller{
	
	private MemberDAO memberDAO; //mybatisDAO 올지  hibernateDAO 올지 개발시 선택사항..
	
	//DI로 주입을 받으려면,  setter메서드를 준비해놓아야 스프링 컨테이너가 넣어준다
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		 
		int result = memberDAO.insert(member);//3단계: 알맞는 모델 객체에 일 시킨다
		
		ModelAndView mav = new ModelAndView();
		
		if(result>0) {
			//회원 목록 보여주자 ( 요청을 끊고 redirect)
			mav.setViewName("redirect:/member/list");
		}else {
			//에러 페이지 보여주기 (에러내용을 가져가야 하므로 포워딩)
			mav.addObject("msg", "회원가입 실패");
			mav.setViewName("member/error");
		}
		return mav;
	}
}










