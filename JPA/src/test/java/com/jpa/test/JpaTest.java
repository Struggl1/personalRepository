package com.jpa.test;

import com.jpa.domain.Customer;
import com.jpa.utils.JpaUtils;
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
        cust.setName("大傻子");
        cust.setIndustry("人事");
        manager.persist(cust);
        ts.commit();
        manager.close();
        factory.close();

    }

    /**
     * getReference方法：（延迟加载/懒加载）
     *      1，获取的对象是一个动态代理对象
     *      2，调用getReference方法不会立即发送sql语句查询数据库
     *          当调用查询结果对象的时候，才会发送查询的sql语句，什么时候用什么时候发送sql语句查询数据库
     * find方法：立即加载
     *      1，查询的对象就是当前客户对象本身
     *      2，在调用find方法的时候，就会发送sql语句查询数据库
     *一般使用延迟加载的形式
     */
    @Test
    public void testFind(){
        EntityManager entityManger = JpaUtils.getEntityManger();
        EntityTransaction transaction = entityManger.getTransaction();
        transaction.begin();
        Customer customer = entityManger.find(Customer.class, 1l);
        System.out.println(customer);
        transaction.commit();
        entityManger.close();
    }


    @Test
    public void testRemove(){
        EntityManager entityManger = JpaUtils.getEntityManger();
        EntityTransaction transaction = entityManger.getTransaction();
        transaction.begin();
        Customer reference = entityManger.getReference(Customer.class, 1l);
        entityManger.remove(reference);
        transaction.commit();
        entityManger.close();
    }

    @Test
    public void testUpdate(){
        EntityManager entityManger = JpaUtils.getEntityManger();
        EntityTransaction transaction = entityManger.getTransaction();
        transaction.begin();
        Customer reference = entityManger.getReference(Customer.class, 2l);
        reference.setName("大笨蛋");
        entityManger.merge(reference);
        transaction.commit();
        entityManger.close();

    }

}
