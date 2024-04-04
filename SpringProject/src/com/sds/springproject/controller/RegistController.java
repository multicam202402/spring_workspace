package com.sds.springproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sds.springproject.domain.Bio;
import com.sds.springproject.domain.Member;
import com.sds.springproject.model.bio.BioDAO;
import com.sds.springproject.model.member.MemberDAO;
import com.sds.springproject.mybatis.MybatisManager;

//회원등록 요청을 처리하는 하위 컨트롤러 (3단계,4단계(선택) 수행함 )
public class RegistController implements Controller{
	//아래의 두개의 DAO는 같은 트랜잭션으로 묶어야 하므로, DAO간 서로 SqlSession 공유되어야 한다
	//따라서 SqlSession 의 취득은 현재 하위 컨트롤러가 취득하여, 같은 SqlSession을 DAO들의 
	//insert() 메서드의 매개변수로 나누어주자! , SqlSession을 모아놓은 객체인 .SqlSessionFactory를
	//가진 객체는 MybatisManager이므로, 이 하위 컨트롤러가 MybatisManager를 보유하도록 하자
	private MybatisManager manager;
	
	public void setManager(MybatisManager manager) {
		this.manager = manager;
	}
	
	
	private MemberDAO memberDAO; //mybatisDAO 올지  hibernateDAO 올지 개발시 선택사항..
	private BioDAO bioDAO;

	//DI로 주입을 받으려면,  setter메서드를 준비해놓아야 스프링 컨테이너가 넣어준다
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void setBioDAO(BioDAO bioDAO) {
		this.bioDAO = bioDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		
		//DAO들에게 일 시키기 전에, SqlSession을 취득하여 분배해주자 
		SqlSession sqlSession = manager.getSqlSession();
		
		System.out.println("회원 테이블에 insert 한 이전 "+member.getMember_idx());
		int result = memberDAO.insert(sqlSession, member);//3단계: 알맞는 모델 객체에 일 시킨다
		
		//Member 테이블에 insert  후 곧바로, 이  insert 의해 생성된  member_idx 를 가져와야 한다..
		//그래야 Bio 테이블에 fk에 값을 넣을 수 있다..
		System.out.println("회원 테이블에 insert 한 직후 "+member.getMember_idx());
		
		
		ModelAndView mav = new ModelAndView();
		
		if(result>0) {
			//Member 신상정보가 등록되면, 바이오 정보도 넣어주자
			//Bio bio = new Bio(); //empty 상태 생성
			//bio.setHeight(Float.parseFloat(request.getParameter("height")));//회원의 신장  값
			 
			
			//bioDAO.insert(bio);
			
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










