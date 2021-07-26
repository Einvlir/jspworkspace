package test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//jsp없이도 웹 서버측의 기술을 구현할 수 있고, 아래와 같이
//서버에서 해석 및 실행되는 클래스를 가리켜 서블릿이라 한다..
//javaEE 기술로 개발..

//서블릿은 생명주기 메서드라 불리는 주요 메서드가 존재한다.. 이 생명주기 메서드는
//하나의 서블릿 객체가 태어나서 일하며, 소멸하는 과정과 관련한 주요 메서드임.

public class MyServlet extends HttpServlet{
	//서블릿 인스턴스가 태어난 후 서블릿의 초기화 작업 시 호출되는 메서드
	public void init(){
		System.out.println("초기화");
	}	
	//초기화를 완료한 서블릿이 웹 클라이언트의 요청을 처리할 때 동작
	public void service(HttpServletRequest request, HttpServletResponse response){
		System.out.println("요청 처리");
		//응답처리
		try{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("히히 hehe");
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}
	//서블릿이 소멸될 때 호출
	public void destroy(){
		System.out.println("모두 안녕");
	}
}