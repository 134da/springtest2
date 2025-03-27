package springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest.mapper.UserMapper;
import springtest.pojo.User;
import springtest.service.UserService;

import java.util.List;

@Service("userService2")
public class UserServiceImpl2 implements UserService {

    @Autowired
    UserMapper userMapper;



    @Override
    public void show() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);

        }
    }
}
