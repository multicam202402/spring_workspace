package com.sds.movieadmin.model.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.movieadmin.common.ExcelManager;
import com.sds.movieadmin.common.FileManager;
import com.sds.movieadmin.domain.Movie;
import com.sds.movieadmin.exception.MovieException;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private FileManager fileManager; //root-context.xml에서 이미 메모리에 올려놓음
	
	@Autowired
	private ExcelManager excelManager;//root-context.xml에서 이미 메모리에 올려놓음
	
	//1건 등록
	public void regist(Movie movie) throws MovieException{
		movieDAO.insert(movie);
	}
	
	//등록업무는 파일저장+db insert가 모두 성공해야, 전체를 성공으로 처리하게됨
	//따라서 이 서비스에서 파일저장은 FileManager에게 일을 전담시키고, db insert는 
	//MovieDAO에게 업무를 전담시켜, 예외가 발생할 경우 모두 없엇떤 일로 무효화시켜야 함..
	public void registExcel(Movie movie) {
		
		//1) 파일 서버에 저장 
		String excelPath = fileManager.save(movie); //저장은 이 메서드에서 진행되었으므로, 파일명 또한 알고 있다..따라서 그 파일명을 
		//반환하는 return 값을 메서드에 추가하자
		
		//2) 저장된 엑셀을 읽기 
		excelManager.getMovieData(excelPath);
		
		
	}
	
}
