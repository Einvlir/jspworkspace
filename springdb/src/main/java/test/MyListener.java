package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//웹 서버가 가동될 때 감지하여 원하는 메시지를 심기..
public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		//서버 가동
		ServletContext servletContext = sce.getServletContext();
		String value = servletContext.getInitParameter("contextConfigLocation");
		servletContext.setAttribute("obj", value);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("종료");
		//서버 종료
	}

	
}
