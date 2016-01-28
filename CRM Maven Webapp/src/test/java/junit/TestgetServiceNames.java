package junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestgetServiceNames {
    
	@Test
	public void testgetServiceNames(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		String[] names=context.getBeanDefinitionNames(); 
		for(String name:names){
			System.out.println(name);
		}
	}
}
