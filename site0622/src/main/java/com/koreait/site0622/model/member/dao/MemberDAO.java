package com.koreait.site0622.model.member.dao;

import java.util.List;

import com.koreait.site0622.model.domain.Member;

public interface MemberDAO {
	public Member getMemberById(String id);//아이디를 통해 해당 회원이 존재하는지 여부 쳌
	
	//회원 가입
	public int regist(Member member);
	
	//회원 삭제
	public int delete(Member member);
	//회원 목록
	public List selectAll();
	//회원 조회
	public Member select(int member_id);
	//회원 수정
	public int update(Member member);
	
	public Member select(Member member);//id와 pass를 이용한 회원정보 가져오기
}
