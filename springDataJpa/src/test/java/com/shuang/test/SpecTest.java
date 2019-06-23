package com.shuang.test;

import com.shuang.dao.CustomerDao;
import com.shuang.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testSpeec(){
        /**
         * 匿名内部类
         *      实现specification接口
         *      实现toPredicate方法
         *      需要借助方法中的两个参数（
         *          root：获取需要查询的对象的属性
         *          CriteriaBuilder：构造查询条件，内部封装了很多的查询条件（模糊匹配，精准匹配）
         *      ）
         */
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("name");
                /**
                 * 第一个参数：需要比较的属性
                 * 第二个参数: 当前需要比较的取值
                 */
                Predicate predicate = criteriaBuilder.equal(path, "超级大傻子");
                return predicate;
            }
        };
        Optional<Customer> customer = customerDao.findOne(specification);
        System.out.println(customer.toString());
    }

    @Test
    public void testFindMoreCondition(){
        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Path<Object> industry = root.get("industry");
                Predicate predicate = criteriaBuilder.equal(name, "超级大傻子");
                Predicate predicate1 = criteriaBuilder.equal(industry, "人事");
                //将多个查询条件组合到一起
                Predicate and = criteriaBuilder.and(predicate, predicate1);
                return and;
            }
        };
        List<Customer> all = customerDao.findAll(spec);
        System.out.println(all.toString());
    }

    @Test
    public void testLike(){
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                /**
                 * equal:直接到path对象（属性），然后进行比较
                 * gt,lt,ge,le,like:得到path对象，根据path指定比较的参数类型，在进行比较
                 *      指定参数类型：path.as(类型的字节码对象)
                 */
                Predicate like = criteriaBuilder.like(name.as(String.class), "%大傻子");
                return like;
            }
        };
        List<Customer> all = customerDao.findAll(specification);
        System.out.println(all.toString());
    }

    @Test
    public void testFindSort(){
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Predicate like = criteriaBuilder.like(name.as(String.class), "%大傻子");
                return like;
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        List<Customer> all = customerDao.findAll(specification,sort);
        System.out.println(all);

    }

    /**
     * PageRequest是Pageable接口的实现类
     * 在创建PageRequest的过程中需要创建需要调用构造方法传递两参数
     *      第一个：当前查询的页数，（从0开始）
     *      第二个：每页的查询的条数
     */
    @Test
    public void testFindPage(){
        Specification specification = null;
        Pageable pageable = new PageRequest(0,2);
        Page all = customerDao.findAll(specification, pageable);
        System.out.println(all.getContent());//得到数据集合列表
        System.out.println(all.getTotalElements());//得到总条数
        System.out.println(all.getTotalPages());//得到总页数
    }
}
