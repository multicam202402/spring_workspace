package com.sds.mall.client.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sds.mall.domain.Cart;
import com.sds.mall.domain.Member;
import com.sds.mall.exception.CartException;
import com.sds.mall.model.order.CartService;

//장바구니와 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	//장바구니 등록 요청 
	@PostMapping("/order/cart/regist")
	@ResponseBody //순수 데이터를 반환하는것이며, jsp로 resolve  하지 않아야 한다
	public ResponseEntity regist(Cart cart, HttpSession session) {
		System.out.println(cart.getProduct().getProduct_idx());//어떤 상품을 
		System.out.println(cart.getEa());//몇개나
		
		//MemberController 에서 member 라는 이름으로 넣었으므로, 꺼내자..
		Member member = (Member)session.getAttribute("member"); 
		cart.setMember(member);
		System.out.println(cart.getMember().getMember_idx());//누가 
		
		//3단계: 일 시키기 
		cartService.regist(cart);
		
		//Http프로토콜에 맞게 응답 정보를 구성해주는 객체 (머리, 몸체, 상태코드 등을 구성할 수 있게 해준다)
		//따라서 그냥 성의없게 ok 문자열 등을 단순히 보내는 것보다 훨씬 체계적이다..따라서 클라이언트가 서버의 상황을 정확히 알 수 있다
		ResponseEntity entity = ResponseEntity.status(HttpStatus.OK).build();
		
		return entity;
	}
	
	//장바구니 목록 요청 
	@GetMapping("/order/cart/list")
	public String getList(HttpSession session, Model model) {
		Member member = (Member)session.getAttribute("member");
		
		//3단계: 일 시키기
		List cartList = cartService.selectByMember(member);
		
		model.addAttribute("cartList", cartList);//4단계: 결과 저장
		
		return "shop/order/cart";
	}
	
	//장바구니 관련 에러처리 
	@ExceptionHandler(CartException.class)
	public ResponseEntity handle() {
		ResponseEntity entity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return entity;
	}	
}











