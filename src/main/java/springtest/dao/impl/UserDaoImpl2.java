package springtest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import springtest.dao.UserDao;

/**
 * @author 134da
 */
//@Component(value = "userDao")
@Repository( "userDao2")
public class UserDaoImpl2 implements UserDao {



    @Override
    public void show() {
        System.out.println("userDao2");
    }

    
    
}
