package springtest.mapper;


import springtest.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
