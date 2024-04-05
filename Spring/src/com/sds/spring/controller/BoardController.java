package com.sds.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//DefaultAnnotaionHandlerMapping이 , 아래의 클래스를 하위 컨트롤러로 발견하게끔, 어노테이션으로 표시를 해야 한다
@Controller
public class BoardController{
	
	//앞으로드는 게시판과 관련된 요청을 이 하나의 클래스에서 담당하되, 각각의 요청은 
	//메서드로 처리한다.. 
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList() {
		System.out.println("목록요청 받음");
		return null;
	}
	
}
