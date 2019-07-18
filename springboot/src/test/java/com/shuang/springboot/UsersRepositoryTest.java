package com.shuang.springboot;

import com.shuang.SpringbootApplication;
import com.shuang.dao.UsersRepository;
import com.shuang.dao.UsersRepositoryQueryAnnotation;
import com.shuang.dao.UsresRepositoryByName;
import com.shuang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsresRepositoryByName byName;
    @Autowired
    private UsersRepositoryQueryAnnotation queryAnnotation;
    /*@Autowired
    private UsersRepositoryPagingSort pagingSort;
*/
    @Test
    public void testSave(){
        Users user = new Users();
        user.setName("张三");
        user.setAge(19);
        user.setPassword("123456");
        usersRepository.save(user);
    }

    @Test
    public void testFindByName(){
        List<Users> list = byName.findByName("张三");
        System.out.println(list.toString());
    }

    @Test
    public void testFindBynameAndage(){
        List<Users> users = byName.findByNameAndAge("张三", 19);
        System.out.println(users.toString());
    }

    @Test
    public void testNameLike(){
        List<Users> users = byName.findByNameLike("张%");
        System.out.println(users.toString());
    }

    @Test
    public void testQueryHQL(){
        List<Users> users = queryAnnotation.queryByNameUseHQL("张三");
        System.out.println(users.toString());
    }

    @Test
    public void testQuerySQL(){
        List<Users> users = queryAnnotation.queryByNameUseSQL("张三");
        System.out.println(users.toString());
    }

    @Test
    @Transactional
    @Rollback(false)//自动回滚
    public void testUpdateUserById(){
        queryAnnotation.updateUserById("李四",1);
    }

    /*@Test
    public void testPaging(){
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort = new Sort(order);
        pagingSort.findAll(sort);
    }*/

    @Test
   public void testSpecification(){
       Specification<Users> specification = new Specification<Users>() {
           @Override
           public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               return criteriaBuilder.equal(root.get("name"),"张三");
           }
       };
       List<Users> all = usersRepository.findAll(specification);
       System.out.println(all.toString());
   }

   @Test
   public void testSpecification2(){
        Specification<Users> specification = (Specification<Users>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.equal(root.get("name"),"张三"));
            list.add(criteriaBuilder.equal(root.get("age"),18));
            Predicate[] predicates = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(predicates));
        };
       List<Users> all = usersRepository.findAll(specification);
       System.out.println(all.toString());
   }

   @Test
   public void testSpecification3(){
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(criteriaBuilder.equal(root.get("name"),"张三"),criteriaBuilder.equal(root.get("age"),19));
            }
        };
       Sort sort = new Sort(Sort.Direction.DESC,"id");
       List<Users> all = usersRepository.findAll(specification,sort);
       System.out.println(all.toString());
    }
}
