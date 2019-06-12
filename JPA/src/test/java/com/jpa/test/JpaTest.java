package com.jpa.test;

import com.jpa.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    /**
     * 测试jpa的保存
     *  jpa的操作步骤
     *      加载配置文件创建工厂（实体管理类工厂）对象
     *      通过实体管理类工厂获取实体管理器
     *      获取事务对象，开启事务
     *      完成增删改查操作
     *      提交事务或者是回滚
     *      释放资源
     */
    @Test
    public void testSave(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction ts = manager.getTransaction();
        ts.begin();
        Customer cust = new Customer();
        cust.setCustName("大傻子");
        cust.setCustIndustry("人事");
        manager.persist(cust);
        ts.commit();
        manager.close();
        factory.close();

    }
}
