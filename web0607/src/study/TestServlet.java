package study;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
public class TestServlet extends HttpServlet {
	public void init(){
		System.out.println("ㅎㅎ");
	}
	//요청에 대한 응답처리..

	//node.js와 마찬가지로 클라이언트의 요청을 처리하려면 어떤 요청정보를 가지고
	//클라이언트가 요청했는지에 대한 정보를 가진, 요청객체를 이용해야 한다
	//참고로 리퀘스트 객체는 요청이 들어올 때 자동 생성되어 내용이 서버에 의해
	//채워지므로 개발자는 그저 사용만 하면 된다.
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();//문자기반 출력스트림
		out.print("this is my second Sevlet!!");
	}

}