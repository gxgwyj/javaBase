package com.xyz.java.base.framework.spring.config;

import com.xyz.java.base.framework.spring.component.TestBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoxugang
 * @data 2020/1/5  21:14
 * @description spring后置处理器
 */

@Configuration
public class SpringConfiguration {

    private static int i;

    @Bean
    @Qualifier("public")
    public TestBean publicInstance() {
        System.out.println("publicInstance");
        return new TestBean("publicInstance");
    }

}
