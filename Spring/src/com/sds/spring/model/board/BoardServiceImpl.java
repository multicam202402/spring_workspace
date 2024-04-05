package com.sds.spring.model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.spring.domain.Board;

//서비스 인터페이스 구현체
@Service
public class BoardServiceImpl implements BoardService{
	
	//어노테이션으로 주입을 표시
	@Autowired
	private BoardDAO boardDAO;
	
	
	@Override
	public List selectAll() {
		System.out.println("Service의 selectAll() 호출");
		return boardDAO.selectAll();
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
