package com.sds.spring.model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.spring.domain.Board;
import com.sds.spring.mybatis.MybatisManager;

//아래의 @Repository 를 명시하면 설정파일의 context:component-scan 에 의해 메모리에 올려질 인스턴스의 대상이 됨  
@Repository
public class MybatisBoardDAO implements BoardDAO{
	
	@Autowired
	private MybatisManager manager;
	
	public List selectAll() {
		List list=null;
		SqlSession sqlSession=manager.getSqlSession();
		list=sqlSession.selectList("Board.selectAll");
		manager.release(sqlSession);
		
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
