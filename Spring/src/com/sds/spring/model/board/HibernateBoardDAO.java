package com.sds.spring.model.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sds.spring.domain.Board;

//Board 관련  DAO 중, 하이버네이트를 이용한 DAO 클래스 정의
@Repository
public class HibernateBoardDAO implements BoardDAO {

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board select(int board_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
	}
	
}
