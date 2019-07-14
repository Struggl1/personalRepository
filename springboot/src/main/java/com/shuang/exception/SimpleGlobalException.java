package com.shuang.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class SimpleGlobalException {

    @Bean
    public SimpleMappingExceptionResolver  getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mappiings = new Properties();
        /**
         *参数一：必须是异常类型的全名视图名称
         * 参数二：需要跳转的视图名
         */
        mappiings.put("java.lang.NullPointerException","error");
        //设置异常与视图映射信息
        resolver.setExceptionMappings(mappiings);
        return resolver;
    }
}
