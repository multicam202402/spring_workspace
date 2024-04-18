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
		//먼저 동일한 상품이 있는지 조회
		//dto는 중복된 상품이 있을때 null이 아니게 됨
		Cart dto = cartDAO.selectDuplicate(cart);
		
		if(dto ==null) {//없다면 insert 
			cartDAO.insert(cart);
		}else {
			//있다면 update, 단 파라미터로 넘어온 갯수와 + 중복된 정보에 들어있는 ea 를 합산한 결과를 update
			cart.setEa(dto.getEa() + cart.getEa());
			cartDAO.update(cart);
		}
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
