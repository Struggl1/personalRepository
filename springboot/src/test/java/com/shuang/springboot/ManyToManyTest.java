package com.shuang.springboot;

import com.shuang.SpringbootApplication;
import com.shuang.dao.RolesRepository;
import com.shuang.pojo.Menu;
import com.shuang.pojo.Roles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class ManyToManyTest {
    @Autowired
    private RolesRepository repository;

    @Test
    public void saveManyToMany(){
        Roles roles = new Roles();
        Menu menu = new Menu();
        Menu menu1 = new Menu();


        roles.setRoleName("菜单");
        menu.setMenuName("川菜");
        menu1.setMenuName("河南菜");

        roles.getMenus().add(menu);
        roles.getMenus().add(menu1);
        menu.getRoles().add(roles);
        menu1.getRoles().add(roles);

        repository.save(roles);
    }

    @Test
    public void testFind(){
        Optional<Roles> roles = repository.findById(4);
        for (Menu menu : roles.get().getMenus()){
            System.out.println(menu.toString());
        }
    }

    @Test
    public void testDel(){
        repository.deleteById(4);
    }
}
