package com.sds.mall.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_idx;
	private String product_name;
	private String brand;
	private int price;
	private String filename;
	private String detail;
	
	private MultipartFile photo; //html 에서의 <input type="file"> 컴포넌트와 이름이 일치할경우 이 객체로 바이너리
												//를 포함한 정보들이 들어온다. 즉 업로드 정보가 들어온다..
	
	//부모를 참조 
	private SubCategory subCategory;
}
