package com.sds.mall.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.mall.domain.Member;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ReceiverDAO receiverDAO;
	
	@Autowired
	private PaymethodDAO paymethodDAO;
	
	@Override
	public List selectReceiver(Member member) {
		return receiverDAO.selectAllByMember(member);
	}

	@Override
	public List selectPaymethod() {
		return paymethodDAO.selectAll();
	}
	
}
