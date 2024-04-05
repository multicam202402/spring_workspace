package com.sds.spring.model.board;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.spring.domain.Board;
import com.sds.spring.hibernate.HibernateManager;

//Board 관련  DAO 중, 하이버네이트를 이용한 DAO 클래스 정의
@Repository
public class HibernateBoardDAO implements BoardDAO {
	
	@Autowired
	private HibernateManager manager;
	
	@Override
	public List selectAll() {
		System.out.println("DAO의 selectAll() 호출");
		//하이버네이트의 세션 을 얻어와서 쿼리실행 
		Session session = manager.getSession();
		Query<Board> query=session.createQuery("FROM Board", Board.class); //모든 레코드 가져와서 DTO 자동으로 매핑
		
		List list = query.list(); //java.util의 List로 옮기자
		manager.release(session); //세션 돌려보내기
		
		return list;
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