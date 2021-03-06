**springboot中表单校验的技术特点**
    1，springboot使用了Hibernate—validate校验框架
    2,springboot表单数据校验步骤
        在实体类中添加校验规则;@NotBlank
        控制器中开启对数据的校验@Valid
    3,其他校验规则：
        @NotBlank:判断字符串是否为null或者是空串（去掉首尾的空格）
        @NotEmpty：判断字符串是否为null或者是空串（不去掉首尾的空格）
        @Length:判断字符串的长度（最大或者是最小）
        @Min（判断数值最小值）
        @Max（判断数值最大值）
        @Email（判断邮箱是否合法）
**springBoot中的异常处理方式**
    1，springBoot中对于异常处理提供了五种处理方式
        自定义错误页面
            springBoot默认的处理异常机制：SpringBoot默认的已经提供了一套处理异常的机制，一旦程序中出现了异常，springBoot会向/error
            的URL发送请求。在springBoot中提供了一个叫做BasicExceptionController的类来处理/error请求，跳转到默认显示异常的页面来显示
            异常信息。
            如果需要将所有的异常同意跳转到自定义的错误页面，需要在src/main/resources/templates目录下创建error.html页面。名称必须是error
        @ExceptionHandler注解处理异常
            返回值对象为ModelandView，方法参数为exception
        @ControllerAdvice + @ExceptionHandler 注解处理异常
            需要创建一个能够处理异常的全局异常类，在该类上面需要添加@ControllerAdvice注解
        配置SimpleMappingExceptionResolver处理异常
            在全局异常类中添加一个方法完成异常的统一处理SimpleMappingExceptionResolver
            相比ControllerAdvice无法进行异常类型的传递
        自定义HandlerExceptionResolver类处理异常
            需要在全局异常处理类中实现HandlerExceptionResolver接口
**springBoot整合Junit做单元测试**            
**springboot热部署分为两种**
    springLoader插件  
        以maven插件的方式使用springLoader
        使用spring-boot:run maven 进行启动
        缺点：只对Java代码进行生效，但是对页面的修改就不能生效
        这种方式的缺点是：springLoader热部署程序是在后台以进程的方式来运行，需要手动的关闭该进程
    方式二：在项目中直接使用jar包的方式进行使用
        把jar包添加到项目里面，然后使用命令-Javaagent:.\lib\springloaded.jar -noverify    
    DevTools工具
        springloader和devTools的区别
            springloader在部署项目的时候使用的是热部署的方式  
            DevTools在部署项目时使用的是重新部署的方式
**springBoot缓存技术**
    springBoot整合Ehcache
    springBoot整合spring data Redis 
springBoot整合springdatajpa                
            