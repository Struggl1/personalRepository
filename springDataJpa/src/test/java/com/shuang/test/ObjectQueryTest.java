package com.shuang.test;

import com.shuang.dao.CustomerDao;
import com.shuang.dao.LinkmanDao;
import com.shuang.domain.Customer;
import com.shuang.domain.Linkman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class ObjectQueryTest {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkmanDao linkmanDao;

    /**
     * 对象导航查询
     *   默认使用的是延迟加载的方式进行加载的，
     *      调用get方法的时候不会立即发送sql，而是在使用对象的时候才进行查询
     *      延迟加载
     * 修改配置，将延迟加载改为立即加载
     *  fetch:需要配置在多表映射关系的注解上
     *
     *  从多的一方进行查询，默认的是立即加载
     *  从一方查询多方，默认的是使用延迟加载的方式进行加载
     */
    @Test
    @Transactional//解决java代码中的 no session 问题
    public void testQuery(){
        Optional<Customer> customer = customerDao.findById(1l);
        Set<Linkman> linkmens = customer.get().getLinkmens();
        System.out.println(linkmens.toString());

    }
}
