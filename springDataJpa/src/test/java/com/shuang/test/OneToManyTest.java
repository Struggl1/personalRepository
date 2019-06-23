package com.shuang.test;

import com.shuang.dao.CustomerDao;
import com.shuang.dao.LinkmanDao;
import com.shuang.domain.Customer;
import com.shuang.domain.Linkman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkmanDao linkmanDao;

    @Test
    @Transactional//配置事务
    @Rollback(value = false)//设置不自动回滚
    public void testAdd(){
        Customer customer = new Customer();
        customer.setName("百度");

        Linkman linkman = new Linkman();
        linkman.setName("张三");

        /*
         * 配置了客户和联系人之间的关系
         *      从客户的角度上，发送两条sql语句，一条用来更新数据库，一条用来更新外键
         *      由于配置了客户到联系人之间的关系，客户可以对外键进行维护
         */
        /*
         * 会有多余的一条update语句，
         *      由于一的一方可以维护外键，会发送update语句。
         *      解决此问题，只需要在一的一方放弃维护权即可
         */
        customer.getLinkmens().add(linkman);
        linkman.setCustomer(customer);

        customerDao.save(customer);
        linkmanDao.save(linkman);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeAdd(){
        Customer customer = new Customer();
        customer.setName("zhangsan");

        Linkman linkman = new Linkman();
        linkman.setName("lisi");

        customer.getLinkmens().add(linkman);
        linkman.setCustomer(customer);

        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeDel(){
        Optional<Customer> customer = customerDao.findById(1l);
        customerDao.delete(customer.get());

    }
}
