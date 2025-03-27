package springtest.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springtest.config.SpringConfig;
import springtest.dao.UserDao;
import springtest.dao.impl.UserDaoImpl;
import springtest.service.UserService;
import springtest.service.impl.UserServiceImpl;

public class ApplicationContextTest {
    public static void main(String[] args) {
        //用注解的方式加载spring核心配置
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object userDao = applicationContext.getBean("userDao");
        System.out.println(userDao+"注解加载");

        Object userService2 = applicationContext.getBean("userService2");

        UserService userService = (UserService) userService2;
        userService.show();







        /*        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
*//*        Object bean = applicationContext.getBean("userService");
        UserService bean1 = (UserService) bean;
        bean1.show();*//*

        Object dataSource = applicationContext.getBean("dataSource");
        System.out.println(dataSource);

        applicationContext.close();*/


    }
}
