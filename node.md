springboot启动会扫描以下位置的配置文件作为springboot项目的配置文件 file:./config/ file:./ classpath:/config/ classpath:/
以上顺序按照优先级从高到低的顺序,所有的配置文件都会被加载,高优先级的配置内容会覆盖低优先级的内容 也可以通过配
spring.config.location来改变默认的配置 springboot会从四个位置加载配置文件,互补配置 可以使用spring.config.location改变默认
配置文件位置。在项目打包好以后,可以使用命令的方式在启动项目的时候指定配置文件的新位置 指定位置的配置文件,和默认加载的配置文件会一起
作用形成互补配置 
springboot外部配置方式加载顺序 1、命令行参数 2、来自java:comp/env的JNDI属性 3、Java系统属性(System.getProperties()) 4、
作系统环境变量 5、RandomValuePropertySource配置的random.*属性值 6、!jar包外部的application-{profile}.properties
application.yml(带spring.profile)配置文件 7、!jar包内部的application-{profile}.properties或application.yml(
spring.profile)配置文件 8、!jar包外部的application.properties或application.yml(不带spring.profile)配置文件 9、!jar包
部的application.properties或application.yml(不带spring.profile)配置文件 10、@Configuration注解类上方的@PropertySource
11、通过SpringApplication.setDefaultProperties制定的默认属性 
springboot自动配置原理 1、Springboot启动的时候加载住配置类,开启了自动配置功能@EnableAutoConfiguration 2
@EnableAutoConfiguration作用: 使用AutoConfigurationImportSelector给容器中导入组件,导入的组件查看selectImports的内
