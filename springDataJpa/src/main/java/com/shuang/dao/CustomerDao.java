package com.shuang.dao;

import com.shuang.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository<操作的实体类类型,实体的主键类型>,
 * 封装了基本的CRUD操作
 * JpaSpecificationExecutor<Customer>
 *     封装了复杂查询操作
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
}
