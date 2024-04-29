package com.sds.movieadmin.model.movie;

import com.sds.movieadmin.domain.Movie;

public interface MovieService {
	public void regist(Movie movie);//1건 등록
	public void registExcel(Movie movie);//일괄등록
	
}
