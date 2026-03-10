package in.ashokit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.beans.PetrolEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PetrolEngine peEngine = context.getBean(PetrolEngine.class);
        peEngine.start();
       
    }
}
