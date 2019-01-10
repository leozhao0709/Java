package services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServicesTest {

    private UserServices userServices;

    @Before
    public void setUp() throws Exception {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       userServices = (UserServices) context.getBean("userServices");
    }

    @Test
    public void aopTest() {
        userServices.addUser();
        System.out.println("#####################");
    }
}