package com.sds.mall.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sds.mall.domain.Product;
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
	public String regist(Product product, String[] color_name, String[] size_name) {
		System.out.println("하위 카테고리 "+product.getSubCategory().getSubcategory_idx());
		System.out.println("상품명 "+product.getProduct_name());
		System.out.println("브랜드 "+product.getBrand());
		System.out.println("가격 "+product.getPrice());
		System.out.println("상세설명 "+product.getDetail());
		
		System.out.println("색상 수는 "+color_name.length);
		System.out.println("사이즈 수는 "+size_name.length);
		
		//Product 안에 들어있는 photo 를 꺼내어, 파일명 출력해보기!
		MultipartFile photo = product.getPhoto();
		String filename = photo.getOriginalFilename();//업로드 된 파일명
		
		System.out.println("파일명은 "+filename);
		
		//서버의 디렉토리 중 하나를 정해서, 그 안에 업로드된 정보를 파일로 저장시키자(현재까지는 메모리상의 정보일 뿐이다..)
		try {
			photo.transferTo(new File("D:/spring_workspace/Mall/WebContent/resources/product_img/"+filename)); //지정된 경로와 원하는 파일명으로 저장
			System.out.println("업로드 성공");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}










