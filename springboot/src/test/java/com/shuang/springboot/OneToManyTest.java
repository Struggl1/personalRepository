package com.shuang.springboot;

import com.shuang.SpringbootApplication;
import com.shuang.dao.UsersRepository;
import com.shuang.pojo.Roles;
import com.shuang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class OneToManyTest {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testSave(){
        Users users = new Users();
        users.setName("王五");
        users.setAge(25);
        users.setPassword("23154");

        Roles roles = new Roles();
        roles.setRoleName("管理员");
        users.setRoles(roles);

        roles.getUsers().add(users);

        usersRepository.save(users);
    }

    @Test
    public void testFindOneToMany(){
        Optional<Users> users = usersRepository.findById(4);
        System.out.println(users.get().getRoles().getRoleName());
    }
}
