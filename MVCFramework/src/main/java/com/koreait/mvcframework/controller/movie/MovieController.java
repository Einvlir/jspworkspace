package com.koreait.mvcframework.controller.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.Controller;
import com.koreait.mvcframework.model.movie.MovieService;

//영화에 대한 요청을 처리하는 컨트롤러
public class MovieController implements Controller{
	MovieService service;
	public MovieController() {
		service = new MovieService();
	}
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movie = request.getParameter("movie");
		
		//재사용 가능성이 있는 로직은 컨트롤러에서 개발하지 않는다.
		String msg = service.getAdvice(movie);
		//결과를 request에 이식..
		request.setAttribute("msg", msg);
		
		//디자인은 별도의 jsp로 담당하기로 한다..

	}
	public String getViewName() {
		
		return "/movie/result.jsp";
	}
}
