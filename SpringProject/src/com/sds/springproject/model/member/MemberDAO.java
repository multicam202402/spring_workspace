package com.sds.springproject.model.member;

import com.sds.springproject.domain.Member;

//객체간의 결합도를 최대한 낮추기 위해, MemberDAO를 사용하려는 객체들에게 
//최상위 객체를 has a 관계로 보유하도록 하자
public interface MemberDAO {
	public int insert(Member member);
}
