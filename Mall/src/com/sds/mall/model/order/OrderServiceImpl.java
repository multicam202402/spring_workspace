package com.sds.mall.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.mall.domain.Member;
import com.sds.mall.domain.OrderSummary;
import com.sds.mall.exception.OrderException;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ReceiverDAO receiverDAO;
	
	@Autowired
	private PaymethodDAO paymethodDAO;
	
	//주문 DAO
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	@Override
	public List selectReceiver(Member member) {
		return receiverDAO.selectAllByMember(member);
	}

	@Override
	public List selectPaymethod() {
		return paymethodDAO.selectAll();
	}
	
	@Override
	public void order(OrderSummary orderSummary) throws OrderException{
		//주문 요약 넣기 
		orderSummaryDAO.insert(orderSummary);
		
	}
	
}














