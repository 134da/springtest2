package springtest2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springtest2.config.SpringConfig;
import springtest2.dao.UserDao;
import springtest2.service.UserService;

public class ApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContextTest = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService bean = applicationContextTest.getBean(UserService.class);
        bean.show2();
        UserDao bean1 = applicationContextTest.getBean(UserDao.class);
        bean1.show();
    }
}
