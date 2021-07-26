package springBasic.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseStudent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springBasic/aop/aop.xml");
		Student st = (Student)context.getBean("student");
		st.study1();
		st.study2();
		st.study3();
		st.study4();
		st.study5();
		st.study6();
		
		Soldier s = (Soldier)context.getBean("soldier");
		s.getUp();
		s.eat();
		s.work();
		s.eat2();
		s.sleep();
	}
}
