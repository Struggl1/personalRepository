package com.shuang.test;

import com.shuang.dao.CustomerDao;
import com.shuang.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 查询数量
     */
    @Test
    public void testCount(){
        long count = customerDao.count();
        System.out.println(count);
    }

    /**
     * 根据ID查询是否存在
     */
    @Test
    public void testExists(){
        boolean b = customerDao.existsById(1l);
        System.out.println(b);
    }

    /**
     * Transactional保证getone的正常执行
     * findobe:em.find()        立即加载
     * getone：em.getReference   延迟加载
     *  返回的是冬天代理对象，什么时候用，什么时候查询
     */
    @Test
    @Transactional
    public void testGetone(){
        Customer one = customerDao.getOne(1l);
        System.out.println(one);
    }
}
