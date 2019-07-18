package com.shuang.dao;

import com.shuang.pojo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface RolesRepository extends JpaSpecificationExecutor<Roles>, JpaRepository<Roles,Integer> {
}
