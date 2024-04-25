package com.sds.movieadmin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAdminController {
	
	//관리자 가입 요청 처리 
	@PostMapping("/admin")
	public String regist() {
		
		return null;
	}
	
}
