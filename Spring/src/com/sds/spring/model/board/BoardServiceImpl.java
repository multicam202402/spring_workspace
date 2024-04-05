package com.sds.spring.model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sds.spring.domain.Board;

//서비스 인터페이스 구현체
@Service
public class BoardServiceImpl implements BoardService{
	
	//어노테이션으로 주입을 표시
	@Autowired
	@Qualifier("mybatisBoardDAO")
	private BoardDAO boardDAO;
	
	
	@Override
	public List selectAll() {
		System.out.println("Service의 selectAll() 호출");
		return boardDAO.selectAll();
	}

	@Override
	public Board select(int board_idx) {
		return boardDAO.select(board_idx);
	}

	@Override
	public void insert(Board board) {
		boardDAO.insert(board);
	}

	@Override
	public void update(Board board) {
		boardDAO.update(board);
	}

	@Override
	public void delete(Board board) {
		boardDAO.delete(board);
	}

}
