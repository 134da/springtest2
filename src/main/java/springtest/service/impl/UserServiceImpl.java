package springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springtest.dao.UserDao;
import springtest.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    // @Autowired//根据类型注入  如果同一类型有多个  根据名字进行二次匹配 还是不成功再报错
    // @Qualifier("userDao2")//搭配Qualifier 可以指定名字匹配
    // @Resource(name = "userDao2") //先找有没有名称 再找有没有类型

/*    @Autowired
    private UserDao userDao;*/

    @Override
    public void show() {
        //System.out.println(userDao);
    }


/*    @Autowired
    public void xxx1231(UserDao userDao2){
        System.out.println(userDao2);
    }*/

/*    @Autowired
    public void yyy(List<UserDao> userDaoList){
        System.out.println(userDaoList);
    }
*/
}
