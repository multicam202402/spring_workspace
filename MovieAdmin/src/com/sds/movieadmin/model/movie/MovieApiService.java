package com.sds.movieadmin.model.movie;

import java.lang.reflect.Type;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sds.movieadmin.domain.Movie;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;

//api 호출하여 각종 정보를 가져오는 전담 서비스 (영화, 나라정보, 유형, 영화조회..)
@Service
public class MovieApiService {

	@Autowired
	private KobisOpenAPIRestService kobisOpenAPIRestService;	
	
	/*---------------------------------------------------------
	영화목록 조회
	---------------------------------------------------------*/
	public List getMovieList(Movie movie) {
	    String movieCdResponse=null;	
	    List<Movie> movieList=null;
	    
		try {
		    movieCdResponse = kobisOpenAPIRestService.getMovieList(true, movie.getCurPage(), movie.getItemPerPage(), movie.getMovieNm()
		    		, movie.getDirectorNm(), movie.getOpenStartDt(), movie.getOpenEndDt(), movie.getPrdtStartYear()
		    		, movie.getPrdtEndYear(), movie.getRepNationCd(), movie.getMovieTypeCdArr());
		    
		    System.out.println(movieCdResponse);
		    
		    //json 문자열을 자바 객체로 변환 
		    JSONParser parser = new JSONParser();
		    JSONObject json =(JSONObject)parser.parse(movieCdResponse); //가장 바깥쪽 JSON 반환
		    json = (JSONObject)json.get("movieListResult");//그 다음 안쪽 JSON 반환
		    JSONArray array = (JSONArray)json.get("movieList"); //영화 배열 반환
		    System.out.println("영화 목록의 수는 "+array.size());
		    
		    //JSON simple은 파싱할때는 편하다..하지만, 파싱 결과를 자바의 List 등 컬렉션으로 바꾸는 작업은 GSON이 능하다
		    // json 를 자바로, 자바를 json으로 변환할때 능하다 
		    Gson gson=new Gson();
		    Type movieArray   = new TypeToken<List<Movie>>() {}.getType();
		    movieList = gson.fromJson(array.toJSONString(), movieArray);
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movieList;
	}
	
	/*---------------------------------------------------------
	국가정보
	---------------------------------------------------------*/
	public List getNationList() {
		
		return null;
	}
	
	/*---------------------------------------------------------
	영화유형
	---------------------------------------------------------*/
	public List getTypeList() {
		return null;
	}
	
	/*---------------------------------------------------------
	영화 1건 조회
	---------------------------------------------------------*/
	public Movie getMovie() {
		return null;
	}
}