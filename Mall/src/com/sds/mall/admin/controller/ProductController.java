package com.sds.mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sds.mall.model.product.TopCategoryService;

//관리자모드에서의 상품 관련 요청 처리 하위 컨트롤러
@Controller
public class ProductController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//상품 등록폼 요청 처리 
	@GetMapping("/admin/product/registform") 
	public String getRegistForm(Model model) {
		//3단계: 모델에 일 시키기 
		List topList = topCategoryService.selectAll();
		
		//4단계: 가져갈 것이 있을 경우 결과 저장
		model.addAttribute("topList", topList);
		
		return "admin/product/regist";
	}
	
	//상품 업로드 요청 처리 (파일이 포함되어 있다)
	@PostMapping("/admin/product/regist")  // <mvc annotaion driven/> 등록 하면 이러한 속성도 지원함..
	public String regist() {
		
		return null;
	}
	
}










