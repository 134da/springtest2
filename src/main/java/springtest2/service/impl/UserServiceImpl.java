package springtest2.service.impl;

import org.springframework.stereotype.Service;
import springtest2.anno.aopLog.MyAopLog;
import springtest2.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    @MyAopLog
    public void show1() {
        System.out.println("show1");
    }

    @Override
    @MyAopLog
    public void show2() {
        System.out.println("show2");

    }
}
