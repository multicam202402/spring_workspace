package com.sds.mall.client.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sds.mall.domain.Member;
import com.sds.mall.model.order.OrderService;

//결제와 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class PaymentController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/payment/payform")
	public String getForm(HttpSession session, Model model) {
		
		Member member = (Member)session.getAttribute("member");
		
		//3단계: 받는 사람 정보, 결제방법 가져오기 
		List receiverList		= orderService.selectReceiver(member);
		List paymethodList 	= orderService.selectPaymethod();
		
		//4단계: 저장 
		model.addAttribute("receiverList", receiverList);
		model.addAttribute("paymethodList", paymethodList);
		
		return "shop/order/checkout";
	}
}







