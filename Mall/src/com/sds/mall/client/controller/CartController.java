package com.sds.mall.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sds.mall.domain.Cart;

//장바구니와 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class CartController {
	
	//장바구니 등록 요청 
	@PostMapping("/order/cart/regist")
	@ResponseBody //순수 데이터를 반환하는것이며, jsp로 resolve  하지 않아야 한다
	public ResponseEntity regist(Cart cart) {
		
		//Http프로토콜에 맞게 응답 정보를 구성해주는 객체 (머리, 몸체, 상태코드 등을 구성할 수 있게 해준다)
		//따라서 그냥 성의없게 ok 문자열 등을 단순히 보내는 것보다 훨씬 체계적이다..따라서 클라이언트가 서버의 상황을 정확히 알 수 있다
		ResponseEntity entity = ResponseEntity.status(HttpStatus.OK).build();
		
		return entity;
	}
	
}





