package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@GetMapping("/login")
	public String loginFrom() {
		System.out.println("loginFrom() 호출완료...");
		return "member/login";
	} //loginFrom
	
	@GetMapping("/join")
	public String joinFrom() {
		System.out.println("joinFrom() 호출완료...");
		return "member/join";
	} //joinFrom
	
	// 기능구현을 하기 위해서 PostMapping을 사용함.
	// 괄호안에 "/login"쓰는 이유는 login페이지의 기능을 구현하기 위함.
	// ResponseEntity<String>를 쓰는 이유는 아이디를 입력 안했다거나
	// 비밀번호를 틀렸다거나 할때 체크해주기 위해서 사용함.
	@PostMapping("/login")
	public ResponseEntity<String> login(String id, String passwd,
			boolean rememberMe) {// 로그인 페이지에 사용하는 name="id / passwd / rememberMe"를 가져와서 사용
		/* 불러오는게 제대로 작동하는지 확인 하기 위해서 출력문을 통해 작성 해보기
		 System.out.println("id : " + id);
		 System.out.println("passwd : " + passwd);
		 System.out.println("rememberMe : " + rememberMe);
		 */
		
		// 1.id 존재여부 체크
		
		// 2.비밀번호 체크
		
		// 3.로그인 유지 체크
		
		// 4.세션등록

		return null;
	} //login
}
