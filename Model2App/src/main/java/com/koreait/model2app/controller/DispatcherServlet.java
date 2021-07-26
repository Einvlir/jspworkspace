package com.koreait.model2app.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹클라이언트의 모든 요청을 받는 유일한 진입점..

//요청을 분석하여 어떤 하위컨트롤러가 요청을 처리할지 결정, 하위 컨트롤러가 업무를 마친 후에는 결과를 클라이언트에게
//응답을 처리... 즉 1,2,5 단계를 처리한다.
public class DispatcherServlet extends HttpServlet{
	//이 객체들은 적어도 분석하기 전에는 메모리에 등록되어 있어야 함..
	Properties props;
	FileReader reader;//properties는 자체적으로 파일에 접근할 수 없으므로 리더가 필요..
	@Override
	public void init(ServletConfig config) throws ServletException {
		props = new Properties();
		try {
			//파일의 경로는 시스템에 의해 정해져야 함.
			ServletContext context = config.getServletContext();
			String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
			reader = new FileReader(realPath);
			props.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//1. 요청을 받는다..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청을 구분하는 코드(uri분석)
		String uri = request.getRequestURI();
		//if문 대신 props파일을 탐색하기
		
	}
	public void destroy() {
		if(reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
