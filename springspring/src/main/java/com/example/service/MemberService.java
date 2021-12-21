package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MemberVO;
import com.example.mapper.MemberMapper;

// 여기가 서비스 부분이라고 알려주기 위해
// 애노테이션 달고 서비스 임포트 시켜주고
// 트랜젝셔널을 철수 영희
@Service
@Transactional
public class MemberService {
	
	// 인터페이스인 MemberMapper를 사용하기 위해선
	// private로 만들어 줘야한다.
	// 이게 사용하기 위해서 선언을 해주는 거다.
	private MemberMapper memberMapper;

	// 생성자가 필요하기 때문에 Alt + Shift + s 누르고 나서
	// 창이 뜨면 o버튼을 눌러주면 만들어진다.
	// 생성자가 있어야 MemberService에서 MemberMapper에 
	// 사용하겠다고 Spring한테 알려준다 그럼 알아서 다 적용시켜준다.
	public MemberService(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	
	// MemberMapper.java에서 만들걸 가져와서 
	// return값으로 id를 던져준다.
	// 그 이후에 MemberController에서 사용이 가능하다.
	// MemberController가서 이제 사용하자
	public MemberVO getMemberById(String id) {
		return memberMapper.getMemberById(id);
	}
	
	// void로 만든건 따로 리턴값이 필요가 없다.
	// 작성이 끝났으면 MemberController로 이동해서 사용하자!
	public void insertMember(MemberVO memberVO) {
		memberMapper.insertMember(memberVO);
	}
}
