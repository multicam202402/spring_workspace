package com.sds.mall.model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sds.mall.domain.Member;
import com.sds.mall.exception.MemberException;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberDetailDAO memberDetailDAO;
	
	//두개의 DAO들에게 일을 시키고, 만일 단 하나라도 RuntimeException이 전달되어 온다면, 트랜잭션을 rollback 처리를
	//스프링이 자동으로 처리
	@Transactional(propagation = Propagation.REQUIRED)
	public void regist(Member member) throws MemberException {
		memberDAO.insert(member);//회원 테이블에 먼저 insert  후,  pk를 자동으로  member DTO에 채워넣음
		
		memberDetailDAO.insert(member.getMemberDetail());
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAllBySnsIdx(int sns_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select(int member_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Member member) {
		// TODO Auto-generated method stub
		
	}
	
}
