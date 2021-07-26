package com.koreait.model2app.model.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.koreait.model2app.model.domain.Member;

public interface MemberService {
	public void regist(Member member, HttpServletRequest request);//회원 등록
	public List selectAll();//회원 목록
	public Member select(int member_id);//회원 상세보기
	public int update(Member member);//회원 수정
	public int delete(int member_id);//회원 삭제
}
