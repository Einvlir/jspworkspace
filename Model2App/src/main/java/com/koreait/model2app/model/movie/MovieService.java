package com.koreait.model2app.model.movie;

//영화에 대한 조언을 판단하는 모델 객체
public class MovieService {
	public String getAdvice(String movie) {
		String msg = null;
		if(movie.equals("미션임파서블")) {
			msg="톰크루즈 역작";
		}else if(movie.equals("크루엘라")) {
			msg="디즈니 명작";
		}else if(movie.equals("어벤져스")) {
			msg="마블";			
		}else if(movie.equals("어바웃타임")) {
			msg="ㅜㅜ";
		}
		
		return msg;
	}
}
