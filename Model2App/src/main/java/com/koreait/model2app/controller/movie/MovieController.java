package com.koreait.model2app.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.movie.MovieService;

//3단계 알맞는 객체에 일 시키기, 4단계 결과 저장..
public class MovieController implements Controller{
	MovieService service;
	
	public MovieController() {
		service = new MovieService();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String movie = request.getParameter("movie");
		String msg = service.getAdvice(movie);
		
		request.setAttribute("msg", msg);
		
	}

	public String getViewName() {
		return "/movie/result";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}

}
