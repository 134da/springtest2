package springtest2.dao.impl;

import org.springframework.stereotype.Repository;
import springtest2.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void show() {
        System.out.println("UserDao的show方法执行");
    }
}
