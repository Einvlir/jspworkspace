package com.koreait.springmvctest.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//클라이언트의 테스트 요청을 처리하는 하위컨트롤러
@Controller //하위컨트롤러임이 증명됨
public class HelloController {
	@RequestMapping("/test")
	public String babo(Model model) {
		//3단계 알맞은 객체에 일시키기.. 생략!
		System.out.println("메서드호출");
		//4단계..저장
		//저장할 것이 있다면 저장하되 request객체에 저장하는 것이 아니라
		//스프링이 제공해주는 model객체에 넣어 사용한다.
		model.addAttribute("msg","MVC 실험 성공!");
		return "test/result";
	}
}
