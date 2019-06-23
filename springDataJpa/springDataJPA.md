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
    Specification:查询条件
        自定义specification的实现类
            实现：
                root：查询的根对象（查询的时候任何属性都可以从根对象进行获取）
                CriteriaQuery：顶层查询对象，自定义查询方式
                CriteriaBuilder：查询的构造器，封装了很多的查询条件
                
   一对多关系下：
        删除主表数据：
            有从表数据：他会把外键字段置为null，然后删除主表的数据，如果在数据库的表结构上，外键字段有非空约束，默认情况下就会报错
            如果配置了放弃维护关联关系的权利，则不能删除（与外键字段是否为null没有关系）因为在删除时，他根本不回去更新从表的外键字段了
            如果还想删除，使用级联删除引用
            级联：
                操作一个对象的同时，操作他的关联对象
                级联操作：
                    需要区分操作主体
                    需要在操作主体的实体类上添加级联属性(需要添加到多表映射关系的注解上)
                    cascade(配置级联)
                级联添加，
                    案例：保存客户的同时，保存联系人
                级联删除
                    案例：删除客户的同时，删除所有联系人
        没有从表数据引用，随便删除    
   多对多的操作
        案例：用户和角色
   多表查询
        对象导航查询：查询一个对象的同时，通过此对象查询他的关联对象     
             
                 
                               
            
                
        
    