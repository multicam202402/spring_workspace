package com.sds.movieadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.movieadmin.domain.Movie;
import com.sds.movieadmin.model.movie.MovieApiService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieApiService movieApiService;
	
	//영화진흥위원회 제공 모든 영화 가져오기 
	@GetMapping("/movie/api/list")
	public ModelAndView getApiList(Movie movie) {

		List moveList = movieApiService.getMovieList(movie);//3단계: 일시키기 
		
		return null;
	}
}






