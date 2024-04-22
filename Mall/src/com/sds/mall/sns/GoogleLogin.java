package com.sds.mall.sns;

import lombok.Data;

//구글 로그인 인증 요청시 가져가야할 수많은 파라미터를 이 객체에 담아서 처리할 예정(관리의 편의성)
@Data
public class GoogleLogin {
	
	//웹사이트 이용자가 보게될 동의화면 주소  (구글에서 제공함), 변수명은 개발자가 정하자
	private String endpoint;
	
	//구글 개발자콘솔에서의 앱id
	private String client_id;
	
	//구글 개발자콘솔에서의 앱 비번
	private String client_secret;
	
	//구글로부터 콜백받을 url 
	private String redirect_uri;
	
	//구글로부터 전달받을 파라미터명
	private String response_type;
	
	//사용자로부터 수집하고싶은, 데이터 범위
	private String scope;
}











