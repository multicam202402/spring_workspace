package com.sds.mall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//관리자모드에서의 상품 관련 요청 처리 하위 컨트롤러
@Controller
public class ProductController {
	
	//상품 등록폼 요청 처리 
	@GetMapping("/admin/product/registform") 
	public String getRegistForm() {
		
		return "admin/product/regist";
	}
	
	
}
