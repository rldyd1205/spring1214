package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@GetMapping("/login")
	public String loginFrom() {
		System.out.println("loginFrom() 호출완료...");
		return "member/login";
	} //loginFrom
	
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
		
		// 5.로그인 성공 메세지 띄우고, 메인화면으로 이동

		return null;
	} //login
	
	@GetMapping("/join")
	public String joinFrom() {
		System.out.println("joinFrom() 호출완료...");
		return "member/join";
	} //joinFrom
	
	@PostMapping("join")
	public ResponseEntity<String> join(MemberVO memberVO) { 
		// 사용자 입력값을 받아와야 하는데 그 내용이 MemberVO에 들어가 있으니까 
		// 그 각각의 내용들을 모아서 가져올 수 있게 도와줌
		// ex) id, passwd ... 제대로 가져왔는지 확인 하기 위해선 출력해보면 된다
		System.out.println("MemberVO : " + memberVO);
		
		// 1.아이디 중복체크(DB에 있는지 확인)
		// memberVO안에 들어있는 id를 getId로 가지고 옴
		// DB안에 들어있는 id를 가지고 와서 id에다가 대입
		// DB에 있는지 확인 하기 위해서 MemberMapper.java에 가서 작성
		String id = memberVO.getId();
		
		// 2.비밀번호, 비밀번호 확인 서로 같은지 체크
		
		// 3.DB에 등록
		
		// 4.회원가입완료 메세지 띄우고, 로그인 화면으로 이동
		return null;
	} //join
}
