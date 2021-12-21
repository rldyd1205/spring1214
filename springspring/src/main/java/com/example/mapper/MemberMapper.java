package com.example.mapper;

import com.example.domain.MemberVO;

public interface MemberMapper {

	// =========== select ===========
	
	// MemberController에서 회원가입을 하기위해
	// 중복되지 않은 아이디로 회원가입을 하려고 하기 때문에
	// 저장되어 있는 아이디가 있는지 확인
	// 그래서 MemberVO를 사용을 하고 이름은getMemberById로 내가 만들어주고
	// 가져올건 id밖에 없으니까 괄호 안에 String id라고 적어준다
	// 그리고 명세를 해줘야 하는데 이게 어떤 sql문을 사용하는지
	// MemberMapper.xml 파일에서 sql문을 작성을 해줘야 한다.
	// MemberMapper.xml가서 작성하자!
	MemberVO getMemberById(String id);
	
	// =========== insert ===========
	
	// 사용자가 입력한 내용을 바탕으로 회원가입 하기위해서
	// DB에 추가 시키는 메서드 이렇게 쓰고 MemberMapper.xml로 이동!
	void insertMember(MemberVO memberVO);
	
	// =========== update ===========
	
	// =========== delete ===========
}
