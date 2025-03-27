package springtest.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import springtest.dao.UserDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 134da
 */
//@Component(value = "userDao")
@Repository("userDao")
@Scope(value = "singleton")//bean作用范围
@Lazy(value = true)//延迟加载
@Primary
public class UserDaoImpl implements UserDao {



    @Value("${jdbc.driver}")
    private String username;

    @Override
    public void show() {
        System.out.println(username);
    }



    
    
    
    
/*    public UserDaoImpl() {
        System.out.println("UserDao创建");
    }

    @PostConstruct
    public void init(){
        System.out.println("userDao的初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("userDao的销毁方法");
    }
    */
    
    
}
