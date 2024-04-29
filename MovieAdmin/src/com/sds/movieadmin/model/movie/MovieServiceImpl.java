package com.sds.movieadmin.model.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.movieadmin.domain.Movie;
import com.sds.movieadmin.exception.MovieException;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDAO movieDAO;
	
	//등록업무는 파일저장+db insert가 모두 성공해야, 전체를 성공으로 처리하게됨
	//따라서 이 서비스에서 파일저장은 FileManager에게 일을 전담시키고, db insert은ㄴ 
	//MovieDAO에게 업무를 전담시켜, 예외가 발생할 경우 모두 없엇떤 일로 무효화시켜야 함..
	public void regist(Movie movie) throws MovieException{
		movieDAO.insert(movie);
	}
	
}
