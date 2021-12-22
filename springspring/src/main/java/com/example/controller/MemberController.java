package com.example.controller;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MemberVO;
import com.example.service.MemberService;
import com.example.util.JScript;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	// Spring에게 MemberController에서 MemberService를
	// 사용하고 싶다고 말해주는 코드이다.
	// private로 서비스 불러오고, 생성자로 연결시킨다.
	// 이렇게 작성을 하고 나면 사용이 가능하다.
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

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
	public ResponseEntity<String> join(MemberVO memberVO,
			String passwdConfirm) { 
		// 사용자 입력값을 받아와야 하는데 그 내용이 MemberVO에 들어가 있으니까 
		// 그 각각의 내용들을 모아서 가져올 수 있게 도와줌
		// ex) id, passwd ... 제대로 가져왔는지 확인 하기 위해선 출력해보면 된다
		System.out.println("MemberVO : " + memberVO);
		
		// 1.아이디 중복체크(DB에 있는지 확인)
		// memberVO안에 들어있는 id를 getId로 가지고 옴
		// DB안에 들어있는 id를 가지고 와서 id에다가 대입
		// DB에 있는지 확인 하기 위해서 MemberMapper.java에 가서 작성
		String id = memberVO.getId();
		
		// 위에서 MemberService 생성자를 만들었으면,
		// 내가 원하는 곳에서 필요한 걸 불러와서 
		// 작성하면 사용할 수 있다.
		// DB에서 검색해서 나온 결과기 때문에 메서드 이름을
		// dbMemberVO라고 정해준다.
		MemberVO dbMemberVO = memberService.getMemberById(id);
		
		// 그럼 DB에 값이 있는지 출력문을 통해 확인이 가능하다
		// 값이 있으면 그 값 내용이 나올 것이고 없으면 null값으로 나온다.
		System.out.println("dbMemberVO : " + dbMemberVO);
		
		// dbMemberVO가 널값이면 값이 없다는 뜻이니까 
		// 새로운 id를 만들 수 있다는 말이니 조건문을 통해 
		// 회원가입을 할수있게 만들어 준다.
		// 만약 아이디가 있을 경우에는 새로운 아이디를 만들 수 없으니
		// 스크립트를 띄우고 다시 회원가입 하는 화면으로 돌아간다.
		if (dbMemberVO != null) {
			// 이 내용은 그냥 복사 붙여넣기 하면된다.
			// 이 내용이 말하는건 스크립트 창을 띄우기 위해서 있다고 
			// 그렇게 이해 하고 넘어가면 된다.
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=UTF-8");
			String str = JScript.back("아이디가 이미 존재합니다.");

			return new ResponseEntity<String>(str, headers, HttpStatus.OK);
		}
		// 2.비밀번호, 비밀번호 확인 서로 같은지 체크
		
		// passwd는 MemberVO안에 들어 있기때문에 따로 안가져와도 되지만,
		String passwd = memberVO.getPasswd(); 
		// passwdConfirm은 없기때문에 join괄호 안에 작성해준다.
		// 그 이후에 조건문을 만들어서 passwd와 passwdConfirm이 
		// 서로 맞는지 확인하고 아니면 스크립트로 틀렸다고 말해주고
		// 다시 작성하게끔 한다. 문자끼리 비교할땐 이퀄스를 사용
		if (passwd.equals(passwdConfirm) == false) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=UTF-8");
			String str = JScript.back("비밀번호가 서로 같지 않습니다.");

			return new ResponseEntity<String>(str, headers, HttpStatus.OK);
		}
		
		// 3.아이디 체크 비밀번호 체크까지 모두 통과 했을 때
		// 출력문을 찍어보면 비밀번호 암호화 안되어 있고,
		// regDate(등록날짜)가 없기때문에 만들어 준다.
		
		// 3-1.회원가입 날짜 설정하기
		memberVO.setRegDate(new Date());
		// 출력문을 통해서 등록날짜가 들어갔는지 확인
		System.out.println("memberVO 수정 전: " + memberVO);
		
		// 3-2.비밀번호 암호화 -> 외부 라이브러리 이기때문에 이렇게 쓰는게 사용방법
		// hashpw안에 있는 passwd는 암호화 되지 않은 비밀번호
		// BCrypt.gensalt()는 얼마나 암호화 시킬건지 정하는거
		// hashPasswd는 암호화가 완료된 비밀번호
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		// memberVO에 암호화된 비밀번호 넣어주기
		memberVO.setPasswd(hashPasswd);
		// 수정이 됬는지 확인
		System.out.println("memberVO 수정 후: " + memberVO);
		
		// 4.DB에 등록 -> MemberMapper.java에가서 작성!
		// MemberService까지 다녀 왔으면 사용가능
		// 추가 하는 내용은 memberVO에 넣어준다.
		memberService.insertMember(memberVO);
		
		// 5.회원가입완료 메세지 띄우고, 로그인 화면으로 이동
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		// 완료되었다는 창 띄워주고, 그뒤에 어디로 이동할지를 적어주면 된다.
		String str = JScript.href("회원가입이 완료되었습니다.", "/member/login");

		return new ResponseEntity<String>(str, headers, HttpStatus.OK);
		
	} //join
}
