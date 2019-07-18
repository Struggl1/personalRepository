package com.shuang.dao;

import com.shuang.pojo.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * repository接口的方法名称命名查询
 */
public interface UsresRepositoryByName extends Repository<Users,Integer> {


    /**
     *根据那么进行查询
     * @param name 姓名
     * @return
     * 方法的名称必须要遵循驼峰式命名规则
     * findBy(关键字) + 属性名称（首字母大写）
     */
    List<Users> findByName(String name);

    List<Users> findByNameAndAge(String name,int age);

    List<Users> findByNameLike(String name);
}
