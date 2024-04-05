package com.sds.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sds.spring.model.board.BoardService;

//DefaultAnnotaionHandlerMapping이 , 아래의 클래스를 하위 컨트롤러로 발견하게끔, 어노테이션으로 표시를 해야 한다
@Controller
public class BoardController{
	
	@Autowired
	private BoardService boardService;
	
	//앞으로드는 게시판과 관련된 요청을 이 하나의 클래스에서 담당하되, 각각의 요청은 
	//메서드로 처리한다.. 
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList(Model model) {
		System.out.println("목록요청 받음");
		
		List boardList = boardService.selectAll(); //3단계: 일 시키기
		
		model.addAttribute("boardList", boardList); //4단계: jsp로 가져갈 결과가 있으므로 결과 저장
	
		//View 객체를 따로 만들지 말고, 그냥 String으로 뷰의 이름을 저장하면 자동으로 View 객체에 담김 
		return "board/list";
	}

	//글쓰기 폼 요청 
	@RequestMapping(value="/board/writeform", method=RequestMethod.GET)
	public String getForm() {
		return "board/write";  //요청 유지 jsp
	}
	
}



