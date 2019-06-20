package com.shuang.test;

import com.shuang.dao.CustomerDao;
import com.shuang.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindOne(){
        Optional<Customer> customer = customerDao.findById(1l);
        System.out.println(customer);
    }

    /**
     * save方法根据ID进行判断，有ID为更新，没有ID为插入
     */
    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setAddress("不知道");
        customer.setIndustry("123");
        customer.setLevel("vip");
        customer.setPhone("3231412");
        Customer save = customerDao.save(customer);
        System.out.println(save);
    }

    @Test
    public void testUpdate(){
        Customer customer = new Customer();
        customer.setId(2l);
        customer.setAddress("那谁知道");
        Customer save = customerDao.save(customer);
        System.out.println(save);
    }

    @Test
    public void testDelete(){
        customerDao.deleteById(2l);
    }

    @Test
    public void testFindAll(){
        List<Customer> all = customerDao.findAll();
        System.out.println(all.toString());
    }
}
