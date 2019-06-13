package com.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 解决实体管理器工厂浪费资源和耗时的问题
 *      通过静态代码块的方式实现
 */
public class JpaUtils {
    private static EntityManagerFactory managerFactory;

    static {
        managerFactory = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getEntityManger(){
        return managerFactory.createEntityManager();
    }
}
