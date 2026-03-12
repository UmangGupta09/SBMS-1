package in.ashokit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.beans.ATM;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Spring Core Autowiring...");
	  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	  ATM atm=context.getBean(ATM.class);
	  atm.print("Welcome to Ashok IT...");

	}

}
