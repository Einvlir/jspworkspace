package springBasic.cook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseChef {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/context.xml");
		
		Chef chef = (Chef)context.getBean("chef");
		chef.cook();
	}
}
