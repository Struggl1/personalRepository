springDataJpa的入门操作
    搭建环境
        创建工程导入坐标
        配置spring的配置文件（配置springDataJPA的整合）
        编写实体类，使用jpa注解配置映射关系
    编写一个符合springDataJPA的dao接口
        只需要编写dao接口，不需要编写dao接口的实现类
        dao接口规范
            需要继承两个接口（JpaRepository,JpaSpecificationExcutor）
            提供相应的泛型
springdataJpa的运行过程和原理剖析
    通过JdkDynamicAopProxy的invoke方法创建了动态代理对象  
    SimpleJpaRepository当中封装了JPA操作（借助JPA的api完成数据库的CRUD）
    通过hibernate完成数据库的操作（封装了jdbc）

复杂查询
    jpql查询方式
        特点：语法或者是关键字和sql语句类似
            查询的是类或者是属性
        需要将jpql语句配置到接口方法上
            特有的查询：需要在dao接口上配置方法
                    在新添加的方法上，使用注解的方式配置jpql查询语句
                    注解：@Query        
    sql语句查询
        特有的查询：需要在dao接口上配置方法
                在新添加的方法上，使用注解的方式配置jpql查询语句
                注解：@Query
                    value ：jpql |sql
                    nativeQuery:false(使用jpql进行查询)默认 |true 使用sql进行查询
    方法规则名称查询：
        是对jpql查询更加深入的一层封装，只需要按照SpringDataJpa提供的方法名称规则定义方法，不要去配置jpql查询语句，完成查询            
            
                
        
    