package com.shuang.dao;

import com.shuang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 参数一：当前需要映射的实体类
 * 参数二：当前映射实体类中的ID的类型
 */
public interface UsersRepository extends JpaRepository<Users,Integer>, JpaSpecificationExecutor<Users> {

}
