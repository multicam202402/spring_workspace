package com.sds.mall.model.member;

import java.util.List;

import com.sds.mall.domain.Member;

public interface MemberService {
	public void regist(Member member); //가입 트랜잭션 상황
	public List selectAll(); //회원목록
	public List selectAllBySnsIdx(int sns_idx); //1~4
	public Member select(int member_idx);//회원정보 1건 가져오기
	public void edit(Member member); //회원정보 수정 , 두개의 테이블에 걸친 수정일경우 트랜잭션 상황
	public void remove(Member member); //회원 삭제	 , 트랜잭션 상황 
}