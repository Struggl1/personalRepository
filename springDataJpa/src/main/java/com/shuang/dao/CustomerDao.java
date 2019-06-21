package com.shuang.dao;

import com.shuang.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import javax.validation.constraints.Max;
import java.util.List;

/**
 * JpaRepository<操作的实体类类型,实体的主键类型>,
 * 封装了基本的CRUD操作
 * JpaSpecificationExecutor<Customer>
 *     封装了复杂查询操作
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
    @Query(value = "from Customer where name = ?1")
    Customer findJpql(String name);

    /**
     *对于多个占位符，占位符的位置需要和方法中参数的位置保持一致
     * 可以指定占位符参数的位置 ？索引的方式，指定站位的取值来源
     */
    @Query(value = "from Customer where name=?1 and id=?2")
    Customer findBynameAndID(String name,long id);

    /**
     * 使用jpql更新
     * @query:查询操作
     * @Modifying：当前执行的是一个更新操作
     */
    @Query(value = "update Customer set name = ?1 where id = ?2")
    @Modifying
    int updateNameById(String name,long id);

    @Query(value = "select * from customer",nativeQuery = true)
    List<Customer> finalAll();

    @Query(value = "select * from customer where name like ?1 ",nativeQuery = true)
    List<Customer> findByname(String name);

    /**
     * 方法名的约定
     *  findBy:开头
     *      Name(对象中的属性名，首字母大写)
     *      默认情况下使用等于的方式进行查询
     *          特殊的查询方式
     *              findBy + name + like|is null
     *          多条件的查询方式
     *              findBy + name + 查询方式 like|is null + 多条件的连接符 and|or + name +查询方式 like|is null
     */
    Customer findByName(String name);

    Customer findByNameLike(String name);

    Customer findByNameIsNotNull();

    List<Customer> findByNameIsNotNullAndIdIsNull();

}
