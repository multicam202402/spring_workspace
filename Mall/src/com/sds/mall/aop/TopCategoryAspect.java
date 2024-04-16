package com.sds.mall.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.sds.mall.model.product.TopCategoryService;

/*
 * 어플리케이션에서 전반적으로 사용되는 공통 코드가 발견된다면, 일일이 코드로 중복작성하지 말고, 
 * 하나의 관점(Aspect) 으로 정의하여, 개발자가 원하는 시점에 발동시키면 된다..
 * DI는 결합도를 낮추는게 목적임.. 
 * AOP는 결합도를 없애버리는게 목적임..
 * 
 * 아래의 클래스는, 쇼핑몰에서 언제나 보여줘야될 최상위 카테고리 조회를 모든 컨트롤러에서 
 * 중복해서 작성하지 않고, AOP기술을 이용하여, 모든 컨트롤러가 작동하는 시점에, 관여하도록
 * 정의하겠다!!
 * */

public class TopCategoryAspect {
	
	@Autowired
	private TopCategoryService topCategoryService;
		
	//이 메서드는, 대표 컨트롤러가 하위 컨트롤러에게 제어권을 넘길때 관여할 예정
	//즉 하위 컨트롤러가 동작할때 관여시키자 
	//코드 작성 전에 스프링 지원하는 AoP 의존성 jar 가 필요, aspect-weaver 
	public Object getTopCategoryList(ProceedingJoinPoint joinPoint) {
		
		String targetName = joinPoint.getTarget().getClass().getName(); //원래 호출하려던 객체
		System.out.println("원래 호출하려면 클래스는 "+targetName);
		
		
		return null;
	}
	
}













