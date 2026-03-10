package in.ashokit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.beans.UserService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService user=context.getBean( UserService.class);
		user.registerUser("ashok", "ashok123");

	}

}
