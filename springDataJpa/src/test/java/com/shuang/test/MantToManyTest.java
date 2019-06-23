package com.shuang.test;

import com.shuang.dao.RoleDao;
import com.shuang.dao.UserDao;
import com.shuang.domain.Role;
import com.shuang.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class MantToManyTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd(){
        User user = new User();
        user.setName("张三");

        Role role = new Role();
        role.setName("程序员");

        user.getRoles().add(role);
        role.getUsers().add(user);
        userDao.save(user);
        roleDao.save(role);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascade(){
        User user = new User();
        user.setName("李四");

        Role role = new Role();
        role.setName("java");

        user.getRoles().add(role);
        userDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCscadeRemove(){
        userDao.deleteById(2l);
    }
}
