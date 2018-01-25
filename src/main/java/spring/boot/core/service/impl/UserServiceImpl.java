package spring.boot.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.domain.User;
import spring.boot.core.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * User 业务层实现
 *
 * Created by bysocket on 24/07/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> findAll() {
        List<User> l = new ArrayList<User>();
        User u1 = new User();
        u1.setId(1L);
        u1.setName("冯江");
        u1.setAge(30);
        u1.setBirthday("2018-09-01");

        l.add(u1);
        return l;
    }

    @Override
    public User insertByUser(User user) {
        LOGGER.info("新增用户：" + user.toString());
        return null;
    }

    @Override
    public User update(User user) {
        LOGGER.info("更新用户：" + user.toString());
        return null;
    }

    @Override
    public User delete(Long id) {

        LOGGER.info("删除用户：");
        return null;
    }

    @Override
    public User findById(Long id) {
        LOGGER.info("获取用户 ID ：" + id);
        return null;
    }
}
