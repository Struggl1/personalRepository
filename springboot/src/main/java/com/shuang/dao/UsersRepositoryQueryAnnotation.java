package com.shuang.dao;

import com.shuang.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * repository  @query
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users,Integer> {

    @Query("from Users where name= ?1")
    List<Users> queryByNameUseHQL(String name);
    /**
     *    nativeQuery是否为标准的sql语句
     */
    @Query(value = "select * from t_users where name = ?1",nativeQuery = true)
    List<Users> queryByNameUseSQL(String name);

    @Query("update Users set name = ?1 where id = ?2")
    @Modifying//需要进行更新的操作
    void updateUserById(String name,Integer id);
}
