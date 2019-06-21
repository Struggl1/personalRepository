package com.shuang.test;

import com.shuang.dao.CustomerDao;
import com.shuang.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class JpqlTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testJpql(){
        Customer customer = customerDao.findJpql("大傻子");
        System.out.println(customer);
    }

    @Test
    public void testJpqlNameId(){
        Customer customer = customerDao.findBynameAndID("大傻子", 1l);
        System.out.println(customer);
    }

    /**
     * springDateJpa使用jpql完成更新和删除的操作
     *          需要手动添加事务的支出
     *          默认会在执行结束后，回滚事务
     * @Rollback设置在完成之后是否回滚
     */
    @Test
    @Transactional//添加事务的支持
    @Rollback(value = false)
    public void testJpqlUpdate(){
        int i = customerDao.updateNameById("超级大傻子", 1l);
        System.out.println(i);
    }

    @Test
    public void testFindAll(){
        List<Customer> customers = customerDao.finalAll();
        System.out.println(customers.toString());
    }

    @Test
    public void testFindByname(){
        List<Customer> byname = customerDao.findByname("%大傻子");
        System.out.println(byname.toString());
    }

    @Test
    public void testFindByName(){
        Customer name = customerDao.findByName("超级大傻子");
        System.out.println(name.toString());
    }

    @Test
    public void testFindBynameLike(){
        Customer nameLike = customerDao.findByNameLike("%大傻子");
        System.out.println(nameLike.toString());
    }

    @Test
    public void findAll(){
        Customer byNameIsNotNull = customerDao.findByNameIsNotNull();
        System.out.println(byNameIsNotNull);
    }

    @Test
    public void findAllidandName() {
        List<Customer> byNameIsNotNullAndIdIsNull = customerDao.findByNameIsNotNullAndIdIsNull();
        System.out.println(byNameIsNotNullAndIdIsNull.toString());

    }


}
