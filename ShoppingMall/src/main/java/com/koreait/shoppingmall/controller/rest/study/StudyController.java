package com.koreait.shoppingmall.controller.rest.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.shoppingmall.domain.Member;

@RestController
public class StudyController {
	@GetMapping("/member")
	public List<Member> getList() {
		
		Member m1 = new Member();
		m1.setMember_id(1);
		m1.setUser_id("scott");
		m1.setPass("0000");
		m1.setName("스콧");
		
		Member m2 = new Member();
		m2.setMember_id(2);
		m2.setUser_id("adams");
		m2.setPass("2222");
		m2.setName("애덤스");
		
		List list = new ArrayList<Member>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	@GetMapping("/member/{member_id}")
	//@PathVariable 을 이용해야 한다..! 그렇지 않으면 변수가 아닌 경로로인식한다..
	public Member getDetail(@PathVariable int member_id) {
		Member m = new Member();
		m.setMember_id(member_id);
		m.setUser_id("king");
		m.setPass("9999");
		m.setName("애덤스");

		return m;
	}
//	//폼 양식으로부터 post처리
//	@PostMapping("/member")
//	public Member regist(Member member) {
//		System.out.println("POst");
//		return member;
//	}
	//폼 양식으로부터 post처리
	/*일반적으로 특별한 처리를 하지 않는 한 VO매핑은 queryString만을 매핑시킴..
	 * 즉 JSON문자열과 매핑은 일어나지 않는다.
	 * 해결책 @RequestBody : 제이슨 문자열을 자바객체와 매핑시켜준다..*/
	@PostMapping("/member")
	public Member regist(@RequestBody Member member) {
		System.out.println(member.getName());
		return member;
	}
	//put처리
	@PutMapping("/member")
	public Member update(@RequestBody Member member) {
		System.out.println("Put");
		member.setName("putter");
		return member;
	}
	//put처리
	@DeleteMapping("/member")
	public Member delete(@RequestBody Member member) {
		System.out.println("del");
		return member;
	}
}
