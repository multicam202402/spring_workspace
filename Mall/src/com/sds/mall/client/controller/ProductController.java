package com.sds.mall.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sds.mall.model.product.TopCategoryService;

//쇼핑몰에서 상품과 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class ProductController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//상품 목록 요청 
	@GetMapping("/product/list")
	public String getList(Model model) {
		
		//product/list.jsp에서도 include가 들어있으므로
		//, topList 라는 키값을 갖는 List를 심어놓지 않으면  nullpointerException 난다
		List topList = topCategoryService.selectAll(); //3단계: 일 시키기
		model.addAttribute("topList", topList);//4단계: 결과저장
		
		return "shop/product/list";
	} 
}





