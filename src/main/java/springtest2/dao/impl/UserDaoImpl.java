package springtest2.dao.impl;

import org.springframework.stereotype.Repository;
import springtest2.anno.aopLog.MyAopLog;
import springtest2.dao.UserDao;

@Repository("userDao")

public class UserDaoImpl implements UserDao {

    @Override
    @MyAopLog
    public void show() {
        System.out.println("UserDao的show方法执行");
    }

    @Override
    public void show1() {
        System.out.println("UserDao的show1方法");
    }


}
