package com.sds.springapp.aop;


//학생을 정의한다 
public class Student {
	Bell bell=new Bell();
	
	public void gotoSchool() {
		System.out.println("학교에 갑니다");
	}
	
	public void study() {
		System.out.println("수업 시작합니다");
	}
	
	public void haveLunch() {
		System.out.println("점심 먹어요");
	}
	
	public void goHome() {
		System.out.println("귀가 해요");
	}
}


