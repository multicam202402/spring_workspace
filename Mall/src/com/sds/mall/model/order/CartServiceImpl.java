package com.sds.mall.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.mall.domain.Cart;
import com.sds.mall.domain.Member;
import com.sds.mall.exception.CartException;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void regist(Cart cart) throws CartException{
		cartDAO.insert(cart);
	}

	@Override
	public List selectByMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart select(int cart_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}
	
}
