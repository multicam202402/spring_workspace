package com.sds.mall.domain;

import lombok.Data;

@Data
public class Member {
	private int member_idx;
	private String uid;
	private String nickname;
	private String email;
	
	private SnS sns; //DB 릴레이션에서 부모인 SnS 를 참조
}
