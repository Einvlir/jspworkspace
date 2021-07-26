package site0616.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		//이 메서드는 서블릿의 인스턴스가 생성되자 마자 웹 컨테이너인 톰캣에 의해 초기화 되기 위한 용도로 사용된다.
		//또한 init 메서드의 매개변수로 전달되는 ServletConfig 객체는 서블릿의 환경정보를 담고 있다.
		
		//이 Config 객체는 톰캣에 의해 생성되어 서블릿에게 전달되어진다..
		String msg = config.getInitParameter("msg");
		System.out.println(msg);
	
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	//클라이언트의 요청이 Get방식일 경우 동작하는 메서드, 이 메서드는 service 메서드에 의해 호출된다
	//이 때 정의된 요청, 응답 매개변수도 service 메서드의 것을 전달받게 된다. 즉 실제적으로 업무를 처리하는 메서드는 바로
	//do xx 이다..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()메서드에서 요청 처리");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드에서 요청 처리");
	}
	@Override
	public void destroy() {
		System.out.println("잉잉");
	}

}
